package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveCourse;

public interface LoveCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveCourse record);

    int insertSelective(LoveCourse record);

    LoveCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveCourse record);

    int updateByPrimaryKey(LoveCourse record);
}