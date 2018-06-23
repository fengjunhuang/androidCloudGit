package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.model.Indexdata;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BannerPicassoImageLoader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.SpacesItemDecoration;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.youth.banner.Banner;
import com.yzq.zxinglibrary.android.CaptureActivity;
import com.yzq.zxinglibrary.bean.ZxingConfig;
import com.yzq.zxinglibrary.common.Constant;
import com.yzs.yzsbaseactivitylib.entity.EventCenter;
import com.yzs.yzsbaseactivitylib.fragment.YzsBaseListFragment;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends YzsBaseListFragment<Indexdata> implements View.OnClickListener {




    private static final int REQUEST_CODE_SCAN=77;


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_op1: {
                AndPermission.with(this)
                        .permission(Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE)
                        .onGranted(new Action() {
                            @Override
                            public void onAction(Object data) {
                                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                                /*ZxingConfig是配置类
                                 *可以设置是否显示底部布局，闪光灯，相册，
                                 * 是否播放提示音  震动
                                 * 设置扫描框颜色等
                                 * 也可以不传这个参数
                                 * */
                                ZxingConfig config = new ZxingConfig();
                                config.setPlayBeep(true);//是否播放扫描声音 默认为true
                                config.setShake(true);//是否震动  默认为true
                                config.setDecodeBarCode(false);//是否扫描条形码 默认为true
                                config.setReactColor(R.color.red1);//设置扫描框四个角的颜色 默认为淡蓝色
                                //config.setFrameLineColor(R.color.white);//设置扫描框边框颜色 默认无色
                                config.setFullScreenScan(false);//是否全屏扫描  默认为true  设为false则只会在扫描框中扫描
                                config.setShowAlbum(false);
                                intent.putExtra(Constant.INTENT_ZXING_CONFIG, config);
                                startActivityForResult(intent, REQUEST_CODE_SCAN);
                            }
                        })
                        .onDenied(new Action() {
                            @Override
                            public void onAction(Object data) {
                                Uri packageURI = Uri.parse("package:" + getActivity().getPackageName());
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                                startActivity(intent);

                                Toast.makeText(getContext(), "没有权限无法扫描呦", Toast.LENGTH_LONG).show();
                            }
                        }).start();
                /*Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);*/
            }break;

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                Toast.makeText(getContext(), "扫描结果为：" + content, Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected View initContentView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
       View view=layoutInflater.inflate(R.layout.activity_recyclerview,viewGroup,false);
        List<String> images=new ArrayList<>();
        Banner banner = (Banner)view. findViewById(R.id.banner);
        view.findViewById(R.id.btn_op1).setOnClickListener(this);
        view.findViewById(R.id.btn_op2).setOnClickListener(this);
        images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529230178291&di=71e9d9b4ad4deb6d8f21e90cf4ced6ac&imgtype=0&src=http%3A%2F%2Fpic15.nipic.com%2F20110708%2F7843095_103004548386_2.jpg");
       images.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529230293646&di=b367f393dc03c3c8d22d0ee923eb2f2d&imgtype=0&src=http%3A%2F%2Fpic3.16pic.com%2F00%2F04%2F28%2F16pic_428522_b.jpg");

        banner.setImages(images).setImageLoader(new BannerPicassoImageLoader()).start();


        return view;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        int space = 8;
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(space));

    }

    @Override
    protected void initItemLayout() {
        setLayoutResId(R.layout.item_house_detil);
        setListType(LINEAR_LAYOUT_MANAGER, true);

    }

    @Override
    protected void MyHolder(BaseViewHolder baseViewHolder, Indexdata indexdata) {

    }



    @Override
    protected void initLogic() {
        mAdapter.addData(new Indexdata());
        mAdapter.addData(new Indexdata());
        mAdapter.addData(new Indexdata());
        mAdapter.addData(new Indexdata());
        mAdapter.addData(new Indexdata());
        mAdapter.addData(new Indexdata());
        mAdapter.addData(new Indexdata());
    }

    @Override
    protected void getBundleExtras(Bundle bundle) {

    }

    @Override
    protected void onEventComing(EventCenter eventCenter) {

    }
}
