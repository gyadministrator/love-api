package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LovePhoto;

public interface LovePhotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LovePhoto record);

    int insertSelective(LovePhoto record);

    LovePhoto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LovePhoto record);

    int updateByPrimaryKey(LovePhoto record);
}