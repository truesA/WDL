package com.wdl.amdroid_jwdl.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.util.UIUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Achers on 2017/12/9.
 */

public class PhoneView  extends LinearLayout {
    private int index = 0;
    private String[] texts = {"您", "的", "手", "机", "号", "码"};
    TranslateAnimation tvTranslation;//位移动画
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (index < texts.length)
                getChildAt(index++).startAnimation(tvTranslation);

        }
    };

    public PhoneView(Context context) {
        this(context, null);
    }

    public PhoneView(Context context, AttributeSet attrs) {
        this(context, attrs, -1);
    }

    public PhoneView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, UIUtils.dip2Px( 100));
        for (int i = 0; i < texts.length; i++) {
            TextView tv = new TextView(getContext());
            tv.setTextColor(getResources().getColor(R.color.phoneTextBlue));
            tv.setText(texts[i]);
            tv.setTextSize(16);
            tv.setLayoutParams(params);
            tv.setGravity(Gravity.BOTTOM);
            tv.setPadding(0, 0, 0, UIUtils.dip2Px( 30));
            addView(tv);
        }

    }

    public void startAnim() {
        final Timer time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                tvTranslation = new TranslateAnimation(0, 0, 0, -100);
                tvTranslation.setDuration(300);
                tvTranslation.setFillAfter(true);
                handler.sendEmptyMessage(0);
            }
        };
        time.schedule(task, 0, 50);//添加定时器，间隔50毫秒对textview执行动画，
    }
}
