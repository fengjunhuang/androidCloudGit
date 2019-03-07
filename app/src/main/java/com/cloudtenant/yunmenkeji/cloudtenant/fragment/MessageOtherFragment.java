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
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
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

    private EasyRecyclerView recyclerView;
    private MessageOtherAdapter adapter;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    private String phone;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_message_other,container,false);
        phone= UserLocalData.getUser(getActivity()).getUserPhone();
        recyclerView= (EasyRecyclerView)view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new MessageOtherAdapter(getActivity());
        recyclerView.setAdapter(adapter);
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
    List<MessageOther.LandlordNewListBean> viewDataBeanList;
    public void getData() {
        //TODO
        HttpMethods.getInstance().getOrderMessageAndPaMessage(new BaseObserver<MessageOther>() {
            @Override
            protected void onSuccees(BaseBean t)  {
                MessageOther houseDetil= (MessageOther) t;
                System.out.println(houseDetil.getLandlordNewList()+"");
                viewDataBeanList=houseDetil.getLandlordNewList();
                adapter.addAll(viewDataBeanList);

            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError)  {

            }
        },phone,phone,"5",UserLocalData.getUser(getActivity()).getTokenID(),"","","","","","");
    }

}
