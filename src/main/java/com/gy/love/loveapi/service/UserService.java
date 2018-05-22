package com.gy.love.loveapi.service;

import com.gy.love.loveapi.entity.LoveParentChildren;
import com.gy.love.loveapi.entity.LoveUser;
import org.apache.catalina.User;

import java.util.List;

/**
 * @author gaoyun
 * 2018/4/18 10:57
 * 描述:
 */
public interface UserService{
    /**
     * 通过id查询用户
     *
     * @param userName 用户名
     * @return
     */
    LoveUser findByName(String userName);

    /**
     * 解析token
     *
     * @param token 用户登录返回的token
     * @return
     */
    String parseToken(String token);

    /**
     * 通过ID查找
     * @param id
     * @return
     */
    LoveUser findById(Integer id) throws Exception;

    void add(LoveUser u);

    LoveUser findByUserName(String userName);

    List<LoveUser> findFamilyById(Integer id);

    /**
     * 添加亲属
     * @param type  类型，0：成为当前用户的家长；1：成为当前用户的孩子
     * @param id    被添加的用户ID
     * @param user  当前用户
     * @return
     */
    void addFamily(Integer type,Integer id,LoveUser user) throws Exception;
}