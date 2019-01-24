package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.view.HandWriteView;
import com.gersion.library.base.BaseActivity;

import java.io.File;
import java.io.IOException;

import static com.cloudtenant.yunmenkeji.cloudtenant.activity.CommitIdActivity.SIGN_REQUEST_CODE;


/**
 * Created by tlol20 on 2017/6/14
 */
public class SignViewActivity extends BaseActivity {
    HandWriteView handWriteView;
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        setContentView(R.layout.activity_sign_view);
        handWriteView=findViewById(R.id.view);
        final TextView tips=findViewById(R.id.tips);
        final TextView title=findViewById(R.id.title);

        handWriteView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                title.setVisibility(View.VISIBLE);
                tips.setVisibility(View.GONE);
                return false;
            }
        });
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               handWriteView.clear();
                title.setVisibility(View.GONE);
               tips.setVisibility(View.VISIBLE);

            }
        });
        findViewById(R.id.commit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (handWriteView.isSign())
                    try {

                        handWriteView.save(path);
                        setResult(SIGN_REQUEST_CODE);
                        finish();
                        /*if (isCrop) {
                            handWriteView.save(MainActivity.path1, true, 10,true);
                            setResult(101);
                            finish();
                        } else {

                        }*/
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                else {
                    Toast.makeText(SignViewActivity.this, "还没有签名！", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
