package com.example.day_05_qrcoad;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;

public class CoadActivity extends AppCompatActivity implements QRCodeView.Delegate {

    private ZXingView zXingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coad);
        //获取资源id
        zXingView = findViewById(R.id.viewzxing);
        zXingView.setDelegate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //打开后置摄像头
        zXingView.startCamera();
        //延迟0.1秒
        zXingView.startSpotAndShowRect();
        //闪光灯
        //zXingView.openFlashlight();
    }

    @Override
    protected void onStop() {
        super.onStop();
        //关闭摄像头
        zXingView.stopCamera();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //销毁
        zXingView.onDestroy();
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i("GXY",result);
        Intent intent = new Intent(CoadActivity.this,WebActivity.class);
        intent.putExtra("path",result);
        startActivity(intent);
    }

    @Override
    public void onCameraAmbientBrightnessChanged(boolean isDark) {

    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.i("GXY","打开相机出错");
    }
}
