package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageOtherAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageRoomAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BannerPicassoImageLoader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class MessageRoomActivity extends BaseActivity implements AdapterView.OnItemSelectedListener{

    private EasyRecyclerView recyclerView;
    private MessageRoomAdapter adapter;
    private ArrayAdapter<String> arrayAdapter;
    private Spinner spinner;
    private String telephone="tel:10086";
    private List<String> list=new ArrayList<>();

    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_room);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.ll_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndPermission.with(MessageRoomActivity.this)
                        .permission(Permission.CALL_PHONE, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @SuppressLint("MissingPermission")
                            @Override
                            public void onAction(Object data) {
                                //用intent启动拨打电话
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(telephone));
                                startActivity(intent);
                            }
                        })
                        .onDenied(new Action() {
                            @Override
                            public void onAction(Object data) {
                                /*Uri packageURI = Uri.parse("package:" + getActivity().getPackageName());
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);*/

                                Toast.makeText(MessageRoomActivity.this, "没有权限打电话哦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
            }
        });
        spinner=findViewById(R.id.room_spinner);




        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new MessageRoomAdapter(this);
        recyclerView.setAdapter(adapter);
        getData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                if (position==1) {
                    startActivity(new Intent(MessageRoomActivity.this, MessageTraceActivity.class));
                }
                else{
                    startActivity(new Intent(MessageRoomActivity.this, NoticeActivity.class));

                }

            }
        });
    }

    /*

    private void AddData1() {
        List<MessageRoom> dataList=new ArrayList<>();
        dataList.add(new MessageRoom("夏天到了，我請大家去大保健","2018年6月20日 17:26:00"));
        dataList.add(new MessageRoom("你的房間沒有任何情況","2018年6月20日 17:26:00"));
        adapter.addAll(dataList);
    }*/


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner.setSelection(i);
        adapter.removeAll();
        adapter.addAll(viewDataBeanList.get(i).getMessageArray());
        telephone="tel:"+viewDataBeanList.get(i).getMessageLandlordPhone();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinner.setSelection(0);

    }
    List<MessageSave.ViewDataBean> viewDataBeanList;
    public void getData() {
        HttpMethods.getInstance().messageSave(new BaseObserver<MessageSave>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                MessageSave houseDetil= (MessageSave) t;

                System.out.println(houseDetil.getViewData()+"");
                viewDataBeanList=houseDetil.getViewDataX();

                Log.e("viewDataBeanList",viewDataBeanList.get(0).getMessageRoomName());
                banData(houseDetil.getViewDataX());
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }

    private void banData(List<MessageSave.ViewDataBean> houseDetil) {

        for (int i = 0; i < houseDetil.size(); i++) {
            list.add(houseDetil.get(i).getMessageRoomName());
        }
        /*新建适配器*/
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);

        /*adapter设置一个下拉列表样式，参数为系统子布局*/
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        /*spDown加载适配器*/
        spinner.setAdapter(arrayAdapter);

        /*soDown的监听器*/
        spinner.setOnItemSelectedListener(this);
    }
}
