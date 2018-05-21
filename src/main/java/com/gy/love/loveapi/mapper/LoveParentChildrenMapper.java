package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveParentChildren;

public interface LoveParentChildrenMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveParentChildren record);

    int insertSelective(LoveParentChildren record);

    LoveParentChildren selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveParentChildren record);

    int updateByPrimaryKey(LoveParentChildren record);
}