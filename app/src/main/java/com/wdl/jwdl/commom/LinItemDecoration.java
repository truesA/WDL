package com.wdl.jwdl.commom;

/**
 * author：lhm on 2018/3/24 11:23
 * <p>
 * email：3186834196@qq.com
 */

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;

import android.view.View;

public class LinItemDecoration extends RecyclerView.ItemDecoration {
    /**
     *
     * @param outRect 边界
     * @param view recyclerView ItemView
     * @param parent recyclerView
     * @param state recycler 内部数据管理
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        //设定底部边距为1px
        outRect.set(0, 0, 0, 1);
    }

}