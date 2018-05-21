package com.gy.love.loveapi.controller;

import com.github.pagehelper.PageInfo;
import com.gy.love.loveapi.entity.LoveCourse;
import com.gy.love.loveapi.entity.Page;
import com.gy.love.loveapi.service.CourseService;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;
/**
 * @author Wuwemxin
 * @Description: ${todo}
 * @date 2018/5/22 0:40
 */
@RestController
@RequestMapping("/course")
@Api(value = "课程管理")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @ApiOperation(value = "课程添加")
    @PostMapping("/add")
    public SimpleResponse add(@RequestBody @Valid LoveCourse loveCourse) {
        courseService.add(loveCourse);
        return simpleResponse(200);
    }

    @ApiOperation(value = "课程分页")
    @GetMapping("/findByPage")
    public SimpleResponse findByPage(Page page) {

        PageInfo<LoveCourse> info = null;

        try {
            info = courseService.findAllBypage(page);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200, "", info);
    }

    @ApiOperation(value = "课程修改")
    @PostMapping("/updateCourseByCourseId")
    public SimpleResponse updateCourseBycourseId(@RequestBody @Valid LoveCourse loveCourse) {

        LoveCourse course = null;
        boolean flag = false;

        try {
            flag = courseService.updateByPrimarykey(loveCourse);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (flag) {
            return simpleResponse(200);
        }
        return simpleResponse(1001);
    }

    @ApiOperation(value = "课程详细查找")
    @GetMapping("/findDetailByCourseId")
    public SimpleResponse findDetailByCourseId(Integer courseId) {
System.out.print(courseId+"444");
        LoveCourse course = null;

        try {
            course =courseService.findById(courseId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200, "", course);
    }

}
