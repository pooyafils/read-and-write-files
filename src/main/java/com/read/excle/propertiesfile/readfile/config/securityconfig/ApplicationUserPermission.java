package com.read.excle.propertiesfile.readfile.config.securityconfig;

public enum  ApplicationUserPermission {
    USER_READ("user:read");
    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
    }
