package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveOrder;

public interface LoveOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveOrder record);

    int insertSelective(LoveOrder record);

    LoveOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveOrder record);

    int updateByPrimaryKey(LoveOrder record);
}