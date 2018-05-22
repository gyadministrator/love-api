package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveDetail;
import com.gy.love.loveapi.entity.Page;

import java.util.List;

public interface LoveDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveDetail record);

    int insertSelective(LoveDetail record);

    LoveDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveDetail record);

    int updateByPrimaryKey(LoveDetail record);

    List<LoveDetail> findByActivityId(Integer id);

    List<LoveDetail> findAllByPage(Page page);
}