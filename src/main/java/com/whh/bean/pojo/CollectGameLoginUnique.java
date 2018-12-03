package com.whh.bean.pojo;

import java.util.Date;

public class CollectGameLoginUnique {
    private Integer id;

    private String userId;

    private Short appId;

    private Short channelId;

    private Date loginTime;

    private String deviceId;

    public CollectGameLoginUnique(Integer id, String userId, Short appId, Short channelId, Date loginTime, String deviceId) {
        this.id = id;
        this.userId = userId;
        this.appId = appId;
        this.channelId = channelId;
        this.loginTime = loginTime;
        this.deviceId = deviceId;
    }

    public CollectGameLoginUnique() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Short getAppId() {
        return appId;
    }

    public void setAppId(Short appId) {
        this.appId = appId;
    }

    public Short getChannelId() {
        return channelId;
    }

    public void setChannelId(Short channelId) {
        this.channelId = channelId;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }
}