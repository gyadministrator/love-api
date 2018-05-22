package com.gy.love.loveapi.service;

import com.gy.love.loveapi.entity.LoveExpress;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-22 15:20
 **/
public interface ExpressService {
    LoveExpress findById(Integer id);
    void add(LoveExpress loveExpress);
}
