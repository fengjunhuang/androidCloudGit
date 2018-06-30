package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.SensorAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Sensor;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class SensorActivity extends YzsBaseActivity implements View.OnClickListener{

    private EasyRecyclerView recyclerView;
    private SensorAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initContentView(Bundle var1) {
        setContentView(R.layout.activity_sensor);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.tv_add).setOnClickListener(this);
        findViewById(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new SensorAdapter(this);
        recyclerView.setAdapter(adapter);
        //getData();
        AddData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(SensorActivity.this, SensorAddActivity.class));
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) {

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }

    private void AddData() {
        List<Sensor> list=new ArrayList<>();
        list.add(new Sensor("10:00-11:29"));
        list.add(new Sensor("17:00-19:29"));
        adapter.addAll(list);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pickPhotoBtn:{
                Toast.makeText(this, "申请退房！", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.tv_add:{
                startActivity(new Intent(this, SensorAddActivity.class));
            }break;

        }
    }
    /*private void getData() {
        Map<String,Object> params = new HashMap<>(2);
        params.put("page",1);
        params.put("rows",20);
        ok.post(Contants.API.SCAN_LIST, params, new SimpleCallback<Scan>(this) {
            @Override
            public void onSuccess(okhttp3.Response response, Scan o) {
                if (o.getMsg().getCode()==0) {
                    adapter.addAll(o.getRowSet());
                }
            }

            @Override
            public void onError(okhttp3.Response response, int code, Exception e) {

            }
        });
    }*/
}
