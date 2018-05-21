package com.gy.love.loveapi.service.impl;

import com.gy.love.loveapi.LoveApiApplication;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author ran
 * @Description: ${todo}
 * @date 2018/5/221:00
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LoveApiApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void findFamilyById() {

        List<LoveUser> all=userService.findFamilyById(3);


        for (LoveUser loveUser : all) {
            System.out.println(loveUser.getName());
        }

    }
}