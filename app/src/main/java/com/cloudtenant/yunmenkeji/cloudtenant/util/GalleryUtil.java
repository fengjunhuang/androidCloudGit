package com.cloudtenant.yunmenkeji.cloudtenant.util;

import android.app.Activity;
import android.content.Intent;

import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;

/**
 * Created by PC on 2016/12/14.
 */
public class GalleryUtil {
 public static  int   IMAGE_PICKER =124;
//    public static void openGallery(int REQUEST_CODE_GALLERY , GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback){
//        ThemeConfig theme = new ThemeConfig.Builder()
//                .build();
////配置功能
//        FunctionConfig functionConfig = new FunctionConfig.Builder()
//                .setEnableCamera(true)
//                .setEnableEdit(true)
//                .setEnableCrop(true)
//                .setEnableRotate(true)
//                .setCropSquare(true).setMutiSelectMaxSize(5)
//                .build();
//
////配置imageloader
//        GlideImagerLoader mImageloader = new GlideImagerLoader();
//        CoreConfig coreConfig = new CoreConfig.Builder(BaseApplication.getInstance(), mImageloader, theme)
//                .setFunctionConfig(functionConfig)
//                .build();
//        GalleryFinal.init(coreConfig);
//
////               GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
////带配置
//        GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, functionConfig, mOnHanlderResultCallback);
//
//    }
//
//    public static void openGalleryMulti(int REQUEST_CODE_GALLERY ,int imageNum ,GalleryFinal.OnHanlderResultCallback mOnHanlderResultCallback){
//        ThemeConfig theme = new ThemeConfig.Builder()
//                .build();
////配置功能
//        FunctionConfig functionConfig = new FunctionConfig.Builder()
//                .setEnableCamera(true)
//                .setEnableEdit(true)
//                .setEnableCrop(true)
//                .setEnableRotate(true)
//                .setCropSquare(true).setMutiSelectMaxSize(5)
//                .build();
//
////配置imageloader
//        GlideImagerLoader  mImageloader = new GlideImagerLoader();
//        CoreConfig coreConfig = new CoreConfig.Builder(BaseApplication.getInstance(), mImageloader, theme)
//                .setFunctionConfig(functionConfig)
//                .build();
//        GalleryFinal.init(coreConfig);
//
////               GalleryFinal.openGallerySingle(REQUEST_CODE_GALLERY, mOnHanlderResultCallback);
////带配置
//        GalleryFinal.openGalleryMuti(REQUEST_CODE_GALLERY,imageNum, mOnHanlderResultCallback);
//
//    }

    /**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 上传单张图片，不可以裁剪
     */
    public static void getSinglePicture(Activity activity){
        ImagePicker imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new PicassoImageLoader());   //设置图片加载器
        imagePicker.setShowCamera(true);  //显示拍照按钮
        imagePicker.setCrop(true);        //允许裁剪（单选才有效）
        imagePicker.setSaveRectangle(true); //是否按矩形区域保存
        imagePicker.setMultiMode(false);

        imagePicker.setStyle(CropImageView.Style.CIRCLE);  //裁剪框的形状
        imagePicker.setFocusWidth(800);   //裁剪框的宽度。单位像素（圆形自动取宽高最小值）
        imagePicker.setFocusHeight(800);  //裁剪框的高度。单位像素（圆形自动取宽高最小值）
        imagePicker.setOutPutX(1000);//保存文件的宽度。单位像素
        imagePicker.setOutPutY(1000);//保存文件的高度。单位像素
        Intent intent = new Intent(activity, ImageGridActivity.class);
       activity.startActivityForResult(intent, IMAGE_PICKER);

    }

/*    *//**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 上传单张图片，可以裁剪,圆形图片
     * 用于圈子头像的裁剪
     *//*
    public static void getSingleCropCirclePicture(FragmentActivity activity, ImagePicker.OnResultCallback callback){
        int width = ScreenUtils.getScreenWidth(activity)* 9 / 10 ;//显示框是屏幕宽度的4/5;
        ImagePicker.getInstance()
                .setImageLoader(new GlideImageLoader())//图片显示框架
                .setCrop(true)//是否裁剪
                .setFocusWidth(width)//显示框的宽度
                .setFocusHeight(width)//显示框的高度
                .setOutPutY(width)//裁剪后图片的高度
                .setOutPutX(width)//裁剪后图片的宽度
                .setStyle(CropImageView.Style.RECTANGLE)//矩形图片
                .setMultiMode(false)//是否多选
                .startIntent(activity)
                .setOnResultCallback(callback);
    }

    *//**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 上传单张图片，可以裁剪
     * 用于上传活动背景的裁剪
     * 以1080P为基准输出裁剪后的照片
     *//*
    public static void getSingleCropPicture(FragmentActivity activity, ImagePicker.OnResultCallback callback){
        int width = ScreenUtils.getScreenWidth(activity);
        int height = (int) (width/1.5f);
        int outY = (int) (1080/1.5f);
        ImagePicker.getInstance()
                .setImageLoader(new GlideImageLoader())//图片显示框架
                .setCrop(true)//是否裁剪
                .setFocusWidth(width)//显示框的宽度
                .setFocusHeight(height)//显示框的高度
                .setOutPutY(outY)//裁剪后图片的高度
                .setOutPutX(1080)//裁剪后图片的宽度
                .setMultiMode(false)//是否多选
                .setStyle(CropImageView.Style.RECTANGLE)
                .startIntent(activity)
                .setOnResultCallback(callback);
    }

    *//**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 上传多张图片，不可以裁剪
     *//*
    public static void getMultiPicture(FragmentActivity activity, int num, final ImagePicker.OnResultCallback callback){
        ImagePicker.getInstance()
                .setImageLoader(new GlideImageLoader())
                .setSelectLimit(num)//设置可选择的图片数量
                .setMultiMode(true)
                .setCrop(false)
                .startIntent(activity)
                .setOnResultCallback(callback);
//        ImageSelectorUtils.getInstance().getMultiImg(activity,num).setCallBack(new ImageSelectorUtils.OnSelectResultCallback() {
//            @Override
//            public void onResult(List<String> images) {
//
//            }
//        });
    }

    public static void getMultiPicture(FragmentActivity activity, int num){

    }

    *//**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 设置用户头像，可以裁剪
     *//*
    public static void getIconPicture(FragmentActivity activity, ImagePicker.OnResultCallback callback){
        int width = ScreenUtils.getScreenWidth(activity)* 9 / 10 ;//显示框是屏幕宽度的4/5;
        ImagePicker.getInstance()
                .setImageLoader(new GlideImageLoader())
                .setCrop(true)
                .setFocusWidth(width)//显示框的宽度
                .setFocusHeight(width)//显示框的高度
                .setOutPutY(500)//裁剪后图片的高度
                .setOutPutX(500)//裁剪后图片的宽度
                .setStyle(CropImageView.Style.CIRCLE)//圆形图片
                .setMultiMode(false)//是否多选
                .startIntent(activity)
                .setOnResultCallback(callback);
    }

    *//**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 直接从摄像头拍摄相片
     *//*
    public static void getPictureFromCamera(FragmentActivity activity, String path, ImagePicker.OnResultCallback callback){
//        ImagePicker.getInstance()
//                .setImageLoader(new GlideImageLoader())
//                .setCrop(false)
//                .setMultiMode(false)//是否多选
//                .setImagePath(path)
//                .startCameraIntent(activity)
//                .setOnResultCallback(callback);
    }

    *//**
     * ~~ 创建时间：2017/5/5 11:00 ~~
     * 直接从摄像头拍摄相片,并且裁剪
     *//*
    public static void getPictureCropFromCamera(FragmentActivity activity, String path, int outX, int outY, ImagePicker.OnResultCallback callback){
        int width = ScreenUtils.getScreenWidth(activity);//显示框是屏幕宽度的4/5;
        int height = (int) (width*(0.5f*outY/outX));
//        ImagePicker.getInstance()
//                .setImageLoader(new GlideImageLoader())
//                .setCrop(true)
//                .setMultiMode(false)//是否多选
//                .setFocusWidth(width)//显示框的宽度
//                .setFocusHeight(height)//显示框的高度
//                .setOutPutY(outY)//裁剪后图片的高度
//                .setOutPutX(outX)//裁剪后图片的宽度
//                .setImagePath(path)
//                .startCameraIntent(activity)
//                .setOnResultCallback(callback);
    }*/

}
