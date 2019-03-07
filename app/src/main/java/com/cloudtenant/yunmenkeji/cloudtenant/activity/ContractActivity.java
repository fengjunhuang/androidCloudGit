package com.cloudtenant.yunmenkeji.cloudtenant.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.ContractAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.ImageDownloader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.UserLocalData;
import com.cloudtenant.yunmenkeji.cloudtenant.view.CompleteImageView;
import com.cloudtenant.yunmenkeji.cloudtenant.view.CustomDialog;
import com.cloudtenant.yunmenkeji.cloudtenant.view.SelectPicPopupWindow;
import com.cloudtenant.yunmenkeji.cloudtenant.widget.CustomDatePicker;
import com.gersion.library.base.BaseActivity;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/**
 * Created by tlol20 on 2017/6/14
 */
public class ContractActivity extends BaseActivity implements View.OnClickListener{
    private CustomDatePicker customDatePicker1;
    private EasyRecyclerView recyclerView;
    private ContractAdapter adapter;
    private String contrractType;
    //private OkHttpHelper ok=OkHttpHelper.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_contract);
        findViewById(R.id.out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        findViewById(R.id.title).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        recyclerView= (EasyRecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerDecoration(Color.parseColor("#aaaaaa"), 1));
        adapter = new ContractAdapter(this);
        recyclerView.setAdapter(adapter);
        //getData();
        AddData();
        initDatePicker();
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showPopupWindow(viewDataBeanList.get(position).getContractType());
            }
        });
    }


    SelectPicPopupWindow mPopWindow;
    private void showPopupWindow(String contractType) {
        this.contrractType=contractType;
        //设置contentView
        mPopWindow = new SelectPicPopupWindow(this,this,contractType);
        mPopWindow.showAsDropDown(LayoutInflater.from(this).inflate(R.layout.activity_my_contract, null));

    }
    String now;
    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        now = sdf.format(new Date());

        Log.e("initDatePicker", "SimpleDateFormat=" + now);
        //dialog.setHintText(now.split(" ")[0]);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                dialog.setHintText(time.split(" ")[0]);
            }
        },  now, "2070-01-01 00:00","请选择日期"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.pickPhotoBtn:{
                if (contrractType.equals("1")) {
                    CancelBroken();
                }else {
                    Broken();
                }
            }break;
            case R.id.cancelBtn:{
                mPopWindow.dismiss();
            }break;
            case R.id.takePhotoBtn:{
                CompleteImageView completeImageView = new CompleteImageView(this, new FileDownLoader());
                for (int i = 0; i < 2; i++) {
                    urls.add("http://123.207.91.208:80/"+viewDataBeanList.get(i).getContractUrl());
                }
                completeImageView.setUrls(urls, 0);
                completeImageView.create();
                mPopWindow.dismiss();
            }break;

        }
    }
    CustomDialog dialog;
    private void Broken() {
        dialog= new CustomDialog(this);
        dialog.show();
        dialog.setDataClick("确定要删除吗？", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customDatePicker1.show(now);
            }
        });
        dialog.setLeftButton("确认", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                postContract();
            }
        });
        dialog.setRightButton("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

    private void postContract() {
        //TODO:jax注释
//        HttpMethods.getInstance().brokenUp(new BaseObserver<BrokenUp>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                BrokenUp houseDetil= (BrokenUp) t;
//                Log.e("onSuccees",houseDetil.getId()+">>>>>"+houseDetil.getMessage());
//                mPopWindow.dismiss();
//                Toast.makeText(ContractActivity.this, houseDetil.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//
//            }
//        },"");
    }

    private void CancelBroken() {
        //TODO:jax注释
//        HttpMethods.getInstance().brokenUpCancel(new BaseObserver<BrokenUp>() {
//            @Override
//            protected void onSuccees(BaseBean t) throws Exception {
//                BrokenUp houseDetil= (BrokenUp) t;
//                mPopWindow.dismiss();
//                Toast.makeText(ContractActivity.this, houseDetil.getMessage(), Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {
//
//            }
//        },"");
    }

    List<String> urls=new ArrayList<>();
    List<MyContract.ViewDataBean> viewDataBeanList;
    private void AddData() {
        String phone= Objects.requireNonNull(UserLocalData.getUser(this)).getUserPhone();
        Log.d("AddData","phone="+phone);
        HttpMethods.getInstance().myContract(new BaseObserver<MyContract>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                Log.d("AddData",t.getMessage());
                Log.d("AddData",t.getResult());
                MyContract houseDetil= (MyContract) t;
                viewDataBeanList=houseDetil.getViewData();
                System.out.println(houseDetil.getViewData()+"");

                Log.d("AddData",viewDataBeanList.get(0).getContractName());
                adapter.addAll(viewDataBeanList);
            }

            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        }, phone,phone,UserLocalData.getUser(this).getTokenID(),"","","","","","");
    }



    public class FileDownLoader implements ImageDownloader {
        @Override
        public File downLoad(String url, Activity activity) {
            File file = null;
            try {
                file = Glide.with(activity).load(url).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return file;
        }
    }


}
