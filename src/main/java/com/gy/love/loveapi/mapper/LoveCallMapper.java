package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveCall;
import com.gy.love.loveapi.entity.LoveUser;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface LoveCallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveCall record);

    int insertSelective(LoveCall record);

    LoveCall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveCall record);

    int updateByPrimaryKey(LoveCall record);

    List<LoveCall> findByUserId(Integer id);
}