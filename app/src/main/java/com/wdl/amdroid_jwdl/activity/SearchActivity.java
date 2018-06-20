package com.wdl.amdroid_jwdl.activity;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.MainBasePanService;
import com.wdl.amdroid_jwdl.model.SeachBean;
import com.wdl.amdroid_jwdl.model.UserInfo;
import com.wdl.amdroid_jwdl.util.PreferencesUtil;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.searchView.ICallBack;
import com.wdl.amdroid_jwdl.view.searchView.SearchView;
import com.wdl.amdroid_jwdl.view.searchView.bCallBack;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * author：lhm on 2018/3/24 13:56
 * <p>
 * email：3186834196@qq.com
 */
public class SearchActivity extends BaseActivity {
    //private SearchListAdapter adapter;
    private String carPai = "------";

    @BindView(R.id.ll_result)
    LinearLayout ll_result;

    @BindView(R.id.new_word)
    LinearLayout new_word;

    @BindView(R.id.search_view)
    SearchView searchView;

    @BindView(R.id.search_carPai)
    TextView search_carPai;

    @BindView(R.id.search_level)
    TextView search_level;

    @BindView(R.id.search_ll)
    LinearLayout search_ll;

    @BindView(R.id.search_name)
    TextView search_name;

    @BindView(R.id.search_phone)
    TextView search_phone;

    @BindView(R.id.search_xinyong)
    TextView search_xinyong;

    @BindView(R.id.search_xu)
    TextView search_xu;

    @BindView(R.id.search_zhe)
    TextView search_zhe;
    private int userid = 1;

    private UserInfo userInfo;

    private void getDataMsg(String String) {

        showLoadingDialog();
        App.getRetrofit(API.BASE_URL)
                .create(MainBasePanService.class)
                .getSeachContent(userInfo.getSaid(),String)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SeachBean>() {
            public void onComplete() {
            }

            public void onError(Throwable Throwable) {
                Throwable.printStackTrace();
                searchView.setVisibilityGone();
                UIUtils.showToast("抱歉,系统繁忙");
                dismissLoadingDialog();
            }

            public void onNext(SeachBean SeachBean) {
                dismissLoadingDialog();
                if (SeachBean.getError_code() == 200) {
                   searchView.setVisibilityGone();
                    ll_result.setVisibility(View.VISIBLE);
                    new_word.setVisibility(View.GONE);
                    setData(SeachBean);
                }else{
                    new_word.setVisibility(View.VISIBLE);
                    ll_result.setVisibility(View.GONE);
                }
                UIUtils.showToast(SeachBean.getReason());


            }

            public void onSubscribe(Disposable Disposable) {
            }
        });
    }

    private void setData(SeachBean SeachBean) {
        search_carPai.setText(SeachBean.getResult().getPlate_num());
        search_name.setText(SeachBean.getResult().getName());
        search_level.setText(SeachBean.getResult().getLevel());
        search_phone.setText(SeachBean.getResult().getPhone_number());
        search_xinyong.setText("信用分" + SeachBean.getResult().getTotal_score() + "");
        search_xu.setText("续(" + SeachBean.getResult().getXu() + ")");
        search_zhe.setText("折" + SeachBean.getResult().getZhe());
        userid = SeachBean.getResult().getId();
        carPai = SeachBean.getResult().getPlate_num();
    }

    protected int getlayoutview() {
        return R.layout.activity_search;
    }

    protected void initData() {
        userInfo = (UserInfo) PreferencesUtil.getInstance(this).getObject("UserInfo");
    }

    protected void initView() {
        getToolbarTitle().setText("搜索");
        searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String String) {
                getDataMsg(String);
            }
        });
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                finish();
            }
        });
    }

    @OnClick({R.id.ll_result, R.id.new_word})
    public void onclickgo(View View) {
        switch (View.getId()) {

            case R.id.new_word:
                UIUtils.showToast("暂时未开放新建档案功能");
                break;
            case R.id.ll_result:
                Intent  intent= new Intent();
                intent.setClass(this, UserMainMsgActivity.class);
                intent.putExtra("userid", userid);
                intent.putExtra("carPai", carPai);
                startActivity(intent);
                break;
            default:
                break;
        }

    }
}