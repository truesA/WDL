package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

import java.io.Serializable;

public class LoginUesr
        implements Serializable
{
    private boolean isLogin;
    private String token;
    private int userType;

    public String getToken()
    {
        return this.token;
    }

    public int getUserType()
    {
        return this.userType;
    }

    public boolean isLogin()
    {
        return this.isLogin;
    }

    public void setLogin(boolean paramBoolean)
    {
        this.isLogin = paramBoolean;
    }

    public void setToken(String paramString)
    {
        this.token = paramString;
    }

    public void setUserType(int paramInt)
    {
        this.userType = paramInt;
    }
}