package com.gy.love.loveapi.controller;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.*;
import com.gy.love.loveapi.service.OrderService;
import com.gy.love.loveapi.service.ProductService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;
import java.util.Map;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-22 13:42
 **/
@RestController
@RequestMapping("/order")
@Api(value = "订单管理")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @ApiOperation(value = "订单添加")
    @PostMapping
    public SimpleResponse add(@RequestBody  LoveOrder order, @CurrentUser LoveUser loveUser){
        order.setDate(new Date());
        order.setUserId(loveUser.getId());
        orderService.add(order);
        return simpleResponse(200);
    }

    /**
     * 跟据id查找
     * @param id
     * @return
     */
    @ApiOperation(value = "订单查找id")
    @GetMapping("id/{id}")
    public SimpleResponse findById(@PathVariable("id")Integer id){
        LoveOrder order = null;
        try{
            order= orderService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",order);
    }

    /**
     * 根据用户id查找订单
     * @param user
     * @return
     */
    @ApiOperation(value = "订单查找userId")
    @GetMapping("/userId")
    public SimpleResponse findByUserId(@CurrentUser LoveUser user){
        LoveOrder order = null;
        try{
            order= orderService.findByUserId(user.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",order);
    }
    /**
     * 订单分页
     * @param page
     * @return
     */
    @ApiOperation(value = "分页查找")
    @GetMapping("/page")
    public SimpleResponse findAllPage(Page page){
        PageInfo<LoveOrder> pageInfo=null;
        try{
            pageInfo= orderService.findAllByPage(page);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",pageInfo);
    }
}
