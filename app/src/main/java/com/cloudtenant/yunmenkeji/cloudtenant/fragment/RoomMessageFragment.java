package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;


import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MessageSensorActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MessageTraceActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.NoticeActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageRoomAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.RoomMessageAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RoomMessageFragment extends Fragment implements View.OnClickListener {


    private EasyRecyclerView recyclerView;
    private RoomMessageAdapter adapter;
    private ArrayAdapter<String> arrayAdapter;
    private String phone;
    private List<String> list;
    public String myRoomID;
    public String roomName;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_message_other,container,false);

        phone= UserLocalData.getUser(getActivity()).getUserPhone();
        list=new ArrayList<>();
        recyclerView= view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerDecoration(Color.TRANSPARENT, 30));
        adapter = new RoomMessageAdapter(getActivity());
        recyclerView.setAdapter(adapter);
        getData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent intent=new Intent(getActivity(), MessageSensorActivity.class);
                intent.putExtra("t_name",roomName);
                intent.putExtra("b_name",viewDataBeanList.get(position).getGateModel());
                intent.putExtra("roomId",myRoomID);
                    startActivity(intent);
            }
        });
        return view;
    }
    public void selectedItem(String myRoomID) {
        this.myRoomID=myRoomID;
        getData();
    }
    List<SensorModel.ViewDataBean> viewDataBeanList;
    public void getData() {
        Log.d("getRoomSensorList","RoomId="+myRoomID);
        //查找传感器列表
        HttpMethods.getInstance().getRoomSensorList(new BaseObserver<SensorModel>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                SensorModel houseDetil= (SensorModel) t;
                System.out.println(houseDetil.getViewData()+"");
                viewDataBeanList=houseDetil.getViewData();
                adapter.removeAll();
                adapter.addAll(viewDataBeanList);
            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
            }
        },UserLocalData.getUser(getContext()).getUserPhone(),myRoomID,UserLocalData.getUser(getContext()).getTokenID(),"","","","","","");
    }

    private void banData(List<MessageSave.ViewDataBean> houseDetil) {
      /*  adapter.removeAll();
        adapter.addAll(viewDataBeanList.get(0).getMessageArray());

        for (int i = 0; i < houseDetil.size(); i++) {
            list.add(houseDetil.get(i).getMessageBuildingName());
        }*/

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){


        }
    }
}
