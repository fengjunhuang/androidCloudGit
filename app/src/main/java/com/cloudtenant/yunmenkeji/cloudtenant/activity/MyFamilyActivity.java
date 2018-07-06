package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MyFamliyAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class MyFamilyActivity extends BaseActivity {
    private EasyRecyclerView recyclerView;
    private MyFamliyAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);
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
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new MyFamliyAdapter(this);
        recyclerView.setAdapter(adapter);
        //getData();
        AddData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent=new Intent(MyFamilyActivity.this, ManageActivity.class);
                intent.putExtra("RoomName",viewDataBeanList.get(position).getRoomName());
                intent.putExtra("isAdmin",viewDataBeanList.get(position).isIsAdmin());
                intent.putExtra("familyName",viewDataBeanList.get(position).getFamilyName());
                startActivity(intent);
            }
        });
    }

    /*private void AddData() {
        List<MyFamily> list=new ArrayList<>();
        list.add(new MyFamily("我的家庭"));
        list.add(new MyFamily("小米的家庭"));
        list.add(new MyFamily("婷婷的家庭"));
        list.add(new MyFamily("二姑的家庭"));
        list.add(new MyFamily("小姨子的家庭"));
        adapter.addAll(list);
    }*/

    List<MyFamily.ViewDataBean> viewDataBeanList;
    private void AddData() {
        HttpMethods.getInstance().myFamilyList(new BaseObserver<MyFamily>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                MyFamily houseDetil= (MyFamily) t;
                viewDataBeanList=houseDetil.getViewDataX();
                System.out.println(houseDetil.getViewData()+"");
                adapter.addAll(viewDataBeanList);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }
}
