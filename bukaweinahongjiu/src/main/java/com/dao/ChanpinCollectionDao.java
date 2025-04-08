package com.dao;

import com.entity.ChanpinCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChanpinCollectionView;

/**
 * 产品收藏 Dao 接口
 *
 * @author 
 */
public interface ChanpinCollectionDao extends BaseMapper<ChanpinCollectionEntity> {

   List<ChanpinCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
