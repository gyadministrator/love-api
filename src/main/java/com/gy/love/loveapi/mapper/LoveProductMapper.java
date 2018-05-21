package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveProduct;

public interface LoveProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveProduct record);

    int insertSelective(LoveProduct record);

    LoveProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveProduct record);

    int updateByPrimaryKey(LoveProduct record);
}