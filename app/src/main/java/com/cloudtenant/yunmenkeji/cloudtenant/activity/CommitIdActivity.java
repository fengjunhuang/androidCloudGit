package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.gersion.library.base.BaseActivity;

import java.io.File;


/**
 * Created by tlol20 on 2017/6/14
 */
public class CommitIdActivity extends BaseActivity implements View.OnClickListener{
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
    private ImageView iv_sign,iv_front,iv_verso;
    private LinearLayout verso,front;
    boolean isFront;
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
        verso=findViewById(R.id.verso);
        front=findViewById(R.id.front);
        iv_front=findViewById(R.id.iv_front);
        iv_verso=findViewById(R.id.iv_verso);
        iv_sign.setOnClickListener(this);
        iv_front.setOnClickListener(this);
        iv_verso.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_sign:{
                startActivityForResult(new Intent(this,SignViewActivity.class),100);
            }break;
            case R.id.iv_front :{
                Intent intent=new Intent(this,IdCammerActivity.class);
                //PreferencesUtils.putBoolean(this,"isFront",false);
                intent.putExtra("isFront",false);
                isFront=false;
                startActivityForResult(intent,103);
            }break;
            case R.id.iv_verso :{
                Intent intent=new Intent(this,IdCammerActivity.class);
                intent.putExtra("isFront",true);
                isFront=true;
                //PreferencesUtils.putBoolean(this,"isFront",true);
                startActivityForResult(intent,104);
            }break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Log.d("takePhoto","Myfinish完成=进入onActivityResult");
        Log.d("takePhoto","Myfinish完成=进入onActivityResult》requestCode="+requestCode+"》》》resultCode="+resultCode);

        if (resultCode == 100) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 2;
            Bitmap bm = BitmapFactory.decodeFile(path, options);
            iv_sign.setImageBitmap(bm);
        } else if (resultCode == 101) {
            //Glide.with(this).load(path1 + ".sign").skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).into(binding.img2);
        }
        if (resultCode==11&&requestCode==103){

            Log.d("takePhoto","Myfinish完成=进入onActivityResult设置图片");
            if (isFront) {
                front.setVisibility(View.GONE);
                //本地文件
                File file = new File(Environment.getExternalStorageDirectory(), "idFront.jpg");
                //加载图片
                Glide.with(this).load(file).into(iv_front);
                //iv_front.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idFront.jpg"));
            }else {
                verso.setVisibility(View.GONE);
                //本地文件
                File file1 = new File(Environment.getExternalStorageDirectory(), "idServo.jpg");
                //加载图片
                Glide.with(this).load(file1).into(iv_verso);
                //iv_verso.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idServo.jpg"));
            }
        }
    }
}
