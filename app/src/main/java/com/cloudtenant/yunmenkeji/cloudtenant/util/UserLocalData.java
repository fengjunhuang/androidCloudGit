package com.cloudtenant.yunmenkeji.cloudtenant.util;

import android.content.Context;
import android.text.TextUtils;

import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserinfoBean;


public class UserLocalData {

    public static final String USER_JSON="user_json";
    public static void putUser(Context context, UserinfoBean user){


        String user_json =  JSONUtil.toJSON(user);
        PreferencesUtils.putString(context,USER_JSON,user_json);

    }

    public static void putToken(Context context, String token){

        //PreferencesUtils.putString(context, Contants.TOKEN,token);
    }


    public static UserinfoBean getUser(Context context){

        String user_json= PreferencesUtils.getString(context,USER_JSON);
        if(!TextUtils.isEmpty(user_json)){

            return  JSONUtil.fromJson(user_json,UserinfoBean.class);
        }
        return  null;
    }

    /*public static String getToken(Context context){

        return  PreferencesUtils.getString( context,Contants.TOKEN);

    }*/


    public static void clearUser(Context context){


        PreferencesUtils.putString(context, USER_JSON,"");

    }

    public static void clearToken(Context context){

       // PreferencesUtils.putString(context, Contants.TOKEN,"");
    }



}
