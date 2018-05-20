package com.gy.love.loveapi.controller;

import com.gy.love.loveapi.config.Constants;
import com.gy.love.loveapi.entity.User;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    private final UserService userService;

    private final Audience audienceEntity;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(UserService userService, Audience audienceEntity) {
        this.userService = userService;
        this.audienceEntity = audienceEntity;
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public SimpleResponse login(@RequestBody User user) {
        logger.info("登录的用户为:" + user.toString());
        Map<String, Object> map = new HashMap<>();
        User u = this.userService.findByName(user.getUserName());
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
    public SimpleResponse addUser(@RequestBody @Valid User user) {
        logger.info("添加用户---->" + user.toString());
        User u = this.userService.findByName(user.getUserName());
        if (u == null) {
            assert false;
            String pwd = Md5Utils.MD5(user.getPassword());
            user.setPassword(pwd);
            this.userService.saveReturnEntity(user);
            return simpleResponse(200);
        } else {
            return simpleResponse(500, "", "此用户名已经存在");
        }
    }
}
