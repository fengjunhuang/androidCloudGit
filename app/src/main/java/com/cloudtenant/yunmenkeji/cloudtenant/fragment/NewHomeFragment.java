package com.cloudtenant.yunmenkeji.cloudtenant.fragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseViewHolder;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.CityPickerActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.activity.HouseDetilActivity;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.HouseAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.http.HttpMethods;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AppUtils;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BannerPicassoImageLoader;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.SpacesItemDecoration;
import com.daimajia.slider.library.SliderLayout;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.squareup.picasso.Picasso;
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



public class NewHomeFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener,SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {


    private static final int REQUEST_CODE_SCAN=77;
    private TextView tv_title,tv_location;
    public static final int GETCITY=9527;
    public Context mContext;
    private     List<String> images=new ArrayList<>();
    private     List<HouseDetil.BannerDataBean> bannerDataBeans=new ArrayList<>();
    private Banner banner;
    private HouseAdapter adapter;
    private List<HouseDetil.ViewDataBean> viewDataBean;
    private EasyRecyclerView recyclerView;
    private RecyclerArrayAdapter.ItemView headerView;
    int page=1;
    boolean isFirst;
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
            case R.id.btn_op2:{
                startActivityForResult(new Intent(getActivity(),CityPickerActivity.class),GETCITY);
            }


            break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("onActivityResult","requestCode="+requestCode+">>>>resultCode="+resultCode);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case GETCITY:
                    String city=data.getExtras().getString("city");
                    if(city!= null) {
                        System.out.println("ccccccctttttt" + city);
                        tv_location.setText(city);
                    }
                    break;
            }
        }
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(Constant.CODED_CONTENT);
                Toast.makeText(getContext(), "扫描结果为：" + content, Toast.LENGTH_LONG).show();
            }
        }
    }
    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      return  null;
    }

    @Override
    protected View initContentView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle bundle) {
        View view=inflater.inflate(R.layout.fragment_house,container,false);
        mContext=getActivity();
        tv_location =view. findViewById(R.id.tv_location);
        view.findViewById(R.id.btn_op1).setOnClickListener(this);
        tv_title=view.findViewById(R.id.title);
        tv_title .setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        recyclerView=view.findViewById(R.id.recycler_view);
        recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.e("getData","onScrollStateChanged》》newState="+newState);

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                Log.e("getData","onScrolled》》dy="+dy);
            }
        });
        headerView=new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                View view=inflater.inflate(R.layout.house_header,parent,false);
                banner = view. findViewById(R.id.banner);
                final TextView tv_common=view.findViewById(R.id.tv_common);
                final TextView tv_map=view.findViewById(R.id.tv_map);
                tv_common.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_common.setBackgroundResource(R.drawable.butten_background_green_solid);
                        tv_common.setTextColor(getResources().getColor(R.color.white));
                        tv_map.setBackgroundResource(R.drawable.butten_background_green);
                        tv_map.setTextColor(getResources().getColor(R.color.gren_cut_clorr));

                    }
                });
                tv_map.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        tv_map.setBackgroundResource(R.drawable.butten_background_green_solid_r);
                        tv_map.setTextColor(getResources().getColor(R.color.white));
                        tv_common.setBackgroundResource(R.drawable.butten_background_green_l);
                        tv_common.setTextColor(getResources().getColor(R.color.gren_cut_clorr));
                    }
                });
                return view;
            }
            @Override
            public void onBindView(View headerView) {
                //headerView.setVisibility(View.VISIBLE);

            }
        };
        //view.findViewById(R.id.btn_op2).setOnClickListener(this);
        adapter = new HouseAdapter(getActivity());
        Log.e("getData","进入initContentView");
        return view;
    }

    @Override
    protected void initView(View view) {
        Log.e("getData","进入initView");
        getData();
    }

    @Override
    public void init() {
        Log.e("getData","进入init");



    }
    public void getData() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        adapter.addHeader(headerView);
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore, new RecyclerArrayAdapter.OnNoMoreListener() {
            @Override
            public void onNoMoreShow() {
                adapter.resumeMore();
            }

            @Override
            public void onNoMoreClick() {
                recyclerView.scrollToPosition(0);
            }
        });
        adapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {
            @Override
            public void onErrorShow() {
                adapter.resumeMore();
            }

            @Override
            public void onErrorClick() {
                adapter.resumeMore();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        LoadMore();
                    }
                }, 3000);
            }
        });
        recyclerView.setRefreshListener(this);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle =new Bundle();
                bundle.putSerializable("bean",viewDataBean.get(position));
                readyGo(HouseDetilActivity.class,bundle);
            }
        });
        isFirst=true;
       requestData();
    }

    private void requestData() {

        HttpMethods.getInstance().homeData(new BaseObserver<HouseDetil>() {
            @Override
            protected void onSuccees(BaseBean t) throws Exception {
                HouseDetil houseDetil= (HouseDetil) t;
                if (isFirst) {
                    adapter.clear();
                    bannerDataBeans=houseDetil.getBannerData();
                    for (int i = 0; i < bannerDataBeans.size(); i++) {
                        images.add(bannerDataBeans.get(i).getBannerImage());
                    }
                    banner.setImages(images).setImageLoader(new BannerPicassoImageLoader()).start();
                }
                if (page==1) {
                    adapter.clear();
                }
                System.out.println(houseDetil.getViewDataX().size()+"");
                Log.e("getData",houseDetil.getViewDataX().get(0).toString());
                Log.e("getData",houseDetil.getViewDataX().size()+"条信息");

                viewDataBean=houseDetil.getViewDataX();
                adapter.addAll(viewDataBean);

            }
            @Override
            protected void onFailure(Throwable e, boolean isNetWorkError) throws Exception {

            }
        },"");
    }

    private void LoadMore() {
        page++;
        requestData();
    }
    private Handler handler = new Handler();
    @Override
    public void onLoadMore() {
        //Toast.makeText(mContext, "onLoadMore", Toast.LENGTH_SHORT).show();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                LoadMore();
            }
        }, 2000);
    }

    @Override
    public void onRefresh() {
        page = 1;
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新
                if (!AppUtils.isNetworkAvailable(mContext)) {
                    adapter.pauseMore();
                    return;
                }
                requestData();
                //page=1;
            }
        }, 2000);
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
