package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveUserLookCourse;
import com.gy.love.loveapi.entity.Page;

import java.util.List;

public interface LoveUserLookCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveUserLookCourse record);

    int insertSelective(LoveUserLookCourse record);

    LoveUserLookCourse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveUserLookCourse record);

    int updateByPrimaryKey(LoveUserLookCourse record);
    List<LoveUserLookCourse> findAllByCourseId(String courseId);
}