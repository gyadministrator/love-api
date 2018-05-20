package com.gy.love.loveapi.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author gaoyun
 * @version 1.0
 * @date 2018/5/20 17:28
 * @email 1984629668@qq.com
 * @description 活动细节
 */
@Data
@Entity
@Table(name = "love_activity_detail")
public class ActivityDetail {
    @Id
    @GenericGenerator(name = "generateUUID", strategy = "uuid")
    @GeneratedValue(generator = "generateUUID")
    private String id;

    /**
     * 详细id
     */
    @ManyToOne
    private Detail detailId;

    /**
     * 活动id
     */
    @ManyToOne
    private Activity activityId;
}
