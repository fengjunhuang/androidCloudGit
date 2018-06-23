package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.AboutActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.ContractActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MessageRoomActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.MyFamilyActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.RequestActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.SettingActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.Contract;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;


public class MeFragment extends BaseFragment implements View.OnClickListener {


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void init() {

    }





    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_clean: {
                Toast.makeText(_mActivity, "清理完成！", Toast.LENGTH_SHORT).show();
            }break;
            case R.id.rl_about:{
                startActivity(new Intent(getActivity(), AboutActivity.class));
            }break;
            case R.id.rl_request:{
                startActivity(new Intent(getActivity(), RequestActivity.class));
            }break;
            case R.id.rl_setting:{
                startActivity(new Intent(getActivity(), SettingActivity.class));
            }break;
            case R.id.rl_family:{
                startActivity(new Intent(getActivity(), MyFamilyActivity.class));
            }break;
            case R.id.rl_contract:{
                startActivity(new Intent(getActivity(), ContractActivity.class));
            }break;
            case R.id.rl_connect:{
                //用intent启动拨打电话
                /*Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:18925012200"));
                startActivity(intent);*/
                AndPermission.with(getActivity())
                        .permission(Permission.CALL_PHONE, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @SuppressLint("MissingPermission")
                            @Override
                            public void onAction(Object data) {
                                //用intent启动拨打电话
                                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:10086"));
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

                                Toast.makeText(getContext(), "没有权限打电话哦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
            }break;
        }
    }

    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View view=layoutInflater.inflate(R.layout.activity_me,viewGroup,false);
        view.findViewById(R.id.rl_about).setOnClickListener(this);
        view.findViewById(R.id.rl_clean).setOnClickListener(this);
        view.findViewById(R.id.rl_connect).setOnClickListener(this);
        view.findViewById(R.id.rl_contract).setOnClickListener(this);
        view.findViewById(R.id.rl_family).setOnClickListener(this);
        view.findViewById(R.id.rl_setting).setOnClickListener(this);
        view.findViewById(R.id.rl_request).setOnClickListener(this);
        view.findViewById(R.id.rl_icon).setOnClickListener(this);
        TextView userName=view.findViewById(R.id.userName);
        userName.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        final View me_topbar=view.findViewById(R.id.me_topbar);
        me_topbar.setAlpha(0);
        ScrollView mScrollView=view.findViewById(R.id.myscrollview);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                    Log.e("MeFrangment","i="+i+">>i1="+i1+">>i2="+i2+">>i3"+i3);
                    if (i1<150){
                        float alpha=i1/150;

                        Log.e("MeFrangment","alpha="+alpha);
                        if (i1<128){

                            if (me_topbar!=null){
                                me_topbar.setAlpha(0);
                            }
                        }else {
                            //me_topbar.getBackground().setAlpha(255);
                                me_topbar.setAlpha(1);
                        }
                    }
                }
            });
        }
        return view;
    }

    @Override
    protected void initView(View view) {

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
