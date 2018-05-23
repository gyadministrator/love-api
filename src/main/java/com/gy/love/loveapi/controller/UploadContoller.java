package com.gy.love.loveapi.controller;

import com.alibaba.fastjson.JSON;
import com.gy.love.loveapi.utils.AliyunOSSUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadContoller {

    @ApiOperation(value = "图片上传")
    @PostMapping(value="/image",produces = {"application/json;charset=utf-8"})
    public String image(MultipartFile file, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        try {
            AliyunOSSUtil aliyunOSSUtil=new AliyunOSSUtil();
            String image=aliyunOSSUtil.uploadFile(file,"image");

            image="https://love-api-1.oss-cn-beijing.aliyuncs.com/image/"+image;

            map.put("code",200);
            map.put("image",image);
        } catch (Exception e) {
            map.put("code",-1);
            e.printStackTrace();
        }

        String result= JSON.toJSONString(map);

        return result;
    }
}
