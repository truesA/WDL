package com.wdl.jwdl;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.joker.annotation.PermissionsGranted;
import com.joker.annotation.PermissionsNonRationale;
import com.joker.annotation.PermissionsRationale;
import com.joker.api.Permissions4M;
import com.wdl.jwdl.activity.DecoderActivity;
import com.wdl.jwdl.base.BaseActivity;
import com.wdl.jwdl.fragment.DataFragment;
import com.wdl.jwdl.fragment.MsgFragment;
import com.wdl.jwdl.fragment.MyViewPagerAdapter;
import com.wdl.jwdl.fragment.PersonFragment;
import com.wdl.jwdl.fragment.SavingFragment;
import com.wdl.jwdl.fragment.ServiceFragment;
import com.wdl.jwdl.util.AppManagerUtil;
import com.wdl.jwdl.util.UIUtils;
import com.wdl.jwdl.view.NoSlidingViewPaper;

import butterknife.BindView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottom_navigation_bar)
    public BottomNavigationBar bottomNavigationBar;
    private long clickTime = 0; //记录第一次点击的时间
    public DataFragment dataFragment;
    public List<Fragment> fragments = new ArrayList();
    public MsgFragment msgFragment;
    public PersonFragment personFragment;
    public ServiceFragment serviceFragment;
    public SavingFragment savingFragment;
    private int bottomNavigationBarHeight;

    @BindView(R.id.view_page)
    public NoSlidingViewPaper viewPaper;


    private void initBottomNavigation() {
        bottomNavigationBar.setBackgroundStyle(2);
        bottomNavigationBar.setActiveColor("#FFFFFF").setInActiveColor(R.color.text_color06).setBarBackgroundColor(R.color.new_color3);
        bottomNavigationBar.setMode(1);
        bottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.mub_icon_color, "目标")
                .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.mub_icon_nocolor)))
                .addItem(new BottomNavigationItem(R.mipmap.basepan_icon_color, "基盘")
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.basepan_icon_nocolor)))
                .addItem(new BottomNavigationItem(R.mipmap.person_icon_color, "人脉")
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.person_icon_nocolor)))
                .addItem(new BottomNavigationItem(R.mipmap.money_icon_color, "储蓄")
                        .setInactiveIcon(ContextCompat.getDrawable(this, R.mipmap.money_icon_nocolor))).initialise();
        setBottomNavigationItem(bottomNavigationBar,6,23,12);
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            public void onTabReselected(int paramInt) {
            }

            public void onTabSelected(int paramInt) {
//                if (paramInt==3){
//                    viewPaper.setCurrentItem(paramInt, false);
//                    setStatusBarColor(Color.TRANSPARENT);
//                }else {
//                    setStatusBarColor(Color.parseColor("#ff333333"));
//
//                }
                viewPaper.setCurrentItem(paramInt, false);

            }

            public void onTabUnselected(int paramInt) {
            }
        });
    }

    private void initFragment() {
        dataFragment = new DataFragment();
        msgFragment = new MsgFragment();
        personFragment = new PersonFragment();
//        serviceFragment = new ServiceFragment();
        savingFragment=new SavingFragment();
        fragments.add(dataFragment);
        fragments.add(msgFragment);
        fragments.add(personFragment);
//        fragments.add(serviceFragment);
        fragments.add(savingFragment);
    }

    protected int getlayoutview() {
        return R.layout.activity_main;
    }

    protected void initData() {
        viewPaper.setCurrentItem(0);

        Permissions4M.get(this).requestForce(true).requestUnderM(true)
                .requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE",
                        "android.permission.READ_EXTERNAL_STORAGE"})
                .requestCodes(new int[]{1}).requestPageType(1).requestPageType(0).request();

    }

    public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt) {
        Permissions4M.onRequestPermissionsResult(this, paramInt, paramArrayOfInt);
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }

    @PermissionsRationale({1})
    public void rationale() {
        UIUtils.showToast("请开启SD储存权限");
    }

    @PermissionsNonRationale({1})
    public void nonRationale(Intent Intent) {
        UIUtils.showToast("拒绝SD储存权限成功");
        startActivity(Intent);
    }

    @PermissionsGranted({1})
    public void granted() {
        UIUtils.showToast("SD储存权限成功");

    }

    protected void initView() {
        initBottomNavigation();
        initFragment();
        viewPaper.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(), fragments));
        viewPaper.setOffscreenPageLimit(4);
    }

    protected boolean isUseToolsBar() {
        return false;
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




    public void exit() {
        if ((System.currentTimeMillis() - clickTime) > 2000) {
            UIUtils.showToast("再次点击退出");
            clickTime = System.currentTimeMillis();
        } else {
            AppManagerUtil.instance().AppExit(this);
        }
    }
    /**
     * 获取底部导航栏高度
     * @return
     */
    public int getbottomNavigationBarHeight(){
        return bottomNavigationBarHeight;
    }

    /**
     @param bottomNavigationBar，需要修改的 BottomNavigationBar
     @param space 图片与文字之间的间距
     @param imgLen 单位：dp，图片大小，应 <= 36dp
     @param textSize 单位：dp，文字大小，应 <= 20dp

     使用方法：直接调用setBottomNavigationItem(bottomNavigationBar, 6, 26, 10);
     代表将bottomNavigationBar的文字大小设置为10dp，图片大小为26dp，二者间间距为6dp
     **/

    private void setBottomNavigationItem(BottomNavigationBar bottomNavigationBar, int space, int imgLen, int textSize){
        Class barClass = bottomNavigationBar.getClass();
        Field[] fields = barClass.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            if(field.getName().equals("mTabContainer")){
                try{
                    //反射得到 mTabContainer
                    LinearLayout mTabContainer = (LinearLayout) field.get(bottomNavigationBar);
                    for(int j = 0; j < mTabContainer.getChildCount(); j++){
                        //获取到容器内的各个Tab
                        View view = mTabContainer.getChildAt(j);
                        //获取到Tab内的各个显示控件
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(56));
                        FrameLayout container = (FrameLayout) view.findViewById(R.id.fixed_bottom_navigation_container);
                        container.setLayoutParams(params);
                        container.setPadding(dip2px(12), dip2px(0), dip2px(12), dip2px(0));

                        //获取到Tab内的文字控件
                        TextView labelView = (TextView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title);
                        //计算文字的高度DP值并设置，setTextSize为设置文字正方形的对角线长度，所以：文字高度（总内容高度减去间距和图片高度）*根号2即为对角线长度，此处用DP值，设置该值即可。
                        labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
                        labelView.setIncludeFontPadding(false);
                        labelView.setPadding(0,0,0,dip2px(20-textSize - space/2));

                        //获取到Tab内的图像控件
                        ImageView iconView = (ImageView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon);
                        //设置图片参数，其中，MethodUtils.dip2px()：换算dp值
                        params = new FrameLayout.LayoutParams(dip2px(imgLen), dip2px(imgLen));
                        params.setMargins(0,0,0,space/2);
                        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                        iconView.setLayoutParams(params);
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public int dip2px(float dpValue) {
        final float scale = getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}