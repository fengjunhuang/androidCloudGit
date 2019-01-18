package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.signature.StringSignature;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IdDetails;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.IdFront;
import com.cloudtenant.yunmenkeji.cloudtenant.util.JSONUtil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.PreferencesUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.util.Youtu;
import com.cloudtenant.yunmenkeji.cloudtenant.util.base64.Test;
import com.cloudtenant.yunmenkeji.cloudtenant.util.misc.BASE64Encoder;
import com.gersion.library.base.BaseActivity;
import com.yzs.yzslibrary.util.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import dmax.dialog.SpotsDialog;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * Created by tlol20 on 2017/6/14
 */
public class CommitIdActivity extends BaseActivity implements View.OnClickListener{
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qm.png";
    private ImageView iv_sign,iv_front,iv_verso;
    private LinearLayout verso,front;
    boolean isFront;
    private SpotsDialog mDialog;
    private EditText et_phone;

    //提交所需数据
    private String userPhone;
    private String buildingID;
    private String roomId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commit_id);
        mDialog = new SpotsDialog(this);
        userPhone= UserLocalData.getUser(this).getUserPhone();
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_sign=findViewById(R.id.iv_sign);
        et_phone=findViewById(R.id.et_phone);
        verso=findViewById(R.id.verso);
        front=findViewById(R.id.front);
        iv_front=findViewById(R.id.iv_front);
        iv_verso=findViewById(R.id.iv_verso);
        iv_sign.setOnClickListener(this);
        iv_front.setOnClickListener(this);
        iv_verso.setOnClickListener(this);
        et_phone.setText(userPhone);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_sign:{
                startActivityForResult(new Intent(this,SignViewActivity.class),100);
            }break;
            case R.id.iv_front :{
                Intent intent=new Intent(this,IdCammerActivity.class);
                PreferencesUtils.putBoolean(this,"isFront",true);
                intent.putExtra("isFront",false);
                isFront=true;
                 Log.d("takePhoto","点击正面="+isFront);
                startActivityForResult(intent,103);
            }break;
            case R.id.iv_verso :{
                Intent intent=new Intent(this,IdCammerActivity.class);
                intent.putExtra("isFront",true);
                isFront=false;
                PreferencesUtils.putBoolean(this,"isFront",false);
                 Log.d("takePhoto","点击反面="+isFront);
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
        if (resultCode==11){

            Log.d("takePhoto","isFront="+isFront);
            if (isFront) {
                front.setVisibility(View.GONE);
                //本地文件
                File file1 = new File(Environment.getExternalStorageDirectory(), "idServo.jpg");
                //加载图片
                Glide.with(this).load(file1).signature(new StringSignature(GetNowTime())).into(iv_front);
                //iv_front.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idFront.jpg"));
            Log.d("takePhoto","进入onActivityResult设置图片路径="+file1.getPath());
                getIdDetails(file1.getPath(),0);
            }else {
                verso.setVisibility(View.GONE);
                //本地文件
                File file = new File(Environment.getExternalStorageDirectory(), "idFront.jpg");
                //加载图片
                Log.d("takePhoto","进入onActivityResult设置图片路径="+file.getPath());
                getIdDetails(file.getPath(),1);
                Glide.with(this).load(file).signature(new StringSignature(GetNowTime())).into(iv_verso);
                //iv_verso.setImageBitmap(BitmapFactory.decodeFile(Environment.getExternalStorageDirectory().getPath() + "/idServo.jpg"));
            }
        }
    }
    private Bitmap theSelectedImage = null;
    private void getIdDetails(String filePath, final int type) {

        theSelectedImage = getBitmap(filePath, 1000, 1000);
        new Thread(new Runnable() {
            @Override
            public void run() {

                if (theSelectedImage != null) {
                    try {
                        Youtu faceYoutu = new Youtu(APP_ID, SECRET_ID, SECRET_KEY,Youtu.API_YOUTU_END_POINT);
                        JSONObject respose = faceYoutu.IdcardOcr(theSelectedImage, type);
                        String s=respose.toString();
                        LogUtils.e(s);
                        getBean(isFront,s);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
    IdDetails idDetails;
    IdFront idFront;
    private void getBean(boolean isFront,String s) {
        if (isFront) {
            idDetails=JSONUtil.fromJson(s,IdDetails.class);

                        LogUtils.e(idDetails.toString());
        }else {
            idFront=JSONUtil.fromJson(s,IdFront.class);
                        LogUtils.e(idFront.toString());
        }

    }

    private Bitmap getBitmap(String path , int maxWidth, int maxHeight){
        //先解析图片边框的大小
        Bitmap bm = null;
        File file = new File(path);
        if(file.exists()) {
            BitmapFactory.Options ops = new BitmapFactory.Options();
            ops.inJustDecodeBounds = true;
            ops.inSampleSize = 1;
            BitmapFactory.decodeFile(path, ops);
            int oHeight = ops.outHeight;
            int oWidth = ops.outWidth;

            //控制压缩比
            int contentHeight = maxWidth;
            int contentWidth = maxHeight;
            if (((float) oHeight / contentHeight) < ((float) oWidth / contentWidth)) {
                ops.inSampleSize = (int) Math.ceil((float) oWidth / contentWidth);
            } else {
                ops.inSampleSize = (int) Math.ceil((float) oHeight / contentHeight);
            }
            ops.inJustDecodeBounds = false;
            bm = BitmapFactory.decodeFile(path, ops);

        }

        return bm;
    }


    public  String GetNowTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());// 获取当前时间
        String str = formatter.format(curDate);
        return str;
    }

    private String APP_ID = "10140989";
    private String SECRET_ID = "AKIDEH9m9G3oEjz0qRIukOo6C4j9JhsqpATX";
    private String SECRET_KEY = "zmMkuqZO1RdaJowviGZcQ3UhhU7WjiSH";


}
