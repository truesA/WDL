package com.wdl.jwdl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhuyong on 2016/1/29.
 */

public class TimeUtil {
    public static String getFormatTime(String paramString) {
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            long l = localSimpleDateFormat.parse(paramString).getTime();
            int i = (int) ((new Date().getTime() - l) / 60000L);
            if (i < 5)
                return "刚刚";
            if (i < 60)
                return i + "分钟前";
            if (i < 1440)
                return (i / 60) + "小时前";
            if (i < 43200)
                return (i / 1440) + "天前";
            return "很久了";
        } catch (ParseException String) {
            String.printStackTrace();
        }
        return "...";
    }

    public static boolean getIsDayHour() {
        int i = Integer.parseInt(new SimpleDateFormat("HH").format(Long.valueOf(new Date().getTime())));
        return ((i >= 6) && (i <= 18));
    }

    public static String[] getStringarr(int paramInt) {
        String[] arrayOfString = new String[paramInt];
        int i = 0;
        while (i < paramInt) {
            arrayOfString[i] = (i + 1) + "";
            i += 1;
        }
        return arrayOfString;
    }

    public static String[] setDays(int paramInt1, int paramInt2) {
        switch (paramInt2) {
            default:
                return null;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return getStringarr(31);
            case 2:
                if (((paramInt1 % 4 == 0) && (paramInt1 % 100 != 0)) || (paramInt1 % 400 == 0))
                    return getStringarr(29);
                return getStringarr(28);
            case 4:
            case 6:
            case 9:
            case 11:
        }
        return getStringarr(30);
    }
}