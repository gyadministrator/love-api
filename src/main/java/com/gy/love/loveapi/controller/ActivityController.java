package com.gy.love.loveapi.controller;


import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveActivity;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.jwt.utils.Audience;
import com.gy.love.loveapi.service.ActivityService;
import com.gy.love.loveapi.service.UserService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.Date;
import java.util.List;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;


@RestController
@RequestMapping("/activity")
@Api(value = "活动管理")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;

    @Autowired
    private Audience audienceEntity;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "活动添加")
    @PostMapping
    public SimpleResponse add(@RequestBody @Valid LoveActivity activity, @CurrentUser LoveUser user){

        activityService.add(activity,user);

        return simpleResponse(200);
    }

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    @ApiOperation(value = "活动查找ById")
    @GetMapping("/id/{id}")
    public SimpleResponse findById(@PathVariable("id")Integer id){

        LoveActivity activity=null;

        try {
            activity = activityService.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200,"",activity);
    }

    /**
     * 根据时间查找
     * @param date  时间，精确到日即可，如：2018-05-20
     * @param user 用户id
     * @return
     */
    @ApiOperation(value = "活动查找ByDate")
    @GetMapping("/date/{Date}")
    public SimpleResponse findByDate(@PathVariable("Date")String date,@CurrentUser LoveUser user){

        List<LoveActivity> activityList=null;

        try {

            List<LoveUser> family=userService.findFamilyById(user.getId());

            activityList = activityService.findByDate(date,family);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200,"",activityList);
    }

    /**
     * 分页查找
     * @param page 分页，page：页面号，默认1；pageSize：页面大小，默认10；column：列，默认id；keyword：关键字，默认空
     * @return
     */
    @ApiOperation(value = "活动分页")
    @GetMapping
    public SimpleResponse findByPage(Page page){

        PageInfo<LoveActivity> info=null;

        try {
            info=activityService.findAllByPage(page);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200,"",info);
    }

}
