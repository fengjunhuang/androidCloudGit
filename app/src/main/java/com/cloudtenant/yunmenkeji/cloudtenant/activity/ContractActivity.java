package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ContractAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class ContractActivity extends BaseActivity implements View.OnClickListener{

    private EasyRecyclerView recyclerView;
    private ContractAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contract);
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
        adapter = new ContractAdapter(this);
        recyclerView.setAdapter(adapter);
        //getData();
        AddData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showPopupWindow(viewDataBeanList.get(position).getContractType());
            }
        });
    }


    SelectPicPopupWindow mPopWindow;
    private void showPopupWindow(int contractType) {
        //设置contentView
        mPopWindow = new SelectPicPopupWindow(this,this,contractType);
        mPopWindow.showAsDropDown(LayoutInflater.from(this).inflate(R.layout.activity_my_contract, null));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pickPhotoBtn:{
                Toast.makeText(this, "申请退房！", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.cancelBtn:{
                mPopWindow.dismiss();
            }break;

        }
    }
    List<MyContract.ViewDataBean> viewDataBeanList;
    private void AddData() {
        HttpMethods.getInstance().myContract(new BaseObserver<MyContract>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                MyContract houseDetil= (MyContract) t;
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
