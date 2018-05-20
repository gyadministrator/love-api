package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:36
 * @email 1984629668@qq.com
 * @description 课程
 */
@Data
@Entity
@Table(name = "love_course")
public class Course {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
    private String detail;

    /**
     * 地址
     */
    private String url;

    /**
     * 播放量
     */
    private Integer number;

    /**
     * 主讲老师
     */
    private String teacher;

}
