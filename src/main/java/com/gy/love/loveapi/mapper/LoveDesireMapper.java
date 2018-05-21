package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveDesire;

public interface LoveDesireMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveDesire record);

    int insertSelective(LoveDesire record);

    LoveDesire selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveDesire record);

    int updateByPrimaryKey(LoveDesire record);
}