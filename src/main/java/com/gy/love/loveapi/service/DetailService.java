package com.gy.love.loveapi.service;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveDetail;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;

import java.util.List;

public interface DetailService {

    LoveDetail findById(Integer id);

    PageInfo<LoveDetail> findAllByPage(Page page);

    void add(LoveDetail activity, LoveUser user);

}
