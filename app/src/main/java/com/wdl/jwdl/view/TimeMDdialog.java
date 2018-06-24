package com.wdl.jwdl.view;

/**
 * author：lhm on 2018/3/22 00:54
 * <p>
 * email：3186834196@qq.com
 */

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.wdl.jwdl.R;

import cn.addapp.pickers.common.LineConfig;
import cn.addapp.pickers.util.ConvertUtils;
import cn.addapp.pickers.widget.WheelListView;
import cn.addapp.pickers.widget.WheelListView.OnWheelChangeListener;

public class TimeMDdialog extends DialogFragment {
    private int indexmonth;
    private int indexyear=1;
    private TimeMDdialogListener timeMDdialogListener;
    private String wMonths;
    private String wYears;

    public TimeMDdialogListener getTimeMDdialogListener() {
        return timeMDdialogListener;
    }

    public Dialog onCreateDialog(Bundle paramBundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.time_md_dialog, null);
        WheelListView wheelListViewY =  view.findViewById(R.id.wheelview_timeY);
        WheelListView wheelListViewM =  view.findViewById(R.id.wheelview_timeM);
        wheelListViewY.setItems(new String[]{"2017", "2018", "2019"}, indexyear);
        wheelListViewY.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig config = new LineConfig();
        config.setColor(Color.parseColor("#ff3366"));
        config.setAlpha(100);
      //  config.se(0.2F);
        config.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        config.setShadowVisible(false);
        wheelListViewY.setLineConfig(config);
        wheelListViewY.setOnWheelChangeListener(new OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String s) {
                wYears=s;
            }
        });
        int i = indexmonth;
        wheelListViewM.setItems(new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}, i);
        wheelListViewM.setSelectedTextColor(getResources().getColor(R.color.black));
        LineConfig configm = new LineConfig();
        configm.setColor(Color.parseColor("#c62828"));
        configm.setAlpha(100);
        //configm.setRatio(0.2F);
        configm.setThick(ConvertUtils.toPx(getActivity(), 3.0F));
        configm.setShadowVisible(false);
        wheelListViewM.setLineConfig(configm);
        wheelListViewM.setOnWheelChangeListener(new OnWheelChangeListener() {
            @Override
            public void onItemSelected(int i, String s) {
                wMonths=s;
            }
        });
        builder.setView(view).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                if (timeMDdialogListener == null)
                    return;
                timeMDdialogListener.ontimeMDdialogComplete(wYears, wMonths);
            }
        }).setNegativeButton("取消", null);
        return builder.create();
    }

    public void setIndexmonthItem(int paramInt) {
        indexmonth = (paramInt - 1);
    }

    public void setIndexYearItem(int yearItem){
        indexyear=yearItem;
    }

    public void setTimeMDdialogListener(TimeMDdialogListener paramTimeMDdialogListener) {
        timeMDdialogListener = paramTimeMDdialogListener;
    }

    public  interface TimeMDdialogListener {
         void ontimeMDdialogComplete(String paramString1, String paramString2);
    }
}
