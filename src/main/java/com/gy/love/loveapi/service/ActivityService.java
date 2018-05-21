package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ActivityService{

    LoveActivity findById(Integer id);

    PageInfo<LoveActivity> findAllByPage(Page page);

    void add(LoveActivity activity, LoveUser user);

    /**
     * 通过时间查找
     * @param date  时间
     * @param family 用户List
     * @return
     */
    List<LoveActivity> findByDate(String date,List<LoveUser> family);
}
