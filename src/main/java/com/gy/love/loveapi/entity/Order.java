package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:47
 * @email 1984629668@qq.com
 * @description 订单
 */
@Data
@Entity
@Table(name = "love_order")
public class Order {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 购买者id
     */
    @ManyToOne
    private User userId;

    /**
     * 物品id
     */
    @ManyToOne
    private Product productId;

    /**
     * 物流方式id
     */
    private String expressId;

    /**
     * 时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 数量
     */
    private Integer number;
}
