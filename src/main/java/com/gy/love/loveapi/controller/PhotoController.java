package com.gy.love.loveapi.controller;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LovePhoto;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.PhotoService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * 作者：qiguizhen
 * 邮箱：1757282455@qq.com
 */
@RestController
@RequestMapping("/photo")
@Api(value = "照片管理")
public class PhotoController {
    @Autowired
    PhotoService photoService;


    @ApiOperation(value = "照片添加")
    @PostMapping("/{albumId}/add")
    public SimpleResponse add(@RequestBody @Valid LovePhoto lovePhoto,@PathVariable("albumId") Integer albumId){

        photoService.add(lovePhoto,albumId);

        return simpleResponse(200);
    }

    /*
     * 根据相册id去查找所属照片
     * */
    @ApiOperation(value = "照片显示")
    @GetMapping("/{albumId}/pagePhoto")
    public  SimpleResponse pagePhoto(Page page,@PathVariable("albumId") Integer albumId){
        PageInfo<LovePhoto> info=null;
        try {
           info=photoService.findAllByPage(page,albumId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",info);
    }
}
