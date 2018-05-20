package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:38
 * @email 1984629668@qq.com
 * @description 愿望
 */
@Data
@Entity
@Table(name = "love_desire")
public class Desire {
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
     * 完成时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endDate;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 花费
     */
    private double money;

    /**
     * 是否公开
     */
    public boolean isPublic;

    /**
     * 是否完成
     */
    private boolean isSuccess;
}
