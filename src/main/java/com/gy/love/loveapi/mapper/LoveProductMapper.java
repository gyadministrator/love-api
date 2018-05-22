package com.gy.love.loveapi.mapper;


import com.gy.love.loveapi.entity.LoveProduct;
import com.gy.love.loveapi.entity.Page;

import java.util.List;

public interface LoveProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveProduct record);

    int insertSelective(LoveProduct record);

    LoveProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveProduct record);

    int updateByPrimaryKey(LoveProduct record);
    List<LoveProduct> findAllByPage(Page page);
}