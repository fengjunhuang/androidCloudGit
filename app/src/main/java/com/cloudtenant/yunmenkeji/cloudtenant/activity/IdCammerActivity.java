package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.cloudtenant.yunmenkeji.cloudtenant.view.ClipCamera;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
public class IdCammerActivity extends AppCompatActivity implements View.OnClickListener, ClipCamera.IAutoFocus {

    private ClipCamera camera;
    private Button btn_shoot;
    private Button btn_cancle;
    private Button btn_light;
    private boolean isFront;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 22);
        } else {
            setContentView(R.layout.activity_id_cammer);
            initView();
        }
        isFront=getIntent().getBooleanExtra("isFront",false);

    }

    private void initView() {
        camera = (ClipCamera) findViewById(R.id.surface_view);
        btn_shoot = (Button) findViewById(R.id.btn_shoot);
        btn_cancle = (Button) findViewById(R.id.btn_cancle);
        btn_light = (Button) findViewById(R.id.btn_light);
        btn_shoot.setOnClickListener(this);
        //btn_light.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);
        camera.setIAutoFocus(this);
        //isLight=camera.isFlashlightOn();
    }

    public void Myfinish() {
        Log.d("takePhoto","开始Myfinish》拍照完成=");
        setResult(11);
        finish();
    }

    boolean isLight;
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_shoot:
                takePhoto();
                break;
            case R.id.btn_cancle:
                finish();
                break;

                case R.id.btn_light:{
                    if (!isLight) {
                        camera.Openshoudian();
                        isLight=!isLight;
                    }else {
                        camera.Closeshoudian();
                        isLight=!isLight;
                    }
                }break;
        }
    }

    public void takePhoto() {
        String path;
        if (isFront) {
             path = Environment.getExternalStorageDirectory().getPath() + "/idFront.jpg";
             Log.d("takePhoto","开始正面拍照》存于="+path);
        }else {
             path = Environment.getExternalStorageDirectory().getPath() + "/idServo.jpg";
             Log.d("takePhoto","开始反面拍照》存于="+path);
        }
        camera.takePicture(path);
    }


    @Override
    public void autoFocus() {
        camera.setAutoFocus();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK&&requestCode==11){
            setResult(11);
            finish();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 22) {
            for (int i=0;i< permissions.length;i++) {
                String s = permissions[i];
                if (s.equals(Manifest.permission.CAMERA) && grantResults[i]== PackageManager.PERMISSION_GRANTED) {
                    setContentView(R.layout.activity_id_cammer);
                    initView();
                }
            }
//            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                  setContentView(R.layout.activity_main);
//                    initView();
//            }
        }


    }
}
