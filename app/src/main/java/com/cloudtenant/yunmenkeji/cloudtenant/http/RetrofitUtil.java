package com.cloudtenant.yunmenkeji.cloudtenant.http;

import java.lang.reflect.Field;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class RetrofitUtil {
    public static OkHttpClient genericClient() {

        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        httpClient.interceptors().add(chain -> {
            Request request = chain.request();
            MediaType mediaType = request.body().contentType();
            try {
                Field field = mediaType.getClass().getDeclaredField("mediaType");
                field.setAccessible(true);
                field.set(mediaType, "application/json");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return chain.proceed(request);
        });
        return httpClient;
    }
}