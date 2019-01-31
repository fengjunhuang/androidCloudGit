package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.SensorAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.base.YzsBaseActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Sensor;
import com.cloudtenant.yunmenkeji.cloudtenant.event.SensorFinshEvent;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SenerNetWork;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class SensorActivity extends YzsBaseActivity implements View.OnClickListener{

    private EasyRecyclerView recyclerView;
    private SensorAdapter adapter;
    private RelativeLayout rela_bg;
    private boolean isSenOpen=true;
    private ImageView iv_senr;
    private TextView tv_tip;
    private String getIsSenOpen;
    private TextView tv_name;

    SensorModel.ViewDataBean bean;
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
        tv_tip=findViewById(R.id.tv_tip);
        iv_senr=findViewById(R.id.iv_senr);
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new SensorAdapter(this);
        recyclerView.setAdapter(adapter);
        rela_bg=findViewById(R.id.rela_bg);
        tv_name=findViewById(R.id.tv_name);

        var1=  getIntent().getExtras();
        bean= (SensorModel.ViewDataBean) var1.getSerializable("isOn");
        getIsSenOpen=bean.getSecurityStatus();
        tv_name.setText("安防"+bean.getGateModel());
        HttpMethods.getInstance().getSensorCycleList(new BaseObserver<SenerNetWork>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                SenerNetWork senerNetWork = (SenerNetWork) t;
                List<Sensor> list=new ArrayList<>();
                for(SenerNetWork.ViewDataBean bean:senerNetWork.getViewData()){
                    list.add(new Sensor(bean.getStartTime()+"-"+bean.getEndTime()));

                }

//                list.add(new Sensor("10:00-11:29"));
//                list.add(new Sensor("17:00-19:29"));
                adapter.addAll(list);

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"13068893276",bean.getSensorId(),"13068893276");

        if(getIsSenOpen.equals("1")){
            isSenOpen=true;
        }else {
            isSenOpen=false;
        }


        //getData();
        AddData();
        rela_bg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isSenOpen){
                    isSenOpen=false;
                    tv_tip.setText("关");
                    bean.setSecurityStatus("0");
                }
                else {
                    tv_tip.setText("开");
                    bean.setSecurityStatus("1");
                    isSenOpen=true;

                }
                HttpMethods.getInstance().setSensorCycleWorkMode(new BaseObserver<BrokenUp>() {
                    @Override
                    protected void onSuccees(BaseBean t) throws Exception {
                        showLongToast(t.getMessage());
                        if(bean.getSecurityStatus().equals("0")){
                        iv_senr.setImageResource(R.drawable.image_sensor_status_off);
                        rela_bg.setBackgroundColor(Color.GRAY);
                        }else {
                            iv_senr.setImageResource(R.drawable.image_sensor_status_on);
                            rela_bg.setBackgroundResource(R.drawable.image_onoffimage);
                        }
                    }

                    @Override
                    protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

                    }
                },"13068893276", bean.getSecurityStatus(),bean.getSensorId(),"13068893276");

            }
        });
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startActivity(new Intent(SensorActivity.this, SensorAddActivity.class));
            }
        });

        getIsSenOpen=bean.getSecurityStatus();

        if(getIsSenOpen.equals("1")){
            isSenOpen=true;
        }else {
            isSenOpen=false;
        }
        if(getIsSenOpen.equals("1")){
            isSenOpen=true;
        }else {
            isSenOpen=false;
        }
        if(!isSenOpen){
            isSenOpen=false;

            tv_tip.setText("关");
            iv_senr.setImageResource(R.drawable.image_sensor_status_off);
            rela_bg.setBackgroundColor(Color.GRAY);}
        else {

            tv_tip.setText("开");
            isSenOpen=true;
            iv_senr.setImageResource(R.drawable.image_sensor_status_on);
            rela_bg.setBackgroundResource(R.drawable.image_onoffimage);
        }
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

    @Override
    protected void onDestroy() {
        EventCenter eventCenter =new EventCenter(200,bean);
        EventBus.getDefault().post(eventCenter);
        super.onDestroy();



    }

    private void AddData() {

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
