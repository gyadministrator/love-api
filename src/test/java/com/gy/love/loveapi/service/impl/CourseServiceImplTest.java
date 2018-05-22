package com.gy.love.loveapi.service.impl;
/**
 * @author Wuwemxin
 * @Description: ${todo}
 * @date 2018/5/22 0:40
 */
import com.gy.love.loveapi.LoveApiApplication;
import com.gy.love.loveapi.entity.LoveCourse;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.CourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LoveApiApplication.class)
public class CourseServiceImplTest {

    @Test
    public void findById() {
        LoveCourse loveCourse = new LoveCourse();
        loveCourse = courseServiceImpl.findById(001);
        System.out.print(loveCourse);
    }

    @Test
    public void findAllBypage() {
        Page page = new Page();
        System.out.print( courseServiceImpl.findAllBypage(page));


    }

    @Autowired
    private CourseService courseServiceImpl;

    @Test
    public void add() {
        LoveCourse loveCourse = new LoveCourse();
       /* loveCourse.setId(0011);*/
        loveCourse.setUrl("jjj");
        loveCourse.setDetail("ces");
        loveCourse.setNumber(100);
        loveCourse.setTeacher("lll");

        courseServiceImpl.add(loveCourse);
    }
    @Test
    public void updateByPrimarykey() {
        LoveCourse loveCourse = new LoveCourse();
        loveCourse.setId(001);
        loveCourse.setUrl("jjj55");
        loveCourse.setDetail("ces");
        loveCourse.setNumber(100);
        loveCourse.setTeacher("lll");
        courseServiceImpl.updateByPrimarykey(loveCourse);
    }
}