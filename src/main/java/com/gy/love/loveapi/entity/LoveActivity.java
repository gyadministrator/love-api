package com.gy.love.loveapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class LoveActivity {
    private Integer id;

    private String title;

    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    private Boolean isNoticed;

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