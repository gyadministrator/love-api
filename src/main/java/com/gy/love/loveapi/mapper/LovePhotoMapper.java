package com.gy.love.loveapi.mapper;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LovePhoto;
import com.gy.love.loveapi.entity.Page;

import java.util.List;
import java.util.Map;

public interface LovePhotoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LovePhoto record);

    int insertSelective(LovePhoto record);

    LovePhoto selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LovePhoto record);

    int updateByPrimaryKey(LovePhoto record);

    List<LovePhoto> findAllByPage(Page page,Integer albumId);
}