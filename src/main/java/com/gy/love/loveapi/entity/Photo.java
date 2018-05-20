package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:53
 * @email 1984629668@qq.com
 * @description 相片
 */
@Data
@Entity
@Table(name = "love_photo")
public class Photo {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 相册id
     */
    @ManyToOne
    private Album albumId;

    /**
     * 地址
     */
    private String url;

    /**
     * 描述
     */
    private String detail;
}
