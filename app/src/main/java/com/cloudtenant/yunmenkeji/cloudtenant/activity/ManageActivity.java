package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamilyData;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.gersion.library.base.BaseActivity;


/**
 * Created by tlol20 on 2017/6/14
 */
public class ManageActivity extends BaseActivity {
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
        String roomName=intent.getStringExtra("roomName");
        boolean isAdmin=intent.getBooleanExtra("isAdmin",false);
        tvFamilyName.setText(familyName);
        tvRoomName.setText(roomName);
        if (isAdmin) {
            tv_permission.setText("管理员");
        }else {
            tv_permission.setText("成员");
        }

    }



    //List<MyFamily.ViewDataBean> viewDataBeanList;
    private void AddData() {
        HttpMethods.getInstance().familyMemberList(new BaseObserver<MyFamilyData>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                MyFamilyData houseDetil= (MyFamilyData) t;
                //viewDataBeanList=houseDetil.getViewDataX();
                System.out.println(houseDetil.getViewData()+"");
                //adapter.addAll(viewDataBeanList);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }

}
