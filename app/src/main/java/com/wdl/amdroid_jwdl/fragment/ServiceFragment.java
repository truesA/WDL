package com.wdl.amdroid_jwdl.fragment;

import android.content.Intent;
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
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.UserService;
import com.wdl.amdroid_jwdl.model.LoginUesr;
import com.wdl.amdroid_jwdl.model.MainServiceBean;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
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

    @BindView(R.id.probar_cx_tv_bom)
    TextView probar_cx_tv_bom;

    @BindView(R.id.probar_hq_p)
    MaterialProgressBar probar_hq_p;

    @BindView(R.id.probar_hq_tv_bom)
    TextView probar_hq_tv_bom;

    @BindView(R.id.probar_jcz_bom)
    TextView probar_jcz_bom;

    @BindView(R.id.probar_jcz_p)
    MaterialProgressBar probar_jcz_p;

    @BindView(R.id.probar_jjc_p)
    MaterialProgressBar probar_jjc_p;

    @BindView(R.id.probar_jjc_tv_bom)
    TextView probar_jjc_tv_bom;

    @BindView(R.id.probar_t1_p)
    MaterialProgressBar probar_t1_p;

    @BindView(R.id.probar_t1_tv_bom)
    TextView probar_t1_tv_bom;

    @BindView(R.id.service_month)
    TextView service_month;
    private List<Integer> xAxisValues;
    private List<Float> yAxisValues1;
    private List<Float> yAxisValues2;

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.service_fg, container, false);


        return view;
    }

    @Override
    public void initData() {
        {
            service_month.setOnClickListener(new View.OnClickListener() {
                public void onClick(View paramView) {
                    TimeMDdialog timeMDdialog = new TimeMDdialog();
                    timeMDdialog.setIndexmonthItem(monthdefult);
                    timeMDdialog.setTimeMDdialogListener(new TimeMDdialog.TimeMDdialogListener() {
                        public void ontimeMDdialogComplete(String paramString1, String paramString2) {
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
    }

    private void initViewTeValue() {
    }


    @Override
    protected void initView() {


    }


    private int dealProgressValues(int paramInt, double paramDouble) {
        double d = paramDouble;
        if (paramDouble == 0D)
            d = 10;
        paramDouble = paramInt * 1.0;
        Log.e("ints", paramDouble + "---" + d + "");
        paramDouble = d / paramDouble;
        paramInt = (int) (100. * paramDouble);
        Log.e("int", paramInt + "---" + paramDouble + "");
        return paramInt;
    }

    private void getAllData(int month) {
        showLoadingDialog();
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
                        paramThrowable.printStackTrace();
                        dismissLoadingDialog();
                        UIUtils.showToast("出错啦！");
                    }

                    public void onNext(MainServiceBean mainServiceBean) {
                        dismissLoadingDialog();
                        if (mainServiceBean.getError_code() == 200) {
                            // ServiceFragment.access$002(ServiceFragment.this,val$month);
                            service_month.setText(monthdefult+ "月");
                            setDataMsg(mainServiceBean.getResult());
                        }
                        UIUtils.showToast(mainServiceBean.getReason());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void setDataMsg(MainServiceBean.ResultBean paramResultBean) {
        if (paramResultBean == null) {
            getAllData(monthdefult);
            return;
        }
        if (((LoginUesr) PreferencesUtil.getInstance(getActivity()).getObject("loginUesr")).getUserType() == 1) {
            probar_hq_p.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getHuoqi().get(0)).intValue()).intValue()));
            probar_hq_tv_bom.setText(new Double(((Integer) paramResultBean.getHuoqi().get(0)).intValue()).intValue() + "");
            probar_cx_p.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getChuxu().get(0)).intValue()).intValue()));
            probar_cx_tv_bom.setText(new Double(((Integer) paramResultBean.getChuxu().get(0)).intValue()).intValue() + "");
            probar_t1_p.setProgress(dealProgressValues(500, ((Integer) paramResultBean.getT1().get(0)).intValue()));
            probar_t1_tv_bom.setText(paramResultBean.getT1().get(0) + "");
            probar_jcz_p.setProgress(((Integer) paramResultBean.getChanzhilv().get(0)).intValue());
            probar_jcz_bom.setText(paramResultBean.getChanzhilv().get(0) + "%");
            probar_jjc_p.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getJiangjinchi().get(0)).intValue()).intValue()));
            probar_jjc_tv_bom.setText(new Double(((Integer) paramResultBean.getJiangjinchi().get(1)).intValue()).intValue() + "");
        } else {
            probar_hq_p.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getHuoqi().get(1)).intValue()).intValue()));
            probar_hq_tv_bom.setText(new Double(((Integer) paramResultBean.getHuoqi().get(1)).intValue()).intValue() + "");
            probar_cx_p.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getChuxu().get(1)).intValue()).intValue()));
            probar_cx_tv_bom.setText(new Double(((Integer) paramResultBean.getChuxu().get(1)).intValue()).intValue() + "");
            probar_t1_p.setProgress(dealProgressValues(500, ((Integer) paramResultBean.getT1().get(1)).intValue()));
            probar_t1_tv_bom.setText(paramResultBean.getT1().get(1) + "");
            probar_jcz_p.setProgress(((Integer) paramResultBean.getChanzhilv().get(1)).intValue());
            probar_jcz_bom.setText(paramResultBean.getChanzhilv().get(1) + "%");
            probar_jjc_p.setProgress(dealProgressValues(10000, new Double(((Integer) paramResultBean.getJiangjinchi().get(1)).intValue()).intValue()));
            probar_jjc_tv_bom.setText(new Double(((Integer) paramResultBean.getJiangjinchi().get(1)).intValue()).intValue() + "");
        }
    }

    public static void setTwoBarChart(BarChart paramBarChart, List<Integer> paramList, List<Float> paramList1, List<Float> paramList2, String paramString1, String paramString2)
    {
        paramBarChart.getDescription().setEnabled(false);
        paramBarChart.setPinchZoom(true);
        paramBarChart.setExtraBottomOffset(10.0F);
        paramBarChart.setExtraTopOffset(30.0F);
        paramBarChart.setDrawValueAboveBar(true);
        paramBarChart.setDragEnabled(true);
        paramBarChart.setTouchEnabled(true);
        paramBarChart.setMarker(new MyMarkerView(paramBarChart.getContext(), 2131361837));
        XAxis xAxis = paramBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1.0F);
        xAxis.setLabelCount(paramList.size());
        xAxis.setCenterAxisLabels(true);
        xAxis.setValueFormatter(new IAxisValueFormatter()
        {
            public String getFormattedValue(float paramFloat, AxisBase paramAxisBase)
            {
                return String.valueOf((int)paramFloat);
            }
        });
        YAxis yAxis = paramBarChart.getAxisLeft();
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxis.setDrawGridLines(false);
        yAxis.setDrawLabels(false);
        yAxis.setDrawAxisLine(false);
        localObject = (Float) Collections.min(paramList1);
        Float localFloat3 = (Float)Collections.min(paramList2);
        Float localFloat1 = (Float)Collections.max(paramList1);
        Float localFloat2 = (Float)Collections.max(paramList2);
        if (((Float)localObject).floatValue() < localFloat3.floatValue())
        {
            float f = Double.valueOf(((Float)localObject).floatValue() * 0.1D).floatValue();
            if (localFloat1.floatValue() <= localFloat2.floatValue())
                break label424;
            localObject = localFloat1;
           yAxis.setAxisMaximum(Float.valueOf(Double.valueOf(((Float)localObject).floatValue() * 1.1D).floatValue()).floatValue());
            yAxis.setAxisMinimum(Float.valueOf(f).floatValue());
            paramBarChart.getAxisRight().setEnabled(false);
            Legend legend = paramBarChart.getLegend();
            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
            legend.setDrawInside(false);
            legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
            legend.setForm(Legend.LegendForm.SQUARE);
            legend.setTextSize(12.0F);
            setTwoBarChartData(paramBarChart, paramList, paramList1, paramList2, paramString1, paramString2);
            paramBarChart.animateY(1500);
            List<Integer> paramList = ((BarData)paramBarChart.getData()).getDataSets().iterator();
            label375: if (!(paramList.hasNext()))
                break label437;
            paramList1 = (IDataSet)paramList.next();
            if (paramList1.isDrawValuesEnabled())
                break label431;
        }
        for (boolean bool = true; ; bool = false)
        {
            paramList1.setDrawValues(bool);
            break label375:
            localObject = localFloat3;
            break label197:
            label424: localObject = localFloat2;
            label431: break label233:
        }
        if (paramBarChart.getData() != null)
            label437: ((BarData)paramBarChart.getData()).setHighlightEnabled(true);
        paramBarChart.invalidate();
    }

    private static void setTwoBarChartData(BarChart paramBarChart, List<Integer> paramList, List<Float> paramList1, List<Float> paramList2, String paramString1, String paramString2)
    {
        ArrayList localArrayList2 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        int i = 0;
        int j = paramList1.size();
        while (i < j)
        {
            localArrayList2.add(new BarEntry(((Integer)paramList.get(i)).intValue(), ((Float)paramList1.get(i)).floatValue()));
            localArrayList1.add(new BarEntry(((Integer)paramList.get(i)).intValue(), ((Float)paramList2.get(i)).floatValue()));
            i += 1;
        }
        if ((paramBarChart.getData() != null) && (((BarData)paramBarChart.getData()).getDataSetCount() > 0))
        {
            BarData paramList1 = (BarDataSet)((BarData)paramBarChart.getData()).getDataSetByIndex(0);
            paramList2 = (BarDataSet)((BarData)paramBarChart.getData()).getDataSetByIndex(1);
            paramList1.setValues(localArrayList2);
            paramList2.setValues(localArrayList1);
            ((BarData)paramBarChart.getData()).notifyDataChanged();
            paramBarChart.notifyDataSetChanged();
        }
        while (true)
        {
            paramBarChart.getBarData().setBarWidth(0.45F);
            paramBarChart.getXAxis().setAxisMinimum(((Integer)paramList.get(0)).intValue());
            paramList1 = paramBarChart.getXAxis();
            float f1 = paramBarChart.getBarData().getGroupWidth(0.08F, 0.03F);
            float f2 = paramList.size();
            paramList1.setAxisMaximum(((Integer)paramList.get(0)).intValue() + f2 * f1);
            paramBarChart.groupBars(((Integer)paramList.get(0)).intValue(), 0.08F, 0.03F);
            return;
            paramList1 = new BarDataSet(localArrayList2, paramString1);
            paramList2 = new BarDataSet(localArrayList1, paramString2);
            paramList1.setColor(Color.rgb(255, 51, 120));
            paramList2.setColor(Color.rgb(64, 127, 255));
            paramString1 = new ArrayList();
            paramString1.add(paramList1);
            paramString1.add(paramList2);
            paramList1 = new BarData(paramString1);
            paramList1.setValueTextSize(8.0F);
            paramList1.setBarWidth(0.9F);
            paramBarChart.setData(paramList1);
        }
    }

    public void onResume()
    {
        super.onResume();
        getAllData(monthdefult);
    }


}
