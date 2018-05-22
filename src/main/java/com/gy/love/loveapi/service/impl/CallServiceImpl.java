package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveCall;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LoveCallMapper;
import com.gy.love.loveapi.mapper.LoveUserMapper;
import com.gy.love.loveapi.service.CallService;
import com.gy.love.loveapi.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author ran
 * @Description: ${todo}
 * @date 2018/5/2216:52
 */
@Service
public class CallServiceImpl implements CallService {

    @Autowired
    private LoveCallMapper callMapper;

    @Autowired
    private LoveUserMapper userMapper;

    @Override
    public PageInfo<LoveCall> findAllByPage(Page page, LoveUser user) {
        PageHelper.startPage(page.getPage(),page.getPageSize());

        List<LoveCall> callList=callMapper.findByUserId(user.getId());

        for (LoveCall loveCall : callList) {
            loveCall.setChildren(userMapper.selectByPrimaryKey(loveCall.getChildrenId()));
            loveCall.setParent(userMapper.selectByPrimaryKey(loveCall.getParentId()));
        }

        return new PageInfo<>(callList);
    }
}
