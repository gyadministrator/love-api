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
import java.util.List;
import java.util.Map;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;


@RestController
@RequestMapping("/photo")
@Api(value = "照片管理")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    @ApiOperation(value = "照片添加")
    @PostMapping
    public SimpleResponse add(@RequestBody @Valid LovePhoto lovePhoto){

        photoService.add(lovePhoto);

        return simpleResponse(200);
    }
}
