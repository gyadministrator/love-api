package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveHelp;

public interface LoveHelpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveHelp record);

    int insertSelective(LoveHelp record);

    LoveHelp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveHelp record);

    int updateByPrimaryKey(LoveHelp record);
}