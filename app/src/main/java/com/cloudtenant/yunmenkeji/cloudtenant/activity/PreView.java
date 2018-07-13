package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
public class PreView extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Log.d("takePhoto","完成takePicture=进入PreView");
        initView();
    }

    private void initView() {
        /*imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageBitmap(BitmapFactory.decodeFile(path));*/
        setResult(11);
        Log.d("takePhoto","完成takePicture=进入PreView》initView");
        finish();
    }
}
