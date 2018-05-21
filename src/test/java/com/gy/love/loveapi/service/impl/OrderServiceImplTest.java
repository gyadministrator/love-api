package com.gy.love.loveapi.service.impl;

import com.gy.love.loveapi.entity.LoveOrder;
import com.gy.love.loveapi.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-21 22:55
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderService orderService;
    @Test
    public void findById() {

        LoveOrder byId = orderService.findById(1);
        System.out.println(byId.toString());
    }

    @Test
    public void findAllByPage() {
    }

    @Test
    public void add() {
        LoveOrder loveOrder = new LoveOrder();
        loveOrder.setId(1);
        loveOrder.setAddress("ashdakjsd");
        loveOrder.setNumber(68);
        orderService.add(loveOrder);
    }

    @Test
    public void update() {
        LoveOrder loveOrder= new LoveOrder();
        loveOrder.setNumber(45);
        loveOrder.setId(1);
        Boolean update = orderService.update(loveOrder);
        System.out.println(update);
    }
}