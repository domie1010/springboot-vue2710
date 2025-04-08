package com.dao;

import com.entity.ChanpinLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinLiuyanView;

/**
 * 产品评价 Dao 接口
 *
 * @author 
 */
public interface ChanpinLiuyanDao extends BaseMapper<ChanpinLiuyanEntity> {

   List<ChanpinLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
