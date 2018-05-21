package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveUserActivity;

public interface LoveUserActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveUserActivity record);

    int insertSelective(LoveUserActivity record);

    LoveUserActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveUserActivity record);

    int updateByPrimaryKey(LoveUserActivity record);
}