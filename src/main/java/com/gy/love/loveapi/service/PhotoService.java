package com.gy.love.loveapi.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LovePhoto;
import com.gy.love.loveapi.entity.Page;

import java.util.List;
import java.util.Map;


public interface PhotoService {

    void add(LovePhoto lovePhoto);

    List<LovePhoto> findAllPhotoByAlbumId(Integer albumId);
}
