package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:45
 * @email 1984629668@qq.com
 * @description 帮助单
 */
@Data
@Entity
@Table(name = "love_help")
public class Help {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 发起用户id
     */
    @ManyToOne
    private User userId;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 联系电话
     */
    private String phone;
}
