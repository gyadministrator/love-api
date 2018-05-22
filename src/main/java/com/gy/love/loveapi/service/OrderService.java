package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveOrder;
import com.gy.love.loveapi.entity.Page;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-21 22:21
 **/
public interface OrderService {
    LoveOrder findById(Integer id);
    PageInfo<LoveOrder> findAllByPage(Page page);
    void add(LoveOrder order);
    Boolean update(LoveOrder order);
    LoveOrder findByUserId(Integer userId);
}
