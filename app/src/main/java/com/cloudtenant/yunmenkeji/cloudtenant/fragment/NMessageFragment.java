package com.cloudtenant.yunmenkeji.cloudtenant.fragment;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.FragmentAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ListRiskAreaListsDemoAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageRoomAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.OnItemClickLitener;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.view.Solve7PopupWindow;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class NMessageFragment extends YzsBaseListFragment<HouseDetil> implements  AdapterView.OnItemSelectedListener{



    private String[] mTabTitles = new String[]{"楼宇公告","签约消息","支付消息","房间消息"};
    public ViewPager viewPager;
    private ArrayAdapter<String> arrayAdapter;
    private Spinner spinner;
    private PopupWindow mPopWindow;
    private List<Map<String, Object>> riskAreaList = null;
    private List<Map<String, Object>> riskAreaList3 = null;
    private View tvRiskArea;
    private ImageView mImageView;
    private ImageView iv_phone;
    private TextView tvTitle;
    private MessageRoomAdapter adapter;
    private String phone;
    private List<String> list=new ArrayList<>();
    private int tag=0,roomP0=0,roomP3=0,titleTag=0;
    public MessageRoomFragment messageRoomFragment=new MessageRoomFragment();
    public RoomMessageFragment roomFragment=new RoomMessageFragment();
    private String telephone="tel:10086";
    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view=layoutInflater.inflate(R.layout.fragment_message_one,viewGroup,false);
        phone= UserLocalData.getUser(getActivity()).getUserPhone();
        spinner=view.findViewById(R.id.room_spinner);
        mImageView=view.findViewById(R.id.tvAllArea);
        tvRiskArea=view.findViewById(R.id.tvRiskArea);
        iv_phone=view.findViewById(R.id.iv_phone);
        iv_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndPermission.with(getActivity())
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
                                Toast.makeText(getActivity(), "没有权限打电话哦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
            }
        });
        tvTitle=view.findViewById(R.id.tvTitle);
        tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titleTag==0||titleTag==3){
                    showRiskAreaPopupWindow();
                }
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("onClick","点击了下拉按钮");
                showRiskAreaPopupWindow();
            }
        });

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        viewPager = view.findViewById(R.id.viewpager);

        Fragment[] fragments ={messageRoomFragment
                ,new MessageOtherFragment(),new MessagePayFragment (),roomFragment};
        /*FragmentManager manager=getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(messageRoomFragment,"Fragment0");
        transaction.commit();*/
        viewPager.setAdapter(new FragmentAdapter(getChildFragmentManager(), fragments, mTabTitles));
        viewPager.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e("onPageSelected","position="+position);
                switch (position){
                    case 0:{
                        mImageView.setVisibility(View.VISIBLE);
                        iv_phone.setVisibility(View.VISIBLE);
                        titleTag=0;
                        tvTitle.setText(viewDataBeanList.get(roomP0).getMessageBuildingName());
                    }break;case 1:{
                        tvTitle.setText("签约消息");
                        titleTag=1;
                        mImageView.setVisibility(View.GONE);
                        iv_phone.setVisibility(View.GONE);
                    }break;case 2:{
                        mImageView.setVisibility(View.GONE);
                        iv_phone.setVisibility(View.GONE);
                        titleTag=2;
                        tvTitle.setText("支付消息");
                    }break;case 3:{
                        titleTag=3;
                        tvTitle.setText(viewDataBeanList3.get(roomP3).getMyRoomName());
                        mImageView.setVisibility(View.VISIBLE);
                        iv_phone.setVisibility(View.GONE);
                    }break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        getData();
        return view;
    }

    //PopupWindow菜单详细内容显示
    private void showRiskAreaPopupWindow() {
        //设置contentView
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.newpages_activity_risk_area_popup_demo, null);
        //适配7.0版本
        mPopWindow = new Solve7PopupWindow(contentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
//        mPopWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
        mPopWindow.setContentView(contentView);
        //获取实例，设置各个控件的点击响应
        //注意：PopupWindow中各个控件的所在的布局是contentView，而不是在Activity中，所以，要在findViewById(R.id.tv)前指定根布局
        //TextView tvAllArea = (TextView)contentView.findViewById(R.id.tvAllArea);
        ListView lvRiskArea = (ListView)contentView.findViewById(R.id.lvRiskArea);
        //区域列表加载
        ListRiskAreaListsDemoAdapter listRiskAreaListsDemoAdapter;
        if (titleTag==0){
            listRiskAreaListsDemoAdapter= new ListRiskAreaListsDemoAdapter(
                    getActivity(), riskAreaList,
                    R.layout.spinner_item, new String[] { "tvAreaItem","tvAreaNo"}, new int[] { R.id.tv,R.id.iv});
        }else {
             listRiskAreaListsDemoAdapter = new ListRiskAreaListsDemoAdapter(
                    getActivity(), riskAreaList3,
                    R.layout.spinner_item, new String[] { "tvAreaItem","tvAreaNo"}, new int[] { R.id.tv,R.id.iv});
        }

        lvRiskArea.setAdapter(listRiskAreaListsDemoAdapter);
        listRiskAreaListsDemoAdapter.setOnItemClickLitener(new OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                int iTag= (int) riskAreaList.get(position).get("tvAreaNo");
                riskAreaList.get(position).put("tvAreaNo",iTag+2);
                if (titleTag==0){
                roomP0=position;
                tvTitle.setText(viewDataBeanList.get(roomP0).getMessageBuildingName());
                messageRoomFragment.selectedItem(roomP0);
                }else {
                roomP3=position;
                tvTitle.setText(viewDataBeanList3.get(roomP3).getMyRoomName());
                roomFragment.roomName=viewDataBeanList3.get(roomP3).getMyRoomName();
                roomFragment.selectedItem(viewDataBeanList3.get(position).getMyRoomID());

                }
                //adapter.removeAll();
                //adapter.addAll(viewDataBeanList.get(position).getMessageArray());
                //telephone="tel:"+viewDataBeanList.get(position).getMessageLandlordPhone();
                mPopWindow.dismiss();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        //解决5.0以下版本点击外部不消失问题
        mPopWindow.setOutsideTouchable(true);
        mPopWindow.setBackgroundDrawable(new BitmapDrawable());
        //显示方式
        mPopWindow.showAsDropDown(tvRiskArea);

    }


    List<MessageSave.ViewDataBean> viewDataBeanList;
    List<RoomModel.ViewDataBean> viewDataBeanList3;
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
        },phone,phone, UserLocalData.getUser(getActivity()).getTokenID(),"","","","","","","true");

        HttpMethods.getInstance().findRoomMessageByPhone(new BaseObserver<RoomModel>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                RoomModel houseDetil= (RoomModel) t;
                System.out.println(houseDetil.getViewData()+"");
                viewDataBeanList3=houseDetil.getViewData();
                roomFragment.myRoomID=viewDataBeanList3.get(0).getMyRoomID();
                roomFragment.roomName=viewDataBeanList3.get(0).getMyRoomName();
                Log.e("viewDataBeanList3",viewDataBeanList3.get(0).getMyRoomName());
                riskAreaList3 = new ArrayList<Map<String, Object>>();
                Map<String,Object> map ;
                for (int i = 0; i < viewDataBeanList3.size(); i++) {
                    map = new HashMap<String, Object>();
                    map.put("tvAreaItem", viewDataBeanList3.get(i).getMyRoomName());
                    //红色图标是否显示
                    if (i==tag) {
                        map.put("tvAreaNo", tag+1);
                    }else {
                        map.put("tvAreaNo", tag);
                    }
                    riskAreaList3.add(map);
                }
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },phone,phone,UserLocalData.getUser(getActivity()).getTokenID(),"","","","","","");
    }

    private void banData(List<MessageSave.ViewDataBean> houseDetil) {
        adapter.removeAll();
        adapter.addAll(viewDataBeanList.get(0).getMessageArray());
        telephone="tel:"+viewDataBeanList.get(0).getMessageLandlordPhone();
        for (int i = 0; i < houseDetil.size(); i++) {
            list.add(houseDetil.get(i).getMessageBuildingName());
        }
        /*新建适配器*/
        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,list);

        /*adapter设置一个下拉列表样式，参数为系统子布局*/
        //arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        /*spDown加载适配器*/
        spinner.setAdapter(arrayAdapter);

        /*soDown的监听器*/
        spinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        spinner.setSelection(i);
        telephone="tel:"+viewDataBeanList.get(i).getMessageLandlordPhone();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        spinner.setSelection(0);

    }
    @Override
    protected void initView(View view) {
        //super.initView(view);

    }

    @Override
    protected void initItemLayout() {


    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, HouseDetil indexdata) {

    }



    @Override
    protected void initLogic() {

    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
