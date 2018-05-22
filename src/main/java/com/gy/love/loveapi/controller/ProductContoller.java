package com.gy.love.loveapi.controller;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveProduct;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.ProductService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @Tema :1024
 * @Author :ZhaoRongKun
 * @Date : 2018-05-22 14:05
 **/
@RestController
@RequestMapping("/product")
@Api(value = "商品")
public class ProductContoller {
    @Autowired
    private ProductService productService;

    /**
     * 通过商品id查找商品
     * @param id
     * @return
     */
    @ApiOperation(value = "商品id查找")
    @GetMapping("id/{id}")
    public SimpleResponse findByid(@PathVariable("id")Integer id){
        LoveProduct product = null;
        try{
            product = productService.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",product);
    }

    /**
     * 商品分页
     * @param page
     * @return
     */
    @ApiOperation(value = "分页查找")
    @GetMapping
    public SimpleResponse findAllPage(Page page){
        PageInfo<LoveProduct> pageInfo=null;
        try{
            pageInfo= productService.findAllPage(page);
        }catch (Exception e){
            e.printStackTrace();
        }
        return simpleResponse(200,"",pageInfo);
    }
}
