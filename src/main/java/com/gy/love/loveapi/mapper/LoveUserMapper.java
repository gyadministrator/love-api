package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveUser;

import java.util.Collection;
import java.util.List;

public interface LoveUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveUser record);

    int insertSelective(LoveUser record);

    LoveUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveUser record);

    int updateByPrimaryKey(LoveUser record);

    LoveUser findByUserName(String userName);

    List<LoveUser> findByChildrenId(Integer id);

    List<LoveUser> findByParentId(Integer id);
}