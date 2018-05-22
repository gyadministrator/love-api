package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.*;
import com.gy.love.loveapi.mapper.LoveActivityMapper;
import com.gy.love.loveapi.mapper.LoveDetailMapper;
import com.gy.love.loveapi.mapper.LoveUserActivityMapper;
import com.gy.love.loveapi.mapper.LoveUserMapper;
import com.gy.love.loveapi.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
    private LoveDetailMapper detailMapper;

    @Autowired
    private LoveUserActivityMapper userActivityMapper;

    @Autowired
    private LoveUserMapper userMapper;

    @Override
    public PageInfo<LoveActivity> findAllByPage(Page page,List<LoveUser> family) {

        Map<String ,Object> parameter=new HashMap<>();
        parameter.put("page",page);
        parameter.put("users",family);

        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveActivity> all=activityMapper.findAllByPage(parameter);

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
    public List<LoveActivity> findByDate(String date,List<LoveUser> family) {

        Map<String ,Object> parameter=new HashMap<>();
        parameter.put("date",date);
        parameter.put("users",family);

        List<LoveActivity> activityList=activityMapper.findByDate(parameter);

        for (LoveActivity loveActivity : activityList) {
            loveActivity.setDetails(detailMapper.findByActivityId(loveActivity.getId()));
            loveActivity.setTarget(userMapper.selectByPrimaryKey(loveActivity.getTargetId()));
            for (LoveDetail loveDetail : loveActivity.getDetails()) {
                loveDetail.setUser(userMapper.selectByPrimaryKey(loveDetail.getUserId()));
            }
        }

        return activityList;
    }

    @Override
    public LoveActivity findById(Integer id) {

        LoveActivity activity=activityMapper.selectByPrimaryKey(id);

        List<LoveDetail> details=detailMapper.findByActivityId(id);

        for (LoveDetail detail : details) {
            detail.setUser(userMapper.selectByPrimaryKey(detail.getUserId()));
        }

        activity.setDetails(details);

        return activity;
    }
}
