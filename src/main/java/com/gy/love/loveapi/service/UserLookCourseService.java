package com.gy.love.loveapi.service;

import com.gy.love.loveapi.entity.LoveUserLookCourse;

import java.util.List;

/**
 * @author Wuwemxin
 * @Description: ${todo}
 * @date 2018/5/22 10:38
 */
public interface UserLookCourseService {
    void add(LoveUserLookCourse loveUserLookCourse);
    List<LoveUserLookCourse> findAllByCourseId(String courseId);

}
