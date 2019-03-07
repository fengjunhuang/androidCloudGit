package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MyCollectionAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyCollection;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class MyReviewActivity extends YzsBaseActivity {
    private EasyRecyclerView recyclerView;
    private MyCollectionAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    private String userPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);
        userPhone= UserLocalData.getUser(this).getUserPhone();
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView title=findViewById(R.id.title);
        title.setText("浏览记录");
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new MyCollectionAdapter(this);
        recyclerView.setAdapter(adapter);
        AddData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                openActivity(viewDataBeanList.get(position).getRoomID());

            }
        });
    }

    @Override
    protected void initContentView(Bundle var1) {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle var1) throws Exception {

    }

    @Override
    protected void onEventComing(EventCenter var1) {

    }

    private void openActivity(String roomid) {
        Bundle bundle =new Bundle();
        bundle.putBoolean("isMap",true);
        bundle.putString("roomId",roomid);
        readyGo(TnementAcitivity_.class,bundle);
    }

    List<MyCollection.ViewDataBean> viewDataBeanList;
    private void AddData() {
        //TODO
        HttpMethods.getInstance().getReviewList(new BaseObserver<MyCollection>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                MyCollection houseDetil= (MyCollection) t;
                viewDataBeanList=houseDetil.getViewData();
                System.out.println(houseDetil.getViewData()+"");
                adapter.addAll(viewDataBeanList);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },userPhone,userPhone,"","","","","","","");
    }
}
