package com.wdl.jwdl.util.log;

/**
 * Created by 62682 on 2018/3/20.
 */

public final class Settings
{
    private boolean showThreadInfo = true;

    public Settings hideThreadInfo()
    {
        this.showThreadInfo = false;
        return this;
    }

    public boolean isHideThreadInfo()
    {
        return this.showThreadInfo;
    }
}
