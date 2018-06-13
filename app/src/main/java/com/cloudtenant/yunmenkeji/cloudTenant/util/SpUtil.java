package com.cloudtenant.yunmenkeji.cloudTenant.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by qwz on 2017/4/1.
 */
public final class SpUtil {

    private static final int MODE = Context.MODE_PRIVATE;

    private SpUtil(){

    }


    public static void setValue(Context context,String name,boolean value){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        Editor editor = sp.edit();
        editor.putBoolean(name, value);
        editor.commit();
    }
    public static void setModel(Context context,Object object,String name){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        Editor editor = sp.edit();

        editor.putString(name  ,GsonQuick.toJsonFromBean(object));

        editor.commit();
    }

    public static void setValue(Context context,String name,int value){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        Editor editor = sp.edit();
        editor.putInt(name, value);
        editor.commit();
    }

    public static void setValue(Context context,String name,long value){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        Editor editor = sp.edit();
        editor.putLong(name, value);
        editor.commit();
    }

    public static void setValue(Context context,String name,float value){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        Editor editor = sp.edit();
        editor.putFloat(name, value);
        editor.commit();
    }

    public static void setValue(Context context,String name,String value){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        Editor editor = sp.edit();
        editor.putString(name, value);
        editor.commit();
    }

    public static boolean getBooleanValue(Context context,String name){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(),MODE);
        return sp.getBoolean(name, false);
    }



    public static int getIntValue(Context context,String name){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        return sp.getInt(name,0);
    }

    public static long getLongValue(Context context,String name){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        return sp.getLong(name, 0);
    }

    public static float getFloatValue(Context context,String name){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        return sp.getFloat(name, 0);
    }

    public static String getStringValue(Context context,String name){
        SharedPreferences sp =  context.getSharedPreferences(context.getPackageName(), MODE);
        return sp.getString(name, "");
    }

}
