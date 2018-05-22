package com.gy.love.loveapi.controller;


import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveDesire;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.DesireService;
import com.gy.love.loveapi.service.UserService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

@RestController
@RequestMapping("/desire")
@Api(value = "愿望墙")
public class DesireController {
    @Autowired
    private DesireService desireService;

    @Autowired
    private UserService userService;

    @ApiOperation(value ="添加愿望")
    @PostMapping
    public SimpleResponse add(@RequestBody @Valid LoveDesire loveDesire, @CurrentUser LoveUser loveUser){
        desireService.add(loveDesire,loveUser);
         return simpleResponse(200);
        }

    @ApiOperation(value = "查找愿望")
    @GetMapping("/{id}")
    public SimpleResponse findById(@PathVariable("id") Integer id){
        LoveDesire loveDesire=null;
        try {
            loveDesire=desireService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",loveDesire);
    }

    @ApiOperation(value = "愿望分页")
    @GetMapping
    public SimpleResponse findByPage(Page page){
        PageInfo<LoveDesire> info=null;
        try {
            info=desireService.findAllByPage(page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return simpleResponse(200,"",info);
    }

}

