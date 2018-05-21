package com.gy.love.loveapi.service.impl;
/**
 * @author Wuwemxin
 * @Description: ${todo}
 * @date 2018/5/22 0:40
 */
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveCourse;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveCourseMapper;
import com.gy.love.loveapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private LoveCourseMapper courseMapper;

    @Override
    public LoveCourse findById(Integer id) {
        return courseMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<LoveCourse> findAllBypage(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveCourse> all=courseMapper.findAllByPage(page);

        PageInfo<LoveCourse> result=new PageInfo<>(all);

        return result;
    }

    @Override
    public void add(LoveCourse loveCourse) {
        courseMapper.insertSelective(loveCourse);
    }

    @Override
    public boolean updateByPrimarykey(LoveCourse loveCourse) {
        boolean flag = false;
        int influenceNum = courseMapper.updateByPrimaryKey(loveCourse);
        /**
         * 修改成功返回true
         */
        if (influenceNum == 1){
            flag=true;
        }

        return flag;
    }
}
