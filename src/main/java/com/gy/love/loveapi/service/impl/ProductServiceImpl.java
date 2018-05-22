package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveOrder;
import com.gy.love.loveapi.entity.LoveProduct;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveProductMapper;
import com.gy.love.loveapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-21 22:53
 **/
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private LoveProductMapper loveProductMapper;

    @Override
    public LoveProduct findById(Integer id) {
        return loveProductMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<LoveProduct> findAllPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveProduct> allByPage =loveProductMapper.findAllByPage(page);

        PageInfo<LoveProduct> result=new PageInfo<>(allByPage);
        return result;

    }
}
