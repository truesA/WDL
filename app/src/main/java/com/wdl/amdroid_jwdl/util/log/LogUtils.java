package com.wdl.amdroid_jwdl.util.log;

/**
 * Created by 62682 on 2018/3/20.
 */

import com.google.gson.Gson;

public class LogUtils
{
    private static boolean mIsDebuge = true;
    private static final LogUtilPrinter printer = new LogUtilPrinter();

    public static void d(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.d(paramObject, "");
    }

    public static void d(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.d(paramObject, paramString);
    }

    public static void e(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.e(paramObject, "");
    }

    public static void e(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.e(paramObject, paramString);
    }

    public static void i(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.i(paramObject, "");
    }

    public static void i(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.i(paramObject, paramString);
    }

    public static Settings initParam(boolean paramBoolean)
    {
        mIsDebuge = paramBoolean;
        return printer.getSettings();
    }

    public static void json(String paramString)
    {
        if (!(mIsDebuge))
            return;
        printer.json(paramString, "");
    }

    public static void json(String paramString1, String paramString2)
    {
        if (!(mIsDebuge))
            return;
        printer.json(paramString2, paramString1);
    }

    public static void object(Object paramObject)
    {
        object("", paramObject);
    }

    public static void object(String paramString, Object paramObject)
    {
        if (paramObject == null)
            return;
        String str = new Gson().toJson(paramObject);
        paramObject = paramObject.getClass().getSimpleName();
        json(paramString, paramObject + ":" + str);
    }

    public static void printD(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.printD(paramObject, "");
    }

    public static void printD(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.printD(paramObject, paramString);
    }

    public static void printE(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.printE(paramObject, "");
    }

    public static void printE(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.printE(paramObject, paramString);
    }

    public static void v(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.v(paramObject, "");
    }

    public static void v(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.v(paramObject, paramString);
    }

    public static void w(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.w(paramObject, "");
    }

    public static void w(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.w(paramObject, paramString);
    }

    public static void wtf(Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.wtf(paramObject, "");
    }

    public static void wtf(String paramString, Object paramObject)
    {
        if (!(mIsDebuge))
            return;
        printer.wtf(paramObject, paramString);
    }

    public static void xml(String paramString)
    {
        if (!(mIsDebuge))
            return;
        printer.xml(paramString, "");
    }

    public static void xml(String paramString1, String paramString2)
    {
        if (!(mIsDebuge))
            return;
        printer.xml(paramString2, paramString1);
    }
}