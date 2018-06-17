package com.cloudtenant.yunmenkeji.cloudtenant.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.lzy.imagepicker.loader.ImageLoader;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by feng on 2017/12/26.
 */

public class BannerPicassoImageLoader extends com.youth.banner.loader.ImageLoader {


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {


        Picasso.with(context).load((String) path).into(imageView);

        //用fresco加载图片简单用法，记得要写下面的createImageView方法
        Uri uri = Uri.parse((String) path);
        imageView.setImageURI(uri);

    }
}
