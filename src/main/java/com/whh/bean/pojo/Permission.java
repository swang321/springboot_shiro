package com.whh.bean.pojo;

public class Permission {
    private Integer permissionId;

    private String url;

    private String perms;

    private String permission;

    private Integer resourceType;

    private Integer parentId;

    public Permission(Integer permissionId, String url, String perms, String permission, Integer resourceType, Integer parentId) {
        this.permissionId = permissionId;
        this.url = url;
        this.perms = perms;
        this.permission = permission;
        this.resourceType = resourceType;
        this.parentId = parentId;
    }

    public Permission() {
        super();
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}