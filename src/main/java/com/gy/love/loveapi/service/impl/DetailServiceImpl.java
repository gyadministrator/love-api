package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.*;
import com.gy.love.loveapi.mapper.LoveActivityMapper;
import com.gy.love.loveapi.mapper.LoveDetailMapper;
import com.gy.love.loveapi.mapper.LoveUserActivityMapper;
import com.gy.love.loveapi.mapper.LoveUserMapper;
import com.gy.love.loveapi.service.ActivityService;
import com.gy.love.loveapi.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class DetailServiceImpl implements DetailService {

    @Autowired
    private LoveDetailMapper detailMapper;

    @Autowired
    private LoveUserMapper userMapper;

    @Override
    public LoveDetail findById(Integer id) {

        LoveDetail detail=detailMapper.selectByPrimaryKey(id);

        if(detail==null) {
            return null;
        }else{
            detail.setUser(userMapper.selectByPrimaryKey(detail.getUserId()));
            return detail;
        }
    }

    @Override
    public PageInfo<LoveDetail> findAllByPage(Page page) {

        PageHelper.startPage(page.getPage(),page.getPageSize());

        Map<String ,Object> parameter=new HashMap<>();

        parameter.put("page",page);


        List<LoveDetail> all=detailMapper.findAllByPage(page);

        for (LoveDetail loveDetail : all) {
            loveDetail.setUser(userMapper.selectByPrimaryKey(loveDetail.getUserId()));
        }

        PageInfo<LoveDetail> result=new PageInfo<>(all);

        return result;
    }

    @Override
    public void add(LoveDetail detail, LoveUser user) {
        detail.setUserId(user.getId());
        detail.setDate(new Date());
        detailMapper.insertSelective(detail);
    }

}
