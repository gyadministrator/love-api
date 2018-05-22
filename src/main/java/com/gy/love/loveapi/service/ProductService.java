package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveProduct;
import com.gy.love.loveapi.entity.Page;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-21 22:53
 **/
public interface ProductService {
    LoveProduct findById(Integer id);
    PageInfo<LoveProduct> findAllPage(Page page);
}
