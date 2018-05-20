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
 * @date 2018/5/20 17:51
 * @email 1984629668@qq.com
 * @description 亲子关联
 */
@Data
@Entity
@Table(name = "love_parent_children")
public class ParentChildren {
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
}
