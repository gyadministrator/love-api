package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 18:15
 * @email 1984629668@qq.com
 * @description 用户活动
 */
@Data
@Entity
@Table(name = "love_user_activity")
public class UserActivity {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 活动id
     */
    @ManyToOne
    private Activity activityId;

    /**
     * 用户id
     */
    @ManyToOne
    private User userId;
}
