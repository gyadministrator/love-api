package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.LoveUserActivity;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveActivityMapper;
import com.gy.love.loveapi.mapper.LoveUserActivityMapper;
import com.gy.love.loveapi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author gaoyun
 * 2018/4/18 10:57
 * 描述:
 */
@Service
public class ActivityServiceImpl implements ActivityService{

    @Autowired
    private LoveActivityMapper activityMapper;

    @Autowired
    private LoveUserActivityMapper userActivityMapper;

    @Override
    public PageInfo<LoveActivity> findAllByPage(Page page) {

        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveActivity> all=activityMapper.findAllByPage(page);

        PageInfo<LoveActivity> result=new PageInfo<>(all);

        return result;
    }

    @Override
    public void add(LoveActivity activity, LoveUser user) {

        activity.setIsNoticed(false);

        activityMapper.insertSelective(activity);

        LoveUserActivity loveUserActivity=new LoveUserActivity();
        loveUserActivity.setActivityId(activity.getId());
        loveUserActivity.setUserId(user.getId());

        userActivityMapper.insertSelective(loveUserActivity);
    }

    @Override
    public LoveActivity findById(Integer id) {
        return activityMapper.selectByPrimaryKey(id);
    }
}
