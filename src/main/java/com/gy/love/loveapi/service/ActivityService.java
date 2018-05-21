package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;

import java.util.Map;

public interface ActivityService{

    LoveActivity findById(Integer id);

    PageInfo<LoveActivity> findAllByPage(Page page);

    void add(LoveActivity activity, LoveUser user);
}
