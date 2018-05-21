package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveCourse;
import com.gy.love.loveapi.entity.Page;

public interface CourseService {
    LoveCourse findById(Integer id);

    PageInfo<LoveCourse> findAllBypage(Page page);

    void add(LoveCourse loveCourse);
    boolean updateByPrimarykey(LoveCourse loveCourse);
}
