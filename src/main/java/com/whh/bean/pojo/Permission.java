package com.whh.bean.pojo;

public class Permission {
    private String permissionId;

    private String url;

    private String permission;

    private Integer resourceType;

    private String parentid;

    public Permission(String permissionId, String url, String permission, Integer resourceType, String parentid) {
        this.permissionId = permissionId;
        this.url = url;
        this.permission = permission;
        this.resourceType = resourceType;
        this.parentid = parentid;
    }

    public Permission() {
        super();
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId == null ? null : permissionId.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    public Integer getResourceType() {
        return resourceType;
    }

    public void setResourceType(Integer resourceType) {
        this.resourceType = resourceType;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }
}