package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.NoticeAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.NoticeHistory;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;


/**
 * Created by tlol20 on 2017/6/14
 */
public class TestNoticeActivity extends BaseActivity {
    private EasyRecyclerView recyclerView;
    private NoticeAdapter adapter;
    private TextView textView;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    String aa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        aa=getIntent().getStringExtra("aa");
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        textView= findViewById(R.id.tv_title);
        textView .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new NoticeAdapter(this);
        recyclerView.setAdapter(adapter);
        getData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


            }
        });
    }




    List<NoticeHistory.ViewDataBean> viewDataBeanList;
    public void getData() {
        //TODO
//        HttpMethods.getInstance().noticeHistory(new BaseObserver<NoticeHistory>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                NoticeHistory houseDetil= (NoticeHistory) t;
//                System.out.println(houseDetil.getViewData()+"");
//               viewDataBeanList=houseDetil.getViewDataX();
//               viewDataBeanList.get(0).setMessageInfo(aa);
//               viewDataBeanList.get(1).setMessageInfo(aa.substring(0,100).replace("/n", "\n"));
//                adapter.addAll(viewDataBeanList);
//
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//
//            }
//        },"");
    }
}
