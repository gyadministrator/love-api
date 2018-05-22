package com.gy.love.loveapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LovePhoto;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.mapper.LovePhotoMapper;
import com.gy.love.loveapi.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 作者：qiguizhen
 * 邮箱：1757282455@qq.com
 */
@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    LovePhotoMapper lovePhotoMapper;

    @Override
    public void add(LovePhoto lovePhoto) {

        lovePhotoMapper.insertSelective(lovePhoto);
    }

    @Override
    public List<LovePhoto> findAllPhotoByAlbumId(Integer albumId) {

       List<LovePhoto> lovePhotoList=lovePhotoMapper.findAllPhotoByAlbumId(albumId);

       return lovePhotoList;
    }

}
