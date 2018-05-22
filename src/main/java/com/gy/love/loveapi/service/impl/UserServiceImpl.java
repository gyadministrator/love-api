package com.gy.love.loveapi.service.impl;

import com.gy.love.loveapi.entity.LoveParentChildren;
import com.gy.love.loveapi.entity.LoveUser;
import com.gy.love.loveapi.jwt.utils.Audience;
import com.gy.love.loveapi.jwt.utils.JwtUtils;
import com.gy.love.loveapi.mapper.LoveParentChildrenMapper;
import com.gy.love.loveapi.mapper.LoveUserMapper;
import com.gy.love.loveapi.service.UserService;
import io.jsonwebtoken.Claims;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author gaoyun
 * 2018/4/18 10:57
 * 描述:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoveUserMapper userMapper;

    @Autowired
    private LoveParentChildrenMapper parentChildrenMapper;

    @Autowired
    private Audience audienceEntity;

    @Override
    public LoveUser findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }
    @Override
    public void add(LoveUser u) {
        userMapper.insertSelective(u);
    }
    @Override
    public List<LoveUser> findFamilyById(Integer id) {
        List<LoveUser> family=new ArrayList<>();
        family.addAll(userMapper.findByChildrenId(id));
        family.addAll(userMapper.findByParentId(id));

        List<LoveUser> temp=new ArrayList<>();
        for (LoveUser loveUser : family) {
            temp.addAll(userMapper.findByChildrenId(loveUser.getId()));
            temp.addAll(userMapper.findByParentId(loveUser.getId()));
        }

        family.addAll(temp);

        family.add(userMapper.selectByPrimaryKey(id));

        return new ArrayList<>(new HashSet<>(family));
    }

    @Override
    public LoveUser findByName(String userName) {
        return null;
    }

    @Override
    public void addFamily(Integer type,Integer id,LoveUser user) throws Exception{

        LoveParentChildren family=new LoveParentChildren();

        if(type==0){
            //成为用户的家长
            family.setParentId(id);
            family.setChildrenId(user.getId());
        }else if(type==1){
            //成为用户的子女
            family.setParentId(user.getId());
            family.setChildrenId(id);
        }else{
            throw new Exception("添加类型错误，0目标将成为家长，1目标将成为孩子");
        }

        parentChildrenMapper.insertSelective(family);
    }

    @Override
    public String parseToken(String token) {
        String auth = token.substring(7, token.toString().length());
        Claims claims = JwtUtils.parseJWT(auth, audienceEntity.getBase64Secret());
        return (String) claims.get("loginUser");
    }
    @Override
    public LoveUser findById(Integer id) throws Exception {

        LoveUser user=userMapper.selectByPrimaryKey(id);

        List<LoveUser> family=findFamilyById(id);
        family.remove(user);

        user.setFamily(family);

        return user;
    }

}
