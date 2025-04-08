package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ChanpinCollectionEntity;

import com.service.ChanpinCollectionService;
import com.entity.view.ChanpinCollectionView;
import com.service.ChanpinService;
import com.entity.ChanpinEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 产品收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chanpinCollection")
public class ChanpinCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(ChanpinCollectionController.class);

    @Autowired
    private ChanpinCollectionService chanpinCollectionService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private ChanpinService chanpinService;
    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = chanpinCollectionService.queryPage(params);

        //字典表数据转换
        List<ChanpinCollectionView> list =(List<ChanpinCollectionView>)page.getList();
        for(ChanpinCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinCollectionEntity chanpinCollection = chanpinCollectionService.selectById(id);
        if(chanpinCollection !=null){
            //entity转view
            ChanpinCollectionView view = new ChanpinCollectionView();
            BeanUtils.copyProperties( chanpinCollection , view );//把实体数据重构到view中

            //级联表
            ChanpinEntity chanpin = chanpinService.selectById(chanpinCollection.getChanpinId());
            if(chanpin != null){
                BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setChanpinId(chanpin.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(chanpinCollection.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChanpinCollectionEntity chanpinCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chanpinCollection:{}",this.getClass().getName(),chanpinCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            chanpinCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        Wrapper<ChanpinCollectionEntity> queryWrapper = new EntityWrapper<ChanpinCollectionEntity>()
            .eq("chanpin_id", chanpinCollection.getChanpinId())
            .eq("yonghu_id", chanpinCollection.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinCollectionEntity chanpinCollectionEntity = chanpinCollectionService.selectOne(queryWrapper);
        if(chanpinCollectionEntity==null){
            chanpinCollection.setInsertTime(new Date());
            chanpinCollection.setCreateTime(new Date());
            chanpinCollectionService.insert(chanpinCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChanpinCollectionEntity chanpinCollection, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chanpinCollection:{}",this.getClass().getName(),chanpinCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            chanpinCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        //根据字段查询是否有相同数据
        Wrapper<ChanpinCollectionEntity> queryWrapper = new EntityWrapper<ChanpinCollectionEntity>()
            .notIn("id",chanpinCollection.getId())
            .andNew()
            .eq("chanpin_id", chanpinCollection.getChanpinId())
            .eq("yonghu_id", chanpinCollection.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinCollectionEntity chanpinCollectionEntity = chanpinCollectionService.selectOne(queryWrapper);
        if(chanpinCollectionEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chanpinCollection.set
            //  }
            chanpinCollectionService.updateById(chanpinCollection);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chanpinCollectionService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }



    /**
    * 前端列表
    */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role)){
            return R.error(511,"权限为空");
        }
        else if("用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = chanpinCollectionService.queryPage(params);

        //字典表数据转换
        List<ChanpinCollectionView> list =(List<ChanpinCollectionView>)page.getList();
        for(ChanpinCollectionView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChanpinCollectionEntity chanpinCollection = chanpinCollectionService.selectById(id);
            if(chanpinCollection !=null){
                //entity转view
                ChanpinCollectionView view = new ChanpinCollectionView();
                BeanUtils.copyProperties( chanpinCollection , view );//把实体数据重构到view中

                //级联表
                    ChanpinEntity chanpin = chanpinService.selectById(chanpinCollection.getChanpinId());
                if(chanpin != null){
                    BeanUtils.copyProperties( chanpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setChanpinId(chanpin.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(chanpinCollection.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ChanpinCollectionEntity chanpinCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,chanpinCollection:{}",this.getClass().getName(),chanpinCollection.toString());
        Wrapper<ChanpinCollectionEntity> queryWrapper = new EntityWrapper<ChanpinCollectionEntity>()
            .eq("chanpin_id", chanpinCollection.getChanpinId())
            .eq("yonghu_id", chanpinCollection.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChanpinCollectionEntity chanpinCollectionEntity = chanpinCollectionService.selectOne(queryWrapper);
        if(chanpinCollectionEntity==null){
            chanpinCollection.setInsertTime(new Date());
            chanpinCollection.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      chanpinCollection.set
        //  }
        chanpinCollectionService.insert(chanpinCollection);
            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }





}

