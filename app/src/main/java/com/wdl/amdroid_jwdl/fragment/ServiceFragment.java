package com.wdl.amdroid_jwdl.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.LoginUesr;
import com.wdl.amdroid_jwdl.model.MainServiceBean;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
import com.wdl.amdroid_jwdl.util.StringUtils;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.MyMarkerView;
import com.wdl.amdroid_jwdl.view.TimeMDdialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;

/**
 * Created by Achers on 2017/11/22.
 */

public class ServiceFragment extends BaseFragment {

    private static boolean isAniman = false;

    @BindView(R.id.barchart_m1_b)
    TextView barchart_m1_b;

    @BindView(R.id.barchart_m1_r)
    TextView barchart_m1_r;

    @BindView(R.id.barchart_m2_b)
    TextView barchart_m2_b;

    @BindView(R.id.barchart_m2_r)
    TextView barchart_m2_r;

    @BindView(R.id.barchart_t1_b)
    TextView barchart_t1_b;

    @BindView(R.id.barchart_t1_r)
    TextView barchart_t1_r;

    @BindView(R.id.barchart_yyv_b)
    TextView barchart_yyv_b;

    @BindView(R.id.barchart_yyv_r)
    TextView barchart_yyv_r;

    @BindView(R.id.barchart_m1)
    BarChart mBarChartM1;

    @BindView(R.id.barchart_m2)
    BarChart mBarChartM2;

    @BindView(R.id.barchart_t1)
    BarChart mBarChartT1;

    @BindView(R.id.barchart_yyv)
    BarChart mBarChartYyv;
    private int monthdefult = 1;

    @BindView(R.id.probar_cx_p)
    MaterialProgressBar probar_cx_p;
    @BindView(R.id.probar_cx_p2)
    MaterialProgressBar probar_cx_p2;

    @BindView(R.id.probar_cx_tv_bom)
    TextView probar_cx_tv_bom;
    @BindView(R.id.probar_cx_tv_bom2)
    TextView probar_cx_tv_bom2;

    @BindView(R.id.probar_hq_p)
    MaterialProgressBar probar_hq_p;
    @BindView(R.id.probar_hq_p2)
    MaterialProgressBar probar_hq_p2;

    @BindView(R.id.probar_hq_tv_bom)
    TextView probar_hq_tv_bom;
    @BindView(R.id.probar_hq_tv_bom2)
    TextView probar_hq_tv_bom2;

    @BindView(R.id.probar_jcz_bom)
    TextView probar_jcz_bom;
    @BindView(R.id.probar_jcz_bom2)
    TextView probar_jcz_bom2;

    @BindView(R.id.probar_jcz_p)
    MaterialProgressBar probar_jcz_p;
    @BindView(R.id.probar_jcz_p2)
    MaterialProgressBar probar_jcz_p2;

    @BindView(R.id.probar_jjc_p)
    MaterialProgressBar probar_jjc_p;
    @BindView(R.id.probar_jjc_p2)
    MaterialProgressBar probar_jjc_p2;

    @BindView(R.id.probar_jjc_tv_bom)
    TextView probar_jjc_tv_bom;
    @BindView(R.id.probar_jjc_tv_bom2)
    TextView probar_jjc_tv_bom2;

    @BindView(R.id.probar_t1_p)
    MaterialProgressBar probar_t1_p;
    @BindView(R.id.probar_t1_p2)
    MaterialProgressBar probar_t1_p2;

    @BindView(R.id.probar_t1_tv_bom)
    TextView probar_t1_tv_bom;
    @BindView(R.id.probar_t1_tv_bom2)
    TextView probar_t1_tv_bom2;

    @BindView(R.id.service_month)
    TextView service_month;

    @BindView(R.id.jiangjinchi_tot_tv)
    TextView jiangjinchi_tot_tv;
    private List<Integer> xAxisValues;
    private List<Float> yAxisValues1;
    private List<Float> yAxisValues2;
    @BindView(R.id.service_refreshLayout)
    SmartRefreshLayout refreshLayouts;

    private int isRefresh = 0;

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.service_fg, container, false);

        return view;
    }

    @Override
    public void initData() {
        getAllData(monthdefult);
        service_month.setOnClickListener(new View.OnClickListener() {
            public void onClick(View paramView) {
                TimeMDdialog timeMDdialog = new TimeMDdialog();
                timeMDdialog.setIndexmonthItem(monthdefult);
                timeMDdialog.setTimeMDdialogListener(new TimeMDdialog.TimeMDdialogListener() {
                    public void ontimeMDdialogComplete(String paramString1, String paramString2) {
                        isRefresh = 0;
                        getAllData(Integer.parseInt(paramString2));
                    }
                });
                timeMDdialog.show(getActivity().getFragmentManager(), "time");
            }
        });
        xAxisValues = new ArrayList();
        yAxisValues1 = new ArrayList();
        yAxisValues2 = new ArrayList();
        int i = 1;
        while (i < 13) {
            xAxisValues.add(Integer.valueOf(i));
            yAxisValues1.add(Float.valueOf((float) (Math.random() * 40.0D + 20.0D)));
            yAxisValues2.add(Float.valueOf((float) (Math.random() * 40.0D + 20.0D)));
            i += 1;
        }
        setTwoBarChart(mBarChartM1, xAxisValues, yAxisValues1, yAxisValues2, "M1产值", "M1台次");
        setTwoBarChart(mBarChartM2, xAxisValues, yAxisValues1, yAxisValues2, "M2产值", "M2台次");
        setTwoBarChart(mBarChartYyv, xAxisValues, yAxisValues1, yAxisValues2, "预约率", "达成率");
        setTwoBarChart(mBarChartT1, xAxisValues, yAxisValues1, yAxisValues2, "T1产值", "T1台次");
        initViewTeValue();
    }


    private void initViewTeValue() {
    }


    @Override
    protected void initView() {
        refreshLayouts.setRefreshHeader(new MaterialHeader(getActivity()));
        refreshLayouts.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout RefreshLayout) {
                isRefresh = 1;
                getAllData(monthdefult);
            }
        });
        refreshLayouts.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                refreshLayout.finishLoadMore(false);//传入false表示加载失败
            }
        });

    }


    private int dealProgressValues(int paramInt, double paramDouble) {
        double d = paramDouble;
        if (paramDouble == 0D)
            d = 100;
        paramDouble = paramInt * 1.0;
        Log.e("ints", paramDouble + "---" + d + "");
        paramDouble = d / paramDouble;
        paramInt = (int) (100. * paramDouble);
        Log.e("int", paramInt + "---" + paramDouble + "");
        return paramInt;
    }

    private void getAllData(final int month) {
        if (isRefresh == 0) {
            showLoadingDialog();
        }
        App.getRetrofit(API.BASE_URL)
                .create(UserService.class)
                .getMainServetMsg(month)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainServiceBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    public void onError(Throwable paramThrowable) {
                        dismissLoadingDialog();
                        refreshLayouts.finishRefresh();
                        paramThrowable.printStackTrace();
                        UIUtils.showToast("出错啦！");
                    }

                    public void onNext(MainServiceBean mainServiceBean) {
                        refreshLayouts.finishRefresh();
                        if (isRefresh == 0) {
                            dismissLoadingDialog();
                        }
                        if (mainServiceBean.getError_code() == 200) {
                            // ServiceFragment.access$002(ServiceFragment.this,val$month);
                            monthdefult = month;
                            service_month.setText(monthdefult + "月");
                            setDataMsg(mainServiceBean.getResult());
                        }
                        UIUtils.showToast(mainServiceBean.getReason());
                    }

                    @Override
                    public void onComplete() {
                        refreshLayouts.finishRefresh();
                    }
                });
    }

    private void setDataMsg(MainServiceBean.ResultBean paramResultBean) {
        if (paramResultBean == null) {
            getAllData(monthdefult);
            return;
        }
        LoginUesr loginuser = (LoginUesr) PreferencesUtil.getInstance(getActivity()).getObject("loginUesr");
        Log.e("login", loginuser.getUserType() + "");
        if (loginuser.getUserType() == 1) {
            jiangjinchi_tot_tv.setText(paramResultBean.getJiangjinchi_total().get(0) + "");
        } else {
            jiangjinchi_tot_tv.setText(paramResultBean.getJiangjinchi_total().get(1) + "");
        }


        probar_hq_p.setProgress(100 - dealProgressValues(10000, new Double(((Integer) paramResultBean.getHuoqi().get(0)).intValue()).intValue()));
        probar_hq_tv_bom.setText(new Double(((Integer) paramResultBean.getHuoqi().get(0)).intValue()).intValue() + "");
        probar_cx_p.setProgress(100 - dealProgressValues(10000, new Double(((Integer) paramResultBean.getChuxu().get(0)).intValue()).intValue()));
        probar_cx_tv_bom.setText(new Double(((Integer) paramResultBean.getChuxu().get(0)).intValue()).intValue() + "");
        probar_t1_p.setProgress(100 - dealProgressValues(500, ((Integer) paramResultBean.getT1().get(0)).intValue()));
        probar_t1_tv_bom.setText(paramResultBean.getT1().get(0) + "");
        probar_jcz_p.setProgress(100 - ((Integer) paramResultBean.getChanzhilv().get(0)).intValue());
        probar_jcz_bom.setText(paramResultBean.getChanzhilv().get(0) + "%");
        probar_jjc_p.setProgress(100 - dealProgressValues(10000, new Double(((Integer) paramResultBean.getJiangjinchi().get(0)).intValue()).intValue()));
        probar_jjc_tv_bom.setText(new Double(((Integer) paramResultBean.getJiangjinchi().get(0)).intValue()).intValue() + "");


        probar_hq_p2.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getHuoqi().get(1)).intValue()).intValue()));
        probar_hq_tv_bom2.setText(new Double(((Integer) paramResultBean.getHuoqi().get(1)).intValue()).intValue() + "");
        probar_cx_p2.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getChuxu().get(1)).intValue()).intValue()));
        probar_cx_tv_bom2.setText(new Double(((Integer) paramResultBean.getChuxu().get(1)).intValue()).intValue() + "");
        probar_t1_p2.setProgress(dealProgressValues(500, ((Integer) paramResultBean.getT1().get(1)).intValue()));
        probar_t1_tv_bom2.setText(paramResultBean.getT1().get(1) + "");
        probar_jcz_p2.setProgress(((Integer) paramResultBean.getChanzhilv().get(1)).intValue());
        probar_jcz_bom2.setText(paramResultBean.getChanzhilv().get(1) + "%");
        probar_jjc_p2.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getJiangjinchi().get(1)).intValue()).intValue()));
        probar_jjc_tv_bom2.setText(new Double(((Integer) paramResultBean.getJiangjinchi().get(1)).intValue()).intValue() + "");
    }

    public static void setTwoBarChart(BarChart barChart, List<Integer> xAxisValue, List<Float> yAxisValue1, List<Float> yAxisValue2, String bartilte1, String bartitle2) {
        barChart.getDescription().setEnabled(false);//设置描述
        barChart.setPinchZoom(true);//设置按比例放缩柱状图
        barChart.setExtraBottomOffset(10);
        barChart.setExtraTopOffset(30);

        //x坐标轴设置
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawLabels(true);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(xAxisValue.size());
        xAxis.setCenterAxisLabels(true);//设置标签居中
        // xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisValue));

        //y轴设置
        YAxis leftAxis = barChart.getAxisLeft();
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setDrawGridLines(false);
        leftAxis.setDrawLabels(false);
        leftAxis.setDrawAxisLine(false);

        //设置MarkerView
        barChart.setMarker(new MyMarkerView(barChart.getContext(), R.layout.custom_marker_view));
        //设置坐标轴最大最小值
        Float yMin1 = Collections.min(yAxisValue1);
        Float yMin2 = Collections.min(yAxisValue2);
        Float yMax1 = Collections.max(yAxisValue1);
        Float yMax2 = Collections.max(yAxisValue2);
        Float yMin = Double.valueOf((yMin1 < yMin2 ? yMin1 : yMin2) * 0.1).floatValue();
        Float yMax = Double.valueOf((yMax1 > yMax2 ? yMax1 : yMax2) * 1.1).floatValue();
        leftAxis.setAxisMaximum(yMax);
        leftAxis.setAxisMinimum(yMin);
        //保证Y轴从0开始，不然会上移一点

        barChart.getAxisRight().setEnabled(false);


        //图例设置
        Legend legend = barChart.getLegend();
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setTextSize(12f);

        //设置柱状图数据
        setTwoBarChartData(barChart, xAxisValue, yAxisValue1, yAxisValue2, bartilte1, bartitle2);

        barChart.animateX(1500);//数据显示动画，从左往右依次显示
        barChart.invalidate();
    }

    /**
     * 设置柱状图数据源
     */
    private static void setTwoBarChartData(BarChart barChart, List<Integer> xAxisValue, List<Float> yAxisValue1, List<Float> yAxisValue2, String bartilte1, String bartitle2) {
        float groupSpace = 0.03f;
        float barSpace = 0.03f;
        float barWidth = 0.45f;
        // (0.45 + 0.03) * 2 + 0.03 = 1，即一个间隔为一组，包含两个柱图 -> interval per "group"

        ArrayList<BarEntry> entries1 = new ArrayList<>();
        ArrayList<BarEntry> entries2 = new ArrayList<>();

        for (int i = 0, n = yAxisValue1.size(); i < n; ++i) {
            entries1.add(new BarEntry(i, yAxisValue1.get(i)));
            entries2.add(new BarEntry(i, yAxisValue2.get(i)));
        }

        BarDataSet dataset1, dataset2;

        if (barChart.getData() != null && barChart.getData().getDataSetCount() > 0) {
            dataset1 = (BarDataSet) barChart.getData().getDataSetByIndex(0);
            dataset2 = (BarDataSet) barChart.getData().getDataSetByIndex(1);
            dataset1.setValues(entries1);
            dataset2.setValues(entries2);
            barChart.getData().notifyDataChanged();
            barChart.notifyDataSetChanged();
        } else {
            dataset1 = new BarDataSet(entries1, bartilte1);
            dataset2 = new BarDataSet(entries2, bartitle2);

            dataset1.setColor(Color.rgb(255, 51, 120));
            dataset2.setColor(Color.rgb(64, 127, 255));
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(dataset1);
            dataSets.add(dataset2);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);


            barChart.setData(data);
        }
        for (IDataSet set : barChart.getData().getDataSets())
            set.setDrawValues(!set.isDrawValuesEnabled());
        barChart.getBarData().setBarWidth(barWidth);
        barChart.getXAxis().setAxisMinimum(0);
        // barData.getGroupWith(...) is a helper that calculates the width each group needs based on the provided parameters
        barChart.getXAxis().setAxisMaximum(barChart.getBarData().getGroupWidth(groupSpace, barSpace) * xAxisValue.size() + 0);
        barChart.groupBars(0, groupSpace, barSpace);
    }

//    public void onResume() {
//        super.onResume();
//        getAllData(monthdefult);
//    }


}
