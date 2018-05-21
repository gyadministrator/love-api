package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveExpress;

public interface LoveExpressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveExpress record);

    int insertSelective(LoveExpress record);

    LoveExpress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveExpress record);

    int updateByPrimaryKey(LoveExpress record);
}