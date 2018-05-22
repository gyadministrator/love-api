package com.gy.love.loveapi.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LovePhoto;
import com.gy.love.loveapi.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * 作者：qiguizhen
 * 邮箱：1757282455@qq.com
 */
public interface PhotoService {

    void add(LovePhoto lovePhoto,Integer albumId);

    PageInfo<LovePhoto> findAllByPage(Page page,Integer albumId);
}
