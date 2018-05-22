package com.gy.love.loveapi.controller;

import com.gy.love.loveapi.annotation.CurrentUser;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.entity.LoveUserLookCourse;
import com.gy.love.loveapi.service.UserLookCourseService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author Wuwemxin
 * @Description: ${todo}
 * @date 2018/5/22 10:49
 */
@RestController
@RequestMapping("/userLookCourse")
@Api(value = "课程观看记录管理")
public class UserLookCourseController {

    @Autowired
    private UserLookCourseService userLookCourseService;

    @ApiOperation(value = "课程观看记录添加")
    @PostMapping
    public SimpleResponse add(@RequestBody @Valid LoveUserLookCourse loveUserLookCourse,@CurrentUser LoveUser user) {
       loveUserLookCourse.setUserId(user.getId());
        userLookCourseService.add(loveUserLookCourse);
        return simpleResponse(200);
    }

    @ApiOperation(value = "通过课程ID查询课程的观看记录")
    @GetMapping("/courseId/{courseId}")
    public SimpleResponse findAllByCourseId(@PathVariable("courseId") String courseId) {

        List<LoveUserLookCourse> loveUserLookCourseList = null;

        try {

            loveUserLookCourseList = userLookCourseService.findAllByCourseId(courseId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200, "", loveUserLookCourseList);
    }
}
