package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * 系统用户
 *
 * @author gy
 * @date 2017-04-01
 */
@EqualsAndHashCode()
@Data
@Entity
@Table(name = "love_user")
public class User {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 头像
     */
    private String image;

    /**
     * 电话
     */
    private String phone;

    /**
     * 积分
     */
    private double integral;

    /**
     * 今日积分
     */
    private double todayIntegral;
}
