package com.wdl.amdroid_jwdl.util;

/**
 * Created by 62682 on 2018/3/20.
 */

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class AndroidBug5497Workaround
{
    private ViewGroup.LayoutParams frameLayoutParams;
    private View mChildOfContent;
    private int usableHeightPrevious;

    private AndroidBug5497Workaround(View paramView)
    {
        if (paramView == null)
            return;
        this.mChildOfContent = paramView;
        this.mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
            public void onGlobalLayout()
            {
                AndroidBug5497Workaround.this.possiblyResizeChildOfContent();
            }
        });
        this.frameLayoutParams = this.mChildOfContent.getLayoutParams();
    }

    public static void assistActivity(View paramView)
    {
        new AndroidBug5497Workaround(paramView);
    }

    private int computeUsableHeight()
    {
        Rect localRect = new Rect();
        this.mChildOfContent.getWindowVisibleDisplayFrame(localRect);
        return localRect.bottom;
    }

    private void possiblyResizeChildOfContent()
    {
        int i = computeUsableHeight();
        if (i == this.usableHeightPrevious)
            return;
        this.frameLayoutParams.height = i;
        this.mChildOfContent.requestLayout();
        this.usableHeightPrevious = i;
    }
}