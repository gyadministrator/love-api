package com.gy.love.loveapi.mapper;

import com.gy.love.loveapi.entity.LoveAlbum;

import java.util.List;

public interface LoveAlbumMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoveAlbum record);

    int insertSelective(LoveAlbum record);

    LoveAlbum selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoveAlbum record);

    int updateByPrimaryKey(LoveAlbum record);

    List<LoveAlbum> findAllbumByUserId(Integer userId);

}