package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.gersion.library.base.BaseActivity;

import java.io.File;


/**
 * Created by tlol20 on 2017/6/14
 */
public class CommitIdActivity extends BaseActivity implements View.OnClickListener{
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
    private ImageView iv_sign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_id);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_sign=findViewById(R.id.iv_sign);
        iv_sign.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_sign:{
                startActivityForResult(new Intent(this,SignViewActivity.class),100);
            }break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 100) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(path, options);
            iv_sign.setImageBitmap(bm);
        } else if (resultCode == 101) {
            //Glide.with(this).load(path1 + ".sign").skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(binding.img2);
        }
    }
}
