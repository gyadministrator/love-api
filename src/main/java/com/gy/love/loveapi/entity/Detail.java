package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:43
 * @email 1984629668@qq.com
 * @description 详细
 */
@Data
@Entity
@Table(name = "love_detail")
public class Detail {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 评价用户id
     */
    @ManyToOne
    private User userId;

    /**
     * 内容
     */
    private String content;

    /**
     * 图片
     */
    private String image;

    /**
     * 评价时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
