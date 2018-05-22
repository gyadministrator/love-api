package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class LoveActivity {
    private Integer id;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private Boolean isNoticed;

    private List<LoveDetail> details;

    private Integer targetId;

    private LoveUser target;

    public LoveUser getTarget() {
        return target;
    }

    public void setTarget(LoveUser target) {
        this.target = target;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Boolean getNoticed() {
        return isNoticed;
    }

    public void setNoticed(Boolean noticed) {
        isNoticed = noticed;
    }

    public List<LoveDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LoveDetail> details) {
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsNoticed() {
        return isNoticed;
    }

    public void setIsNoticed(Boolean isNoticed) {
        this.isNoticed = isNoticed;
    }
}