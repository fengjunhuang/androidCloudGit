package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ListRiskAreaListsDemoAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageOtherAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageRoomAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MessageNoticeModel;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BannerPicassoImageLoader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.OnItemClickLitener;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.view.Solve7PopupWindow;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tlol20 on 2017/6/14
 */
public class MessageRoomActivity extends BaseActivity implements AdapterView.OnItemSelectedListener{

    private EasyRecyclerView recyclerView;
    private MessageRoomAdapter adapter;
    private ArrayAdapter<String> arrayAdapter;
    private Spinner spinner;
    private String telephone="tel:10086";
    private String phone;
    private List<String> list=new ArrayList<>();
    //private TextView tvAllArea;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    //菜单显示PopupWindow
    private PopupWindow mPopWindow;
    private View tvRiskArea;
    private TextView tvTitle;
    private ImageView mImageView;
    private List<Map<String, Object>> riskAreaList = null;
    private int tag=0;
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
                                Toast.makeText(MessageRoomActivity.this, "没有权限打电话哦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
            }
        });
        phone= UserLocalData.getUser(this).getUserPhone();
        spinner=findViewById(R.id.room_spinner);
        mImageView=findViewById(R.id.tvAllArea);
        tvRiskArea=findViewById(R.id.tvRiskArea);
        tvTitle=findViewById(R.id.tvTitle);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick","点击了下拉按钮");
                showRiskAreaPopupWindow();
            }
        });


        recyclerView= findViewById(R.id.recycler_view);
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

    //PopupWindow菜单详细内容显示
    private void showRiskAreaPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(MessageRoomActivity.this).inflate(R.layout.newpages_activity_risk_area_popup_demo, null);
        //适配7.0版本
        mPopWindow = new Solve7PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        mPopWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setContentView(contentView);
        //获取实例，设置各个控件的点击响应
        //注意：PopupWindow中各个控件的所在的布局是contentView，而不是在Activity中，所以，要在findViewById(R.id.tv)前指定根布局
        //TextView tvAllArea = (TextView)contentView.findViewById(R.id.tvAllArea);
        ListView lvRiskArea = (ListView)contentView.findViewById(R.id.lvRiskArea);
        //区域列表加载


        ListRiskAreaListsDemoAdapter listRiskAreaListsDemoAdapter = new ListRiskAreaListsDemoAdapter(
                MessageRoomActivity.this, riskAreaList,
                R.layout.spinner_item, new String[] { "tvAreaItem","tvAreaNo"}, new int[] { R.id.tv,R.id.iv});
        lvRiskArea.setAdapter(listRiskAreaListsDemoAdapter);
        listRiskAreaListsDemoAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                int iTag= (int) riskAreaList.get(position).get("tvAreaNo");
                riskAreaList.get(position).put("tvAreaNo",iTag+2);
                tvTitle.setText(viewDataBeanList.get(position).getMessageBuildingName());
                adapter.removeAll();
                adapter.addAll(viewDataBeanList.get(position).getMessageArray());
                telephone="tel:"+viewDataBeanList.get(position).getMessageLandlordPhone();
                mPopWindow.dismiss();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        /*tvAllArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        //解决5.0以下版本点击外部不消失问题
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示方式
        mPopWindow.showAsDropDown(tvRiskArea);

    }





    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner.setSelection(i);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinner.setSelection(0);

    }
    List<MessageSave.ViewDataBean> viewDataBeanList;
    public void getData() {
        //TODO
        HttpMethods.getInstance().getBuildingNotice(new BaseObserver<MessageSave>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                MessageSave houseDetil= (MessageSave) t;

                System.out.println(houseDetil.getViewData()+"");
                viewDataBeanList=houseDetil.getViewData();

                Log.e("viewDataBeanList",viewDataBeanList.get(0).getMessageBuildingName());
                tvTitle.setText(viewDataBeanList.get(0).getMessageBuildingName());
                riskAreaList = new ArrayList<Map<String, Object>>();
                Map<String,Object> map ;
                for (int i = 0; i < viewDataBeanList.size(); i++) {
                    map = new HashMap<String, Object>();
                    map.put("tvAreaItem", viewDataBeanList.get(i).getMessageBuildingName());
                    //红色图标是否显示
                    if (i==tag) {
                        map.put("tvAreaNo", tag+1);
                    }else {
                        map.put("tvAreaNo", tag);
                    }
                    riskAreaList.add(map);
                }
                banData(houseDetil.getViewData());
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },phone,phone);
    }

    private void banData(List<MessageSave.ViewDataBean> houseDetil) {
        adapter.removeAll();
        adapter.addAll(viewDataBeanList.get(0).getMessageArray());
        telephone="tel:"+viewDataBeanList.get(0).getMessageLandlordPhone();
        for (int i = 0; i < houseDetil.size(); i++) {
            list.add(houseDetil.get(i).getMessageBuildingName());
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
