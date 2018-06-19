package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MyFamliyAdapter;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

/**
 * Created by tlol20 on 2017/6/14
 */
public class EditProFileActivity extends BaseActivity {
    private EasyRecyclerView recyclerView;
    private MyFamliyAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_family);
        ((TextView)findViewById(R.id.title)).setText("谁看过我");
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#ececec"), 1));
        recyclerView.setAdapter(adapter = new MyFamliyAdapter(this));
        //getData();
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
