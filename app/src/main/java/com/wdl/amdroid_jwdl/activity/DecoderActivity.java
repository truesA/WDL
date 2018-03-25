package com.wdl.amdroid_jwdl.activity;

import android.os.Vibrator;
import android.util.Log;
import android.widget.TextView;

import com.wdl.amdroid_jwdl.R;
import com.wdl.amdroid_jwdl.base.BaseActivity;
import com.wdl.amdroid_jwdl.util.UIUtils;

import butterknife.BindView;
import cn.bingoogolapple.qrcode.core.QRCodeView;

/**
 * author：lhm on 2018/3/24 13:43
 * <p>
 * email：3186834196@qq.com
 */
public class DecoderActivity extends BaseActivity
        implements QRCodeView.Delegate {
    private static final String TAG = DecoderActivity.class.getName();

    @BindView(R.id.zbarview)
    QRCodeView mQRCodeView;
    TextView resultTextView;

    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    protected int getlayoutview() {
        return R.layout.activity_decoder;
    }

    protected void initData() {
    }

    protected void initView() {
        this.mQRCodeView.setDelegate(this);
        this.mQRCodeView.startSpot();
    }

    protected boolean isUseToolsBar() {
        return false;
    }

    protected void onDestroy() {
        this.mQRCodeView.onDestroy();
        super.onDestroy();
    }

    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "打开相机出错");
    }

    public void onScanQRCodeSuccess(String paramString) {
        Log.i(TAG, "result:" + paramString);
        UIUtils.showToast(paramString);
        vibrate();
        this.mQRCodeView.startSpot();
    }

    protected void onStart() {
        super.onStart();
        this.mQRCodeView.startCamera();
        this.mQRCodeView.showScanRect();
    }

    protected void onStop() {
        this.mQRCodeView.stopCamera();
        super.onStop();
    }
}