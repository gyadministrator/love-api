package com.gy.love.loveapi.controller;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveCall;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.CallService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author ran
 * @Description: ${todo}
 * @date 2018/5/2216:46
 */
@RestController
@RequestMapping("/call")
public class CallController {

    @Autowired
    private CallService callService;

    @ApiOperation(value = "通话记录")
    @GetMapping
    public SimpleResponse findCallList(Page page, @CurrentUser LoveUser user){

        PageInfo<LoveCall> pageInfo=callService.findAllByPage(page,user);

        return simpleResponse(200,pageInfo);
    }

}
