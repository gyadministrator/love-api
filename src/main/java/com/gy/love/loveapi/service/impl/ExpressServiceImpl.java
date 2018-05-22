package com.gy.love.loveapi.service.impl;

import com.gy.love.loveapi.entity.LoveExpress;
import com.gy.love.loveapi.mapper.LoveExpressMapper;
import com.gy.love.loveapi.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-22 15:23
 **/
@Service
public class ExpressServiceImpl implements ExpressService{
    @Autowired
    private LoveExpressMapper expressMapper;
    @Override
    public LoveExpress findById(Integer id) {
        return expressMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(LoveExpress loveExpress) {
    expressMapper.insert(loveExpress);
    }
}
