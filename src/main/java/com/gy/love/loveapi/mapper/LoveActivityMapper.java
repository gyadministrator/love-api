package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.Page;

import java.util.List;

public interface LoveActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveActivity record);

    int insertSelective(LoveActivity record);

    LoveActivity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveActivity record);

    int updateByPrimaryKey(LoveActivity record);

    List<LoveActivity> findAllByPage(Page page);
}