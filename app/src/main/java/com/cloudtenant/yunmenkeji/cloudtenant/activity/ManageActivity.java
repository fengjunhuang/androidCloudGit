package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamilyData;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.QrUtils;
import com.gersion.library.base.BaseActivity;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ManageActivity extends BaseActivity {
    private String content, familyID;
    private ImageView iv_qr_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_famliy_manage);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.rl_qr_code).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=
                        new Intent(ManageActivity.this,QrCodeActivity.class);
                intent.putExtra("familyID",familyID);
                startActivity(intent);
            }
        });
        findViewById(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.ll_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddData();
            }
        });
        TextView tvFamilyName=findViewById(R.id.tv_name);
        TextView tvRoomName=findViewById(R.id.tv_room_number);
        TextView tv_permission=findViewById(R.id.tv_permission);
        Intent intent=getIntent();
        String familyName=intent.getStringExtra("familyName");
        String roomName=intent.getStringExtra("RoomName");
        familyID=intent.getStringExtra("familyID");
        boolean isAdmin=intent.getBooleanExtra("isAdmin",false);
        tvFamilyName.setText(familyName);
        tvRoomName.setText(roomName);
        if (isAdmin) {
            tv_permission.setText("管理员");
        }else {
            tv_permission.setText("成员");
        }
        iv_qr_code=findViewById(R.id.iv_qr_code);

        content="{\n" +
                "\t\"cellCost\": \"\",\n" +
                "\t\"cellBuildID\": \"\",\n" +
                "\t\"cellImage\": \"\",\n" +
                "\t\"qrType\": \"1\",\n" +
                "\t\"familyID\": \""+familyID+"\",\n" +
                "\t\"cellName\": \"\",\n" +
                "\t\"cellRemain\": \"\",\n" +
                "\t\"cellRoomID\": \"\",\n" +
                "\t\"cellAddress\": \"\"\n" +
                "}";

        Log.d("getData","width="+iv_qr_code.getWidth()+">>>>>height="+iv_qr_code.getHeight());

        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.UNSPECIFIED);
        iv_qr_code.measure(w,h);
        Log.d("getData","width="+iv_qr_code.getMeasuredWidth()+">>>>>height="+iv_qr_code.getMeasuredHeight());
        /*Bitmap bitmap = QrUtils.createQRImage(content, iv_qr_code.getWidth(),  iv_qr_code.getHeight());
        iv_qr_code.setImageBitmap(bitmap);*/
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bitmap bitmap = QrUtils.createQRImage(content, iv_qr_code.getMeasuredWidth(),  iv_qr_code.getMeasuredHeight());
        iv_qr_code.setImageBitmap(bitmap);
    }

    //List<MyFamily.ViewDataBean> viewDataBeanList;
    private void AddData() {
        //TODO
//        HttpMethods.getInstance().familyMemberList(new BaseObserver<MyFamilyData>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                MyFamilyData houseDetil= (MyFamilyData) t;
//                //viewDataBeanList=houseDetil.getViewDataX();
//                System.out.println(houseDetil.getViewData()+"");
//                //adapter.addAll(viewDataBeanList);
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//
//            }
//        },"");
    }

}
