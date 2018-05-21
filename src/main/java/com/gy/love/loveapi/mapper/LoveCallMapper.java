package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveCall;

public interface LoveCallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveCall record);

    int insertSelective(LoveCall record);

    LoveCall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveCall record);

    int updateByPrimaryKey(LoveCall record);
}