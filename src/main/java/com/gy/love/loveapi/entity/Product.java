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
 * @date 2018/5/20 18:08
 * @email 1984629668@qq.com
 * @description 商品
 */
@Data
@Entity
@Table(name = "love_product")
public class Product {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 价格
     */
    private double price;

    /**
     * 图片
     */
    private String image;

    /**
     * 详情
     */
    private String detail;

    /**
     * 数量
     */
    private Integer number;
}
