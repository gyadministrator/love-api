package com.gy.love.loveapi.controller;

import com.gy.love.loveapi.config.Constants;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.jwt.utils.AccessToken;
import com.gy.love.loveapi.jwt.utils.Audience;
import com.gy.love.loveapi.jwt.utils.JwtUtils;
import com.gy.love.loveapi.service.UserService;
import com.gy.love.loveapi.utils.Md5Utils;
import com.gy.love.loveapi.utils.response.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static com.gy.love.loveapi.utils.response.HttpResponseAndStatus.simpleResponse;

/**
 * @author gaoyun
 * 2018/4/18 12:46
 * 描述:
 */
@RestController
@RequestMapping("/user")
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Audience audienceEntity;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public SimpleResponse login(@RequestBody LoveUser user) {
        logger.info("登录的用户为:" + user.toString());
        Map<String, Object> map = new HashMap<>();
        LoveUser u = this.userService.findByUserName(user.getUserName());
        String accessToken = null;
        if (u != null) {
            map.put("user", u);
            String pwd = u.getPassword();
            String md5Pwd = Md5Utils.MD5(user.getPassword());
            if (pwd.equals(md5Pwd)) {
                accessToken = JwtUtils.createJWT(
                        u.getUserName(),
                        u.getName(),
                        audienceEntity.getClientId(),
                        audienceEntity.getName(),
                        audienceEntity.getExpiresSecond() * 1000,
                        audienceEntity.getBase64Secret());
                //返回accessToken
                AccessToken accessTokenEntity = new AccessToken();
                accessTokenEntity.setAccess_token(accessToken);
                accessTokenEntity.setExpires_in(audienceEntity.getExpiresSecond());
                accessTokenEntity.setToken_type(Constants.BEARER);

                map.put("token", accessToken);
            }
        }
        assert u != null;
        return simpleResponse(200, "", map);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    public SimpleResponse addUser(@RequestBody @Valid LoveUser user) {
        logger.info("添加用户---->" + user.toString());
        LoveUser u = this.userService.findByName(user.getUserName());
        if (u == null) {
            assert false;
            String pwd = Md5Utils.MD5(user.getPassword());
            user.setPassword(pwd);
            userService.add(user);
            return simpleResponse(200);
        } else {
            return simpleResponse(500, "", "此用户名已经存在");
        }
    }


    @ApiOperation(value="通过ID查找")
    @GetMapping("/{id}")
    public SimpleResponse findById(@PathVariable("id")Integer id){

        LoveUser user=new LoveUser();
        try {
            user=this.userService.findById(id);

            System.out.println("--->"+user.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return simpleResponse(200,"",user);
    }
}
