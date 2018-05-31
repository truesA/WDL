package com.wdl.amdroid_jwdl.model;

import java.io.Serializable;

/**
 * author：lhm on 2018/5/31 22:11
 * <p>
 * email：3186834196@qq.com
 */
public class UserInfo implements Serializable {

    private String username;
    private String password;
    private int logintype;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLogintype() {
        return logintype;
    }

    public void setLogintype(int logintype) {
        this.logintype = logintype;
    }
}
