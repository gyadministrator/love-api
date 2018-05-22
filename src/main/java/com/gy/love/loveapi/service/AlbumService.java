package com.gy.love.loveapi.service;


import com.gy.love.loveapi.entity.LoveAlbum;
import com.gy.love.loveapi.entity.LoveUser;

import java.util.List;

/**
 * 作者：qiguizhen
 * 邮箱：1757282455@qq.com
 */

public interface AlbumService {

    void add(LoveAlbum loveAlbum, LoveUser user);

    List<LoveAlbum> findAllbumByUserId(Integer userId);
}
