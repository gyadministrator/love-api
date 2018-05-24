package com.gy.love.loveapi.service;


import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveDesire;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;

import java.util.Map;

public interface DesireService {

    LoveDesire findById(Integer id);

    PageInfo<Map<String, Object>> findAllByPage(Page page);

    void add(LoveDesire loveDesire, LoveUser loveUser);


}
