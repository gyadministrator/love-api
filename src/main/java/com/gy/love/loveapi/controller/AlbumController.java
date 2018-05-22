package com.gy.love.loveapi.controller;

import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveAlbum;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.AlbumService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * 作者：qiguizhen
 * 邮箱：1757282455@qq.com
 */
@RestController
@RequestMapping("/album")
@Api(value = "相册管理")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "相册添加")
    @PostMapping("/add")
    public SimpleResponse add(@RequestBody  @Valid LoveAlbum loveAlbum, @CurrentUser LoveUser user) {

            albumService.add(loveAlbum, user);

            return simpleResponse(200);
    }

    //根据自己的userid显示自己所拥有的相册列表
    @ApiOperation(value = "相册显示")
    @GetMapping()
    public  SimpleResponse findByUserId(@CurrentUser LoveUser user){

        List<LoveAlbum> list=albumService.findAllbumByUserId(user.getId());

        return simpleResponse(200,"",list);

    }
}
