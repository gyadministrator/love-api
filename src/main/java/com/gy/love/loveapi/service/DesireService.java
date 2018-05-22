package com.gy.love.loveapi.service;


import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveDesire;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;

public interface DesireService {

    LoveDesire findById(Integer id);

    PageInfo<LoveDesire> findAllByPage(Page page);

    void add(LoveDesire loveDesire, LoveUser loveUser);


}
