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

    @ApiOperation(value = "活动查找")
    @GetMapping("/{id}")
    public SimpleResponse findById(@PathVariable("id")Integer id){

        LoveActivity activity=null;

        try {
            activity = activityService.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200,"",activity);
    }

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

    /**
     * 根据活动ID查找所有详细
     * @param activityId   活动ID
     * @return
     */
    @ApiOperation(value = "活动详细查找")
    @GetMapping("/{activityId}/detail")
    public SimpleResponse findDetailByActivityId(@PathVariable("activityId")Integer activityId){

        LoveActivity activity=null;

        try {
            //activity = this.activityService.queryById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200,"",activity);
    }


}
