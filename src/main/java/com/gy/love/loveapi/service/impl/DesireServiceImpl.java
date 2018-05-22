package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveDesire;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveDesireMapper;
import com.gy.love.loveapi.service.DesireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class DesireServiceImpl implements DesireService {
    @Autowired
    private LoveDesireMapper loveDesireMapper;

    @Override
    public LoveDesire findById(Integer id) {
        return loveDesireMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<LoveDesire> findAllByPage(Page page) {
        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveDesire> all=loveDesireMapper.findAllByPage(page);
        PageInfo<LoveDesire> result=new PageInfo<>(all);
        return result;
    }

    @Override
    public void add(LoveDesire loveDesire,@CurrentUser LoveUser loveUser) {

        loveDesire.setUserId(loveUser.getId());
       loveDesireMapper.insertSelective(loveDesire);
    }
}
