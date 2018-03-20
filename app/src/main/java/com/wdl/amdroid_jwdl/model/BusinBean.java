package com.wdl.amdroid_jwdl.model;

/**
 * Created by 62682 on 2018/3/20.
 */

public class BusinBean extends SelectedBean {
    private String name;

    public BusinBean(String paramString)
    {
        this.name = paramString;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }
}