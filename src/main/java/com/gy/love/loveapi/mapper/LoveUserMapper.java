package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveUser;

public interface LoveUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveUser record);

    int insertSelective(LoveUser record);

    LoveUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveUser record);

    int updateByPrimaryKey(LoveUser record);

    LoveUser findByUserName(String userName);
}