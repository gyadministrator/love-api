package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.LoveApiApplication;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveDetail;
import com.gy.love.loveapi.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author ran
 * @Description: ${todo}
 * @date 2018/5/2123:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LoveApiApplication.class)
public class ActivityServiceImplTest {

    @Autowired
    private ActivityService activityService;

    @Test
    public void findAllByPage() {

    }

    @Test
    public void add() {
    }

    @Test
    public void findById() {

        LoveActivity loveActivity=activityService.findById(1);

        for (LoveDetail loveDetail : loveActivity.getDetails()) {

            System.out.println(loveDetail.getContent());
        }


    }
}