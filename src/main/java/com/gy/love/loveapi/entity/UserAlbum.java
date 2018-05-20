package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 18:18
 * @email 1984629668@qq.com
 * @description 用户相册
 */
@Data
@Entity
@Table(name = "love_user_album")
public class UserAlbum {
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
     * 相册id
     */
    @ManyToOne
    private Album albumId;
}
