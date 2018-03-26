package com.wdl.amdroid_jwdl.view;

/**
 * author：lhm on 2018/3/22 00:32
 * <p>
 * email：3186834196@qq.com
 */

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.wdl.amdroid_jwdl.R;

public class MyMarkerView extends MarkerView {
    private TextView tvContent = (TextView) findViewById(R.id.tvContent);

    public MyMarkerView(Context paramContext, int paramInt) {
        super(paramContext, paramInt);
    }

    public MPPointF getOffsetForDrawingAtPoint(float paramFloat1, float paramFloat2) {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }

    public void refreshContent(Entry paramEntry, Highlight paramHighlight) {
        tvContent.setText("" + paramEntry.getY());
    }
}