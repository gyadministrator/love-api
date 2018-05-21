package com.gy.love.loveapi.entity;

public class LoveUser {
    private Integer id;

    private String userName;

    private String password;

    private String name;

    private String image;

    private String phone;

    private Float integral;

    private Float todayIntegral;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Float getIntegral() {
        return integral;
    }

    public void setIntegral(Float integral) {
        this.integral = integral;
    }

    public Float getTodayIntegral() {
        return todayIntegral;
    }

    public void setTodayIntegral(Float todayIntegral) {
        this.todayIntegral = todayIntegral;
    }
}