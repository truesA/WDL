package com.wdl.amdroid_jwdl.util.log;

/**
 * Created by 62682 on 2018/3/20.
 */

public abstract interface LogUtilPrinterInterface
{
    public abstract void d(Object paramObject, String paramString);

    public abstract void e(Object paramObject, String paramString);

    public abstract Settings getSettings();

    public abstract void i(Object paramObject, String paramString);

    public abstract void json(String paramString1, String paramString2);

    public abstract void printD(Object paramObject, String paramString);

    public abstract void printE(Object paramObject, String paramString);

    public abstract void v(Object paramObject, String paramString);

    public abstract void w(Object paramObject, String paramString);

    public abstract void wtf(Object paramObject, String paramString);

    public abstract void xml(String paramString1, String paramString2);
}