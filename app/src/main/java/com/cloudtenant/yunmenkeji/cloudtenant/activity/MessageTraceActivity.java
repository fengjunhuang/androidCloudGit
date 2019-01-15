package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageOtherAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.TraceListAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Trace;
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
public class MessageTraceActivity extends BaseActivity implements View.OnClickListener{

    private EasyRecyclerView recyclerView;
    private TraceListAdapter adapter;
    private List<Trace> traceList = new ArrayList<>(10);
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
        ((TextView)findViewById(R.id.title)).setText("安全日志");
        findViewById(R.id.line).setVisibility(View.GONE);
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        AddData();


        //getData();

    }
    List<RoomMessageHistory.ViewDataBean> viewDataBean;
    private void AddData() {
        HttpMethods.getInstance().roomMessageHistory(new BaseObserver<RoomMessageHistory>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                RoomMessageHistory houseDetil= (RoomMessageHistory) t;

                System.out.println(houseDetil.getViewData()+"");
                viewDataBean=houseDetil.getViewDataX();
                for (int i = 0; i < viewDataBean.get(0).getHistoryTime().size(); i++) {
                    Log.e("viewDataBeanList",viewDataBean.get(0).getHistoryTime().toString());
                    traceList.add(new Trace(viewDataBean.get(0).getHistoryTime().get(i), viewDataBean.get(0).getHistoryInfo().get(i)));

                }
                for (int i = 0; i < traceList.size(); i++) {

                    Log.e("viewDataBeanList","traceList.get(i).toString()="+traceList.get(i).toString());

                }
                adapter = new TraceListAdapter (MessageTraceActivity.this,traceList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }



    SelectPicPopupWindow mPopWindow;
    private void showPopupWindow() {
        //设置contentView
        mPopWindow = new SelectPicPopupWindow(this,this,"0");
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
}
