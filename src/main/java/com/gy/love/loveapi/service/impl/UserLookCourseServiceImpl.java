package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveUserLookCourse;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveCourseMapper;
import com.gy.love.loveapi.mapper.LoveUserLookCourseMapper;
import com.gy.love.loveapi.mapper.LoveUserMapper;
import com.gy.love.loveapi.service.UserLookCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wuwemxin
 * @Description: ${todo}
 * @date 2018/5/22 10:40
 */
@Service
public class UserLookCourseServiceImpl implements UserLookCourseService {
    @Autowired
    private LoveUserLookCourseMapper loveUserLookCourseMapper;
    @Override

    public void add(LoveUserLookCourse loveUserLookCourse) {
        loveUserLookCourseMapper.insertSelective(loveUserLookCourse);
    }

    @Override
    public List<LoveUserLookCourse> findAllByCourseId(String courseId) {

        List<LoveUserLookCourse> loveUserLookCoursesList = loveUserLookCourseMapper.findAllByCourseId(courseId);

        return loveUserLookCoursesList;

    }
}
