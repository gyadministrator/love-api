package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:23
 * @email 1984629668@qq.com
 * @description 活动
 */
@Data
@Entity
@Table(name = "love_activity")
public class Activity {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 标题
     */
    private String title;

    /**
     * 内容
     */
    private String content;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 是否短信通知
     */
    private boolean isNoticed;
}
