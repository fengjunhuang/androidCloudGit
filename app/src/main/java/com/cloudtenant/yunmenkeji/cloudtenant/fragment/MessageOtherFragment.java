package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.PayActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MessageOtherAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.OtherMessageAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.OtherMessageAdapter1;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.OtherMessage;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.view.NoScrollRecyclerView;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.util.List;

/**
 * Created by tlol20 on 2017/6/14
 */
public class MessageOtherFragment extends Fragment implements View.OnClickListener{

    private NoScrollRecyclerView recyclerView,recyclerView1;
    private OtherMessageAdapter adapter;
    private OtherMessageAdapter1 adapter1;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    private String phone;
    public boolean isHide=false,isHide1=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_other,container,false);
        phone= UserLocalData.getUser(getActivity()).getUserPhone();
        recyclerView= view.findViewById(R.id.recycler_view);
        recyclerView1= view.findViewById(R.id.recycler_view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView1.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        recyclerView1.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new OtherMessageAdapter(getActivity());
        adapter1 = new OtherMessageAdapter1(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView1.setAdapter(adapter1);
        getData();
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
        });adapter1.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
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
        });
        view.findViewById(R.id.ll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isHide) {
                    adapter.addAll(viewDataBeanList);
                    isHide=!isHide;
                }else {
                    adapter.removeAll();
                    isHide=!isHide;
                }
            }
        });
        return view;
    }
    //一般的Dialog
    public void normalDialog1(final String widoutTradeMoney, final String widoutTradeNo, final String roomId){

        AlertDialog.Builder bulider =new AlertDialog.Builder(getActivity());
        bulider.setTitle("提示");
        bulider.setMessage("支付相关款项");
        bulider.setPositiveButton("去支付", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                Intent intent=new Intent(getActivity(),PayActivity.class);
                intent.putExtra("widoutTradeMoney",widoutTradeMoney);
                intent.putExtra("widoutTradeNo",widoutTradeNo);
                intent.putExtra("roomId",roomId);
                startActivity(intent);
                dialog.dismiss();
            }
        });
        bulider.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });
        bulider.create().show();
    }
    //一般的Dialog
    public void normalDialog(){

        AlertDialog.Builder bulider =new AlertDialog.Builder(getActivity());
        bulider.setTitle("提示");
        bulider.setMessage("该订单已经支付完成");
        bulider.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {

                dialog.dismiss();
            }
        });
        /*bulider.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int arg1) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });*/
        bulider.create().show();
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pickPhotoBtn:{
                Toast.makeText(getActivity(), "申请退房！", Toast.LENGTH_SHORT).show();
            }break;


        }
    }
    List<OtherMessage.NoOverLandLordNewBean> viewDataBeanList;
    List<OtherMessage.IsOverLandLordNewBean> viewDataBeanList1;
    public void getData() {
        //TODO
        HttpMethods.getInstance().getOrderMessageAndPaMessageFd(new BaseObserver<OtherMessage>() {
            @Override
            protected void onSuccees(BaseBean t)  {
                OtherMessage houseDetil= (OtherMessage) t;
                System.out.println(houseDetil.getIsOverLandLordNew()+"");
                viewDataBeanList=houseDetil.getNoOverLandLordNew();
                viewDataBeanList1=houseDetil.getIsOverLandLordNew();
                adapter.addAll(viewDataBeanList);
                adapter1.addAll(viewDataBeanList1);

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError)  {

            }
        },phone,phone,"0",UserLocalData.getUser(getActivity()).getTokenID(),"","","","","","");
    }

}
