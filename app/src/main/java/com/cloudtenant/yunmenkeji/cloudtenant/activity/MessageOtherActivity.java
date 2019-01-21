package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ContractAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageOtherAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
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
public class MessageOtherActivity extends BaseActivity implements View.OnClickListener{

    private EasyRecyclerView recyclerView;
    private MessageOtherAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_other);
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
        adapter = new MessageOtherAdapter(this);
        recyclerView.setAdapter(adapter);
        getData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (viewDataBeanList.get(position).getContractType()==1) {
                    showPopupWindow();
                }

            }
        });
    }


    SelectPicPopupWindow mPopWindow;
    private void showPopupWindow() {
        //设置contentView
        mPopWindow = new SelectPicPopupWindow(this,this,"2");
        mPopWindow.showAsDropDown(LayoutInflater.from(this).inflate(R.layout.activity_me, null));

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
    List<MessageOther.ViewDataBean> viewDataBeanList;
    public void getData() {
        //TODO
//        HttpMethods.getInstance().otherMessage(new BaseObserver<MessageOther>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                MessageOther houseDetil= (MessageOther) t;
//                System.out.println(houseDetil.getViewData()+"");
//                viewDataBeanList=houseDetil.getViewDataX();
//                adapter.addAll(viewDataBeanList);
//               /* viewDataBeanList=houseDetil.getViewDataX();
//
//                banData(houseDetil.getViewDataX());*/
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//
//            }
//        },"");
    }

}
