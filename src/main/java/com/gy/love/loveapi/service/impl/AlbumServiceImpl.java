package com.gy.love.loveapi.service.impl;

import com.gy.love.loveapi.entity.LoveAlbum;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.mapper.LoveAlbumMapper;
import com.gy.love.loveapi.mapper.LovePhotoMapper;
import com.gy.love.loveapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.Mapping;

import java.util.Date;
import java.util.List;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * 作者：qiguizhen
 * 邮箱：1757282455@qq.com
 */
@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    LoveAlbumMapper loveAlbumMapper;

    @Autowired
    private LovePhotoMapper photoMapper;

    @Override
    public void add(LoveAlbum loveAlbum, LoveUser user) {
        loveAlbum.setUserId(user.getId());
        loveAlbum.setCreateDate(new Date());
        loveAlbumMapper.insertSelective(loveAlbum);
    }

    @Override
    public List<LoveAlbum> findAllbumByUserId(Integer userId) {
        return loveAlbumMapper.findAllbumByUserId(userId);
    }

    @Override
    public LoveAlbum findById(Integer id) {

        LoveAlbum album=loveAlbumMapper.selectByPrimaryKey(id);

        album.setPhotos(photoMapper.findAllPhotoByAlbumId(id));

        return album;
    }


}
