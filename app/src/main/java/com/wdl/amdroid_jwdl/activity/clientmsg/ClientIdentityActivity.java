package com.wdl.amdroid_jwdl.activity.clientmsg;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.ClientService;
import com.wdl.amdroid_jwdl.model.BaseBean;
import com.wdl.amdroid_jwdl.model.ClientIdentityBean;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.TimeMDdialog;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import cn.addapp.pickers.listeners.OnItemPickListener;
import cn.addapp.pickers.listeners.OnSingleWheelListener;
import cn.addapp.pickers.picker.DatePicker;
import cn.addapp.pickers.picker.SinglePicker;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * author：lhm on 2018/3/24 22:29
 * <p>
 * email：3186834196@qq.com
 *
 * 身份
 */
public class ClientIdentityActivity extends BaseActivity {

    @BindView(R.id.client_common_ltv)
    TextView clientLtvValue;
    @BindView(R.id.client_common_rtv)
    TextView clientRtvValue;
    private int clientid;




    @BindView(R.id.identity_name_msg)
    TextView identity_name_msg;
    @BindView(R.id.identity_sex_msg)
    TextView identity_sex_msg;
    @BindView(R.id.identity_phone_msg)
    TextView identity_phone_msg;
    @BindView(R.id.identity_wechat_msg)
    TextView identity_wechat_msg;
    @BindView(R.id.identity_place_msg)
    TextView identity_place_msg;
    @BindView(R.id.identity_birthday_msg)
    TextView identity_birthday_msg;
    @BindView(R.id.identity_age_msg)
    TextView identity_age_msg;
    @BindView(R.id.identity_like_msg)
    TextView identity_like_msg;
    @BindView(R.id.identity_learn_msg)
    TextView identity_learn_msg;
    @BindView(R.id.identity_jh_msg)
    TextView identity_jh_msg;
    @BindView(R.id.identity_kid_msg)
    TextView identity_kid_msg;

    @BindView(R.id.identity_carname_msg)
    TextView identity_carname_msg;
    @BindView(R.id.identity_cartype_msg)
    TextView identity_cartype_msg;
    @BindView(R.id.identity_bxday_msg)
    TextView identity_bxday_msg;
    @BindView(R.id.identity_jcday_msg)
    TextView identity_jcday_msg;
    @BindView(R.id.identity_carage_msgs)
    TextView identity_carage_msgs;
    @BindView(R.id.identity_daykm_msg)
    TextView identity_daykm_msg;
    @BindView(R.id.identity_xhh_msg)
    TextView identity_xhh_msg;
    @BindView(R.id.identity_userful_msg)
    TextView identity_userful_msg;
    @BindView(R.id.identity_hy_msg)
    TextView identity_hy_msg;
    @BindView(R.id.identity_zw_msg)
    TextView identity_zw_msg;

    @BindView(R.id.client_identity_bz_sumit)
    Button client_identity_bz_sumit;



    @Override
    protected int getlayoutview() {
        return R.layout.activity_client_identity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        clientid= intent.getIntExtra("clientid",0);
        getToolbarTitle().setText("身份");

    }

    @Override
    protected void initData() {
        showLoadingDialog();
        App.getRetrofit(API.BASE_URL)
                .create(ClientService.class)
                .getClientIdentity(clientid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClientIdentityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClientIdentityBean clientIdentityBean) {
                        dismissLoadingDialog();
                        if (clientIdentityBean.getError_code()==200){
                            clientLtvValue.setText("身份指数"+clientIdentityBean.getResult().getIdentity_score());
                            clientRtvValue.setText("总用户排行"+clientIdentityBean.getResult().getIdentity_percent()+"%");
                            setIdentityData(clientIdentityBean.getResult());
                        }
                        UIUtils.showToast(clientIdentityBean.getReason());
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissLoadingDialog();
                        UIUtils.showToast("系统繁忙");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private int sex=0;
    private int bxyear=2018;
    private int bxmonth=1;
    private int bxday=1;
    private int jcyear=2018;
    private int jcmonth=1;
    private int jcday=1;
    private void setIdentityData(ClientIdentityBean.ResultBean result) {
        identity_name_msg.setText(result.getName());
        identity_sex_msg.setText(result.getGender());
        if ("男".equals(result.getGender())){
            sex=0;
        }else if ("男".equals(result.getGender())){
            sex=1;
        }
        identity_phone_msg.setText(result.getNumb());
        identity_wechat_msg.setText(result.getWechat_id());
        identity_place_msg.setText(result.getLocation());
        identity_birthday_msg.setText(result.getBirthday());
        identity_age_msg.setText(result.getAge()+"年");
        identity_like_msg.setText(result.getHobby());
        identity_learn_msg.setText(result.getEducation());
        identity_jh_msg.setText(result.getMarriage());
        identity_kid_msg.setText(result.getChildren());
        identity_carname_msg.setText(result.getPlate_num());
        identity_cartype_msg.setText(result.getCar_model());

        identity_bxday_msg.setText(result.getInsurance_date());
        String [] bxString =result.getInsurance_date().split("-");
        bxyear=Integer.parseInt(bxString[0]);
        bxmonth=Integer.parseInt(bxString[1]);
        bxday=Integer.parseInt(bxString[2]);
        identity_jcday_msg.setText(result.getSale_date());
        String [] jcString =result.getInsurance_date().split("-");
        jcyear=Integer.parseInt(jcString[0]);
        jcmonth=Integer.parseInt(jcString[1]);
        jcday=Integer.parseInt(jcString[2]);
        identity_carage_msgs.setText(result.getCar_age()+"年");
        double km_per_day = new BigDecimal(result.getKm_per_day()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        identity_daykm_msg.setText(km_per_day+"km");
        identity_xhh_msg.setText(result.getSmall_scratch_number()+"");
        identity_userful_msg.setText(result.getCar_purpose());
        identity_hy_msg.setText(result.getWork_field());
        identity_zw_msg.setText(result.getPosition());


    }

    @OnClick({R.id.identity_name_msg_ll,R.id.identity_sex_msg_ll,R.id.identity_phone_msg_ll,R.id.identity_carname_msg_ll,
            R.id.identity_cartype_msg_ll,R.id.identity_bxday_msg_ll,R.id.identity_jcday_msg_ll,R.id.identity_carage_msg_ll,R.id.client_identity_bz_sumit})
    public void submitMsg(View view){
        switch (view.getId()){
            case R.id.identity_name_msg_ll:
                new MaterialDialog.Builder(this)
                        .title("修改姓名")
                        .inputRange(2, 16)
                        .positiveText("提交")
                        .inputType(InputType.TYPE_CLASS_TEXT )
                        .input("姓名", identity_name_msg.getText().toString(),false, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                                submitMsgData("name",input+"");
                            }
                        }).show();
                break;
            case R.id.identity_sex_msg_ll:
                new MaterialDialog.Builder(this)
                        .title("性别")
                        .items(R.array.sex)
                        .itemsCallbackSingleChoice(sex, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                               // UIUtils.showToast(text + "-" );
                                submitMsgData("gender",text+"");
                                return true;
                            }
                        })
                        .positiveText("提交")
                        .show();
                break;
            case R.id.identity_phone_msg_ll:
                new MaterialDialog.Builder(this)
                        .title("修改手机号")
                        .inputRange(2, 16)
                        .positiveText("提交")
                        .inputType(InputType.TYPE_CLASS_TEXT )
                        .input("手机号", identity_phone_msg.getText().toString(),false, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                               // UIUtils.showToast(input + "-" );
                                submitMsgData("phone_number",input+"");
                            }
                        }).show();
                break;
            case R.id.identity_carname_msg_ll:
                new MaterialDialog.Builder(this)
                        .title("修改车牌号")
                        .inputRange(2, 16)
                        .positiveText("提交")
                        .inputType(InputType.TYPE_CLASS_TEXT )
                        .input("车牌号", identity_carname_msg.getText().toString(),false, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                                submitMsgData("plate_number",input+"");
                            }
                        }).show();
                break;
            case R.id.identity_cartype_msg_ll:
                new MaterialDialog.Builder(this)
                        .title("修改车辆型号")
                        .inputRange(2, 16)
                        .positiveText("提交")
                        .inputType(InputType.TYPE_CLASS_TEXT )
                        .input("车辆型号", identity_cartype_msg.getText().toString(),false, new MaterialDialog.InputCallback() {
                            @Override
                            public void onInput(MaterialDialog dialog, CharSequence input) {
                                // Do something
                                submitMsgData("car_model",input+"");
                            }
                        }).show();
                break;
            case R.id.identity_bxday_msg_ll:
                final DatePicker picker = new DatePicker(this);
                picker.setCanLoop(true);
                picker.setWheelModeEnable(true);
                picker.setSelectedTextColor(getResources().getColor(R.color.color2));//前四位值是透明度
                picker.setTopPadding(15);
                picker.setRangeStart(2009, 8, 29);
                picker.setRangeEnd(2111, 1, 11);
                picker.setSelectedItem(bxyear, bxmonth, bxday);
                picker.setTitleText("保险日");
                picker.setCancelText("取消");
                picker.setSubmitText("确定");
                picker.setWeightEnable(true);
                picker.setLineColor(Color.BLACK);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                    //    UIUtils.showToast(year + "-" + month + "-" + day);
                        submitMsgData("insurance_date",year + "-" + month + "-" + day);
                    }
                });
//                picker.setOnWheelListener(new DatePicker.OnWheelListener() {
//                    @Override
//                    public void onYearWheeled(int index, String year) {
//                        picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
//                    }
//
//                    @Override
//                    public void onMonthWheeled(int index, String month) {
//                        picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
//                    }
//
//                    @Override
//                    public void onDayWheeled(int index, String day) {
//                        picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
//                    }
//                });
                picker.show();
                break;
            case R.id.identity_jcday_msg_ll:
                final DatePicker pickerjcday = new DatePicker(this);
                pickerjcday.setCanLoop(true);
                pickerjcday.setSelectedTextColor(getResources().getColor(R.color.color2));//前四位值是透明度
                pickerjcday.setWheelModeEnable(true);
                pickerjcday.setTopPadding(15);
                pickerjcday.setRangeStart(2009, 8, 29);
                pickerjcday.setRangeEnd(2111, 1, 11);
                pickerjcday.setSelectedItem(jcyear, jcmonth, jcday);
                pickerjcday.setTitleText("交车日");
                pickerjcday.setCancelText("取消");
                pickerjcday.setSubmitText("确定");
                pickerjcday.setWeightEnable(true);
                pickerjcday.setLineColor(Color.BLACK);
                pickerjcday.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                  //      UIUtils.showToast(year + "-" + month + "-" + day);
                        submitMsgData("sale_date",year + "-" + month + "-" + day);
                    }
                });
//                pickerjcday.setOnWheelListener(new DatePicker.OnWheelListener() {
//                    @Override
//                    public void onYearWheeled(int index, String year) {
//                        pickerjcday.setTitleText(year + "-" + pickerjcday.getSelectedMonth() + "-" + pickerjcday.getSelectedDay());
//                    }
//
//                    @Override
//                    public void onMonthWheeled(int index, String month) {
//                        pickerjcday.setTitleText(pickerjcday.getSelectedYear() + "-" + month + "-" + pickerjcday.getSelectedDay());
//                    }
//
//                    @Override
//                    public void onDayWheeled(int index, String day) {
//                        pickerjcday.setTitleText(pickerjcday.getSelectedYear() + "-" + pickerjcday.getSelectedMonth() + "-" + day);
//                    }
//                });
                pickerjcday.show();
                break;
            case R.id.identity_carage_msg_ll:
                ArrayList<String> list = new ArrayList<>();
                for(int i = 1;i<10; i++){
                    list.add(i+"");
                }
//        String[] ss = (String[]) list.toArray();
                SinglePicker<String> pickersinge = new SinglePicker<>(this, list);
                pickersinge.setCanLoop(false);//不禁用循环
                pickersinge.setLineVisible(true);
                pickersinge.setTextSize(18);
                pickersinge.setSelectedIndex(8);
                pickersinge.setWheelModeEnable(false);
                //启用权重 setWeightWidth 才起作用
                pickersinge.setTitleText("车龄");
                pickersinge.setCancelText("取消");
                pickersinge.setSubmitText("确定");
                pickersinge.setLabel("年");
                pickersinge.setWeightEnable(true);
                pickersinge.setWeightWidth(1);
                pickersinge.setSelectedTextColor(getResources().getColor(R.color.color2));//前四位值是透明度
                pickersinge.setUnSelectedTextColor(Color.BLACK);
                pickersinge.setOnSingleWheelListener(new OnSingleWheelListener() {
                    @Override
                    public void onWheeled(int index, String item) {
                       // UIUtils.showToast("index=" + index + ", item=" + item);
                    }
                });
                pickersinge.setOnItemPickListener(new OnItemPickListener<String>() {
                    @Override
                    public void onItemPicked(int index, String item) {
                     //   UIUtils.showToast("index=" + index + ", item=" + item);
                        submitMsgData("car_age",item);
                    }
                });
                pickersinge.show();

                break;
            case R.id.client_identity_bz_sumit:
                UIUtils.showToast("提交备注");
                break;
        }
    }

    private void submitMsgData(String msgtype,String content){
        showLoadingDialog();
        Map<String,String> params =new HashMap<>();
        params.put("user_id",clientid+"");
        params.put(msgtype,content);
        App.getRetrofit(API.BASE_URL)
                .create(ClientService.class)
                .getClientSubmitIdentity(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean baseBean) {
                        dismissLoadingDialog();
                        if (baseBean.getError_code()==200){
                            initData();
                        }
                        UIUtils.showToast(baseBean.getReason());
                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissLoadingDialog();
                        UIUtils.showToast("系统繁忙");
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
