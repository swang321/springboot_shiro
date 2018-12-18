package com.whh.bean.pojo;

public class User {
    private Integer userId;

    private String username;

    private String name;

    private String password;

    private Integer status;

    public User(Integer userId, String username, String name, String password, Integer status) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public User() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}