package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:33
 * @email 1984629668@qq.com
 * @description 通话
 */
@Data
@Entity
@Table(name = "love_call")
public class Call {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 家长id
     */
    private String parentId;

    /**
     * 孩子id
     */
    private String childrenId;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;
}
