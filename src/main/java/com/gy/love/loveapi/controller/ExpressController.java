package com.gy.love.loveapi.controller;

import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveExpress;
import com.gy.love.loveapi.entity.LoveOrder;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.service.ExpressService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-22 15:26
 **/
@RestController
@RequestMapping("/express")
@Api(value = "快递方式")
public class ExpressController {
    @Autowired
    private ExpressService expressService;

    @ApiOperation(value = "快递方式添加")
    @PostMapping
    public SimpleResponse add(@RequestBody @Valid LoveExpress loveExpress){
        expressService.add(loveExpress);
        return simpleResponse(200);
    }
    @ApiOperation(value = "快递方式查找id")
    @GetMapping("id/{id}")
    public SimpleResponse findById(@PathVariable("id")Integer id){
        LoveExpress express = null;
        try{
            express = expressService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",express);
    }

}
