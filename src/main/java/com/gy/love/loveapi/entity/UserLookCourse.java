package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 18:22
 * @email 1984629668@qq.com
 * @description 观看
 */
@Data
@Entity
@Table(name = "love_user_look_course")
public class UserLookCourse {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 用户id
     */
    @ManyToOne
    private User userId;

    /**
     * 课程id
     */
    @ManyToOne
    private Course courseId;
}
