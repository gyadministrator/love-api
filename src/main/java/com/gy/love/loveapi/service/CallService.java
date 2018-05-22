package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveCall;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;

import java.util.List;

/**
 * @author ran
 * @Description: ${todo}
 * @date 2018/5/2216:52
 */
public interface CallService {
    PageInfo<LoveCall> findAllByPage(Page page, LoveUser user);
}
