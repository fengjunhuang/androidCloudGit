package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.squareup.picasso.Picasso;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.zph.glpanorama.GLPanorama;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 72984 on 2018/6/24.
 */

public class OnlineVisitAcivity extends YzsBaseActivity {
   private VrPanoramaView mGLPanorama;
 BudingInfo.ViewDataBean.DataBean bean;
    private static final int SUCCESS = 1;
    private static final int FALL = 2;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                //加载网络成功进行UI的更新,处理得到的图片资源
                case SUCCESS:
                    //通过message，拿到字节数组
                    byte[] Picture = (byte[]) msg.obj;
                    //使用BitmapFactory工厂，把字节数组转化为bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);
                    //通过imageview，设置图片
                    VrPanoramaView.Options aNormalOptions= new VrPanoramaView.Options();
                    aNormalOptions.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
                    mGLPanorama.loadImageFromBitmap(bitmap,aNormalOptions);

                    break;
                //当加载网络失败执行的逻辑代码
                case FALL:
                    Toast.makeText(OnlineVisitAcivity.this, "网络出现了问题", Toast.LENGTH_SHORT).show();
                    break;
            }
        }};

        @Override
    protected void initContentView(Bundle var1) {
     setContentView(R.layout.activity_online_visit);
    }

    @Override
    protected void initView() {
        mGLPanorama= (VrPanoramaView) findViewById(R.id.mVrPanoramaView);
        //传入你的全景图



     // mVrPanoramaView.setFullscreenButtonEnabled (false); //隐藏全屏模式按钮 mVrPanoramaView.setInfoButtonEnabled(false); 
     // 设置隐藏最左边信息的按钮 mVrPanoramaView.setStereoModeButtonEnabled(false); 
     // 设置隐藏立体模型的按钮 mVrPanoramaView.setEventListener(new ActivityEventListener()); //设置监听 //
        getBundleExtras(getIntent().getExtras());
//        Picasso.with(this).load(bean.getRoomMoreImageArr().get(0).getImageUrl()).
//        try {
//            mGLPanorama.loadImageFromBitmap(, aNormalOptions);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
           loadImage(bean.getRoomMoreImageArr().get(0).getImageUrl());

    }

    private void loadImage(String path) {
        //1.创建一个okhttpclient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request.Builder对象，设置参数，请求方式如果是Get，就不用设置，默认就是Get
        Request request = new Request.Builder()
                .url(path)
                .build();
        //3.创建一个Call对象，参数是request对象，发送请求
        Call call = okHttpClient.newCall(request);
        //4.异步请求，请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //得到从网上获取资源，转换成我们想要的类型
                byte[] Picture_bt = response.body().bytes();
                //通过handler更新UI
                Message message = handler.obtainMessage();
                message.obj = Picture_bt;
                message.what = SUCCESS;
                handler.sendMessage(message);
            }
        });

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) {

     bean = (BudingInfo.ViewDataBean.DataBean) var1.getSerializable("bean");

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }
}
