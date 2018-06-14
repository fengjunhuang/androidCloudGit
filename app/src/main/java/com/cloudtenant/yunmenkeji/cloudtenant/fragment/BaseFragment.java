package com.cloudtenant.yunmenkeji.cloudtenant.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yzs.yzsbaseactivitylib.fragment.YzsBaseFragment;


public abstract class BaseFragment extends YzsBaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       super.onCreateView(inflater,container,savedInstanceState);
        showLoadingDialog();
        return view;


    }

    public void  initToolBar(){

    }


    public abstract View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    public abstract void init();



    public void startActivity(Intent intent, boolean isNeedLogin){


        if(isNeedLogin){

            /*LoginRespMsg.UserVoLoginEntity user = ChaofenApplication.getInstance().getUser();
            if(user !=null){
                super.startActivity(intent);
            }
            else{

                *//*ChaofenApplication.getInstance().putIntent(intent);
                Intent loginIntent = new Intent(getActivity(), LoginActivity.class);
                super.startActivity(loginIntent);*//*

            }*/

        }
        else{
            super.startActivity(intent);
        }

    }


}
