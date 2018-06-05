package com.wdl.amdroid_jwdl.fragment;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.joker.annotation.PermissionsDenied;
import com.joker.annotation.PermissionsGranted;
import com.joker.annotation.PermissionsNonRationale;
import com.joker.annotation.PermissionsRationale;
import com.joker.api.Permissions4M;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.wdl.amdroid_jwdl.App;
import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.activity.DecoderActivity;
import com.wdl.amdroid_jwdl.activity.SearchActivity;
import com.wdl.amdroid_jwdl.activity.MsgBusinessActivity;
import com.wdl.amdroid_jwdl.activity.UserMainMsgActivity;
import com.wdl.amdroid_jwdl.adapter.MsgAdapter;
import com.wdl.amdroid_jwdl.base.BaseFragment;
import com.wdl.amdroid_jwdl.commom.LinItemDecoration;
import com.wdl.amdroid_jwdl.commom.RecycleViewDivider;
import com.wdl.amdroid_jwdl.commom.callback.OnItemClickListener;
import com.wdl.amdroid_jwdl.interfaces.API;
import com.wdl.amdroid_jwdl.interfaces.DataService;
import com.wdl.amdroid_jwdl.model.MsgListBean;
import com.wdl.amdroid_jwdl.util.UIUtils;
import com.wdl.amdroid_jwdl.view.dropdownmenu.DropDownMenu;
import com.wdl.amdroid_jwdl.view.dropdownmenu.adapter.GirdDropDownAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Achers on 2017/11/22.
 */

public class MsgFragment extends BaseFragment implements OnItemClickListener {
    private static final int CAMERA_CODE = 1;
    List<MsgListBean.ResultBean> arrayList = new ArrayList();
    private String[] chiZi = {"我的", "基盘", "他的"};
    private String chiZi_model = "我的";
    private GirdDropDownAdapter chiZiAdapter;

    private String[] carTapes = {"不限", "凯美瑞", "汉兰达", "雷凌", "雅力士", "致炫", "致享", "逸致"};
    private String type_model = "不限";
    private GirdDropDownAdapter carTaypeAdatapter;
    private String car_model = "不限";
    private int constellationPosition = 0;
    private int isRefresh = 1;
    private String location = "不限";
    private String[] locations = {"不限", "本地", "吉安县", "泰和县", "吉水县", "永丰县", "永新县", "峡江县", "安福县", "万安县", "隧川县", "新干县", "井冈山市", "吉州区", "青原区"};
    private String loyalty = "不限";
    private GirdDropDownAdapter loyaltyAdapter;
    private String[] loyaltys = {"不限", "0.1-0.3", "0.4-0.6", "0.7-0.9", "1.0-1.3", "1.4-1.6", "1.7-1.9", "2.0+"};
    private String[] types = {"不限", "收藏", "预约", "继续", "续保", "T1", "M1", "M2", "5K", "10K"};

    private String[] headers = {"池子", "类型", "车型", "地区", "忠诚"};
    @BindView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;
    @BindView(R.id.empty_ll)
    LinearLayout emptyLl;
    private MsgAdapter msgAdapter;
    private int page = 1;
    private int pageNum = 20;
    private GirdDropDownAdapter placeAdapter;
    private List<View> popupViews = new ArrayList();

    @BindView(R.id.recy)
    RecyclerView recyclerView;

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    private GirdDropDownAdapter typeAdapter;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void initView() {
        final ListView chiZiView = new ListView(getActivity());
        chiZiAdapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(chiZi));
        chiZiView.setDividerHeight(0);
        chiZiView.setAdapter(chiZiAdapter);

        ListView typeView = new ListView(getActivity());
        typeAdapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(types));
        typeView.setDividerHeight(0);
        typeView.setAdapter(typeAdapter);

        ListView carTapeView = new ListView(getActivity());
        carTaypeAdatapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(carTapes));
        carTapeView.setDividerHeight(0);
        carTapeView.setAdapter(carTaypeAdatapter);

        ListView placeView = new ListView(getActivity());
        placeAdapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(locations));
        placeView.setDividerHeight(0);
        placeView.setAdapter(placeAdapter);

        ListView loyaltyView = new ListView(getActivity());
        loyaltyAdapter = new GirdDropDownAdapter(getActivity(), Arrays.asList(loyaltys));
        loyaltyView.setDividerHeight(0);
        loyaltyView.setAdapter(loyaltyAdapter);
        popupViews.add(chiZiView);
        popupViews.add(typeView);
        popupViews.add(carTapeView);
        popupViews.add(placeView);
        popupViews.add(loyaltyView);
        chiZiView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                chiZiAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? chiZi[0] : chiZi[position]);
                mDropDownMenu.closeMenu();
                chiZi_model = position == 0 ? "我的" : chiZi[position];
                Log.e("click0", chiZi_model);
                showLoadingDialog();
                getDataList();
            }
        });


        typeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> AdapterView, View View, int position, long Long) {
                typeAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[1] : types[position]);
                mDropDownMenu.closeMenu();
                type_model = position == 0 ? "不限" : types[position];

                Log.e("click1", type_model);
                showLoadingDialog();
                getDataList();

            }
        });
        carTapeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> AdapterView, View View, int position,
                                    long Long) {
                carTaypeAdatapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[2] : carTapes[position]);
                mDropDownMenu.closeMenu();
                car_model = position == 0 ? "不限" : carTapes[position];

                Log.e("click2", car_model);
                showLoadingDialog();
                getDataList();
            }
        });
        placeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> AdapterView, View View, int position,
                                    long Long) {
                placeAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[3] : locations[position]);
                mDropDownMenu.closeMenu();
                location = position == 0 ? "不限" : locations[position];

                Log.e("click3", location);
                showLoadingDialog();
                getDataList();
            }
        });
        loyaltyView.setOnItemClickListener(new AdapterView.OnItemClickListener()

        {
            public void onItemClick(AdapterView<?> AdapterView, View View, int position,
                                    long Long) {
                loyaltyAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[4] : loyaltys[position]);
                mDropDownMenu.closeMenu();
                loyalty = position == 0 ? "不限" : loyaltys[position];

                Log.e("click4", loyalty);
                showLoadingDialog();
                getDataList();
            }
        });
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, null);
    }

    @Override
    protected View setRootView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.msg_fg, container, false);
        return view;
    }

    @Override
    public void initData() {
        refresh();
        refreshLayout.setRefreshHeader(new MaterialHeader(getActivity()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.addItemDecoration(new RecycleViewDivider(getActivity(),LinearLayoutManager.VERTICAL,R.drawable.divider));
        int resId = R.anim.layout_animation_fall_down;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(getActivity(), resId);
        recyclerView.setLayoutAnimation(animation);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh(RefreshLayout RefreshLayout) {
                isRefresh = 1;
                refresh();
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                isRefresh = 0;
                loadMore();
            }
        });
        msgAdapter = new MsgAdapter(getActivity(), R.layout.msg_fragment_item, arrayList);
        recyclerView.setAdapter(msgAdapter);
        msgAdapter.setOnItemClickListener(this);
        msgAdapter.setDataPostionChangeListener(new MsgAdapter.DataPostionChangeListener() {
            @Override
            public void dataPostionChange(int postion) {
                //  msgAdapter.notifyItemChanged(postion);
                // msgAdapter.notifyDataSetChanged();
                refresh();
            }
        });
    }


    private void getDataList() {
        HashMap<String, String> params = new HashMap();
        params.put("page", page + "");
        params.put("user_per_page", pageNum + "");
        params.put("type", type_model);
        params.put("car_model", car_model);
        params.put("location", location);
        params.put("loyalty", loyalty);
        Log.e("getDataList", type_model + type_model + "car_model" + car_model + "location" + location + "loyalty" + loyalty);
        App.getRetrofit(API.BASE_URL)
                .create(DataService.class)
                .getMsgListBean(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MsgListBean msgListBean) {
                        dismissLoadingDialog();
                        if (msgListBean.getError_code() == 200) {
                            if (msgListBean.getResult()==null||msgListBean.getResult().size()==0){
                                recyclerView.setVisibility(View.GONE);
                                emptyLl.setVisibility(View.VISIBLE);
                                refreshAndloadMoreFinsh();
                                return;
                            }
                            emptyLl.setVisibility(View.GONE);
                            recyclerView.setVisibility(View.VISIBLE);
                            setRequset(msgListBean.getResult());
                            refreshAndloadMoreFinsh();
                        }else {
                            UIUtils.showToast(msgListBean.getReason());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        refreshAndloadMoreFinsh();
                        dismissLoadingDialog();
                    }

                    @Override
                    public void onComplete() {
                        dismissLoadingDialog();
                    }
                });
    }

    private void loadMore() {
        page += 1;
        getDataList();
    }

    private void refresh() {
        page = 1;
        getDataList();
    }

    private void refreshAndloadMoreFinsh() {
        refreshLayout.finishLoadMore(false);
        refreshLayout.finishRefresh(false);
    }

    private void setRequset(List<MsgListBean.ResultBean> paramList) {
        if (isRefresh == 1) {
            arrayList.clear();
        }
        arrayList.addAll(paramList);
        msgAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View View, int position) {
        Intent intent = new Intent(getActivity(), UserMainMsgActivity.class);
        intent.putExtra("userid", arrayList.get(position).getId());
        intent.putExtra("carPai", arrayList.get(position).getPlate_num());
        startActivity(intent);
    }

    public void onPause() {
        super.onPause();
        if (!(mDropDownMenu.isShowing()))
            return;
        mDropDownMenu.closeMenu();
    }

    public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt) {
        Permissions4M.onRequestPermissionsResult(this, paramInt, paramArrayOfInt);
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }

    @PermissionsRationale({1})
    public void rationale() {
        UIUtils.showToast("请开启相机权限");
    }

    @PermissionsNonRationale({1})
    public void nonRationale(Intent Intent) {
        startActivity(Intent);
    }

    @PermissionsGranted({1})
    public void granted() {
        UIUtils.showToast("相机权限成功");
        startActivity(new Intent(getActivity(), DecoderActivity.class));
    }

    @PermissionsDenied({1})
    public void denied() {
        UIUtils.showToast("相机权限失败");
    }

    @OnClick({R.id.search_ll, R.id.msg_fg_sao})
    public void goSaoTo(View View) {
        switch (View.getId()) {
            case R.id.search_ll:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            case R.id.msg_fg_sao:
                Permissions4M.get(this).requestForce(true).requestUnderM(true).requestPermissions(new String[]{"android.permission.CAMERA"}).requestCodes(new int[]{1}).requestPageType(1).requestPageType(0).request();
                break;
            default:
                break;
        }
    }

}
