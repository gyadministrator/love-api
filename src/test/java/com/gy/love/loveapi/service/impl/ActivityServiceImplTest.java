package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.LoveApiApplication;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveDetail;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.service.ActivityService;
import com.gy.love.loveapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;



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

    @Autowired
    private UserService userService;

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

    @Test
    public void findByDate(){

        List<LoveUser> family=userService.findFamilyById(2);

        List<LoveActivity> loveActivities=activityService.findByDate("2018-05-20",family);

        for (LoveActivity loveActivity : loveActivities) {

            System.out.println("--->"+loveActivity.getTitle());

            for (LoveDetail loveDetail : loveActivity.getDetails()) {
                System.out.println(loveDetail.getId());
            }

        }

    }
}