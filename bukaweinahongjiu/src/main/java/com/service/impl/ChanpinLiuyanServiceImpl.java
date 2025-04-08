package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.ChanpinLiuyanDao;
import com.entity.ChanpinLiuyanEntity;
import com.service.ChanpinLiuyanService;
import com.entity.view.ChanpinLiuyanView;

/**
 * 产品评价 服务实现类
 */
@Service("chanpinLiuyanService")
@Transactional
public class ChanpinLiuyanServiceImpl extends ServiceImpl<ChanpinLiuyanDao, ChanpinLiuyanEntity> implements ChanpinLiuyanService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ChanpinLiuyanView> page =new Query<ChanpinLiuyanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
