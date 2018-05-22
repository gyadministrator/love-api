package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveOrder;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveOrderMapper;
import com.gy.love.loveapi.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-21 22:22
 **/
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private LoveOrderMapper loveOrderMapper;
    @Override
    public LoveOrder findById(Integer id) {
        return loveOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<LoveOrder> findAllByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveOrder> allByPage = loveOrderMapper.findAllByPage(page);

        PageInfo<LoveOrder> result=new PageInfo<>(allByPage);
        return result;
    }

    @Override
    public void add(LoveOrder order) {
    loveOrderMapper.insert(order);

    }

    @Override
    public Boolean update(LoveOrder order) {
        Boolean flag = false;
        if ( loveOrderMapper.updateByPrimaryKey(order)==1){
            flag=true;
        }
        return flag;
    }
}
