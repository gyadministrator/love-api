package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveDetail;

public interface LoveDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveDetail record);

    int insertSelective(LoveDetail record);

    LoveDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveDetail record);

    int updateByPrimaryKey(LoveDetail record);
}