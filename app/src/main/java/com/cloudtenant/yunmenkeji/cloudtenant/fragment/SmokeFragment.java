package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.TraceListAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Trace;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.jude.easyrecyclerview.EasyRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class SmokeFragment extends Fragment{

    private EasyRecyclerView recyclerView;
    private TraceListAdapter adapter;
    private List<Trace> traceList = new ArrayList<>();
    private String phone;
    public String roomId;
    public String sensorModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_message_other,container,false);
        phone= UserLocalData.getUser(getActivity()).getUserPhone();
        recyclerView= (EasyRecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));

        /*getData();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e("onItemClick",viewDataBeanList.get(position).toString());
                switch (viewDataBeanList.get(position).getMessageType()){
                    case "0":{
                        if (viewDataBeanList.get(position).getPay_status().equals("0")){
                            normalDialog1(viewDataBeanList.get(position).getWidoutTradeMoney(),
                                    viewDataBeanList.get(position).getWidoutTradeNo(),
                                    viewDataBeanList.get(position).getRoomId());
                        }else {
                            normalDialog();
                        }
                    }break;
                }
            }
        });*/
        AddData();
        return view;
    }
    List<RoomMessageHistory.ViewDataBean> viewDataBean;
    private void AddData() {
        //TODO
        HttpMethods.getInstance().getSensorMessageList(new BaseObserver<RoomMessageHistory>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                RoomMessageHistory houseDetil= (RoomMessageHistory) t;

                System.out.println(houseDetil.getViewData()+"");
                viewDataBean=houseDetil.getViewData();
                for (RoomMessageHistory.ViewDataBean dataBean : viewDataBean) {
                    if (dataBean.getSensorModel().equals(sensorModel)) {
                        for (int i = 0; i < dataBean.getSensorBodyMessage().size(); i++) {
                            Trace trace=new Trace(dataBean.getSensorBodyMessage().get(i).getCreateTime(),dataBean.getSensorBodyMessage().get(1).getBody());
                            trace.setState("3");
                            traceList.add(trace);
                        }
                    }
                }

                for (int i = 0; i < traceList.size(); i++) {

                    Log.e("dataBean","traceList.get(i).toString()="+traceList.get(i).toString());

                }
                adapter = new TraceListAdapter (getActivity(),traceList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },phone,phone,roomId,"1",UserLocalData.getUser(getActivity()).getTokenID(),"","","","","","");
    }
}
