package com.cloudtenant.yunmenkeji.cloudtenant.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.cloudtenant.yunmenkeji.cloudtenant.adapter.MyPagerAdapter;
import com.cloudtenant.yunmenkeji.cloudtenant.util.IOThread;
import com.cloudtenant.yunmenkeji.cloudtenant.util.ImageDownloader;
import com.cloudtenant.yunmenkeji.cloudtenant.R;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by qiaoyuang on 2017/4/26.
 * 主类
 */

public class CompleteImageView {

    private static final byte URLS = 0;
    private static final byte FILES = 1;
    private byte mStatus;

    private Activity mActivity;
    private ImageDownloader mImageDownloader;

    private List<String> mUrls;
    private List<File> mFiles;
    private List<File> mDownloadFiles;

    private int mSelectedPosition;

    private Dialog mDialog;

    private ImageView imDelete;
    private ImageView imDownload;
    private TextView tvImageCount;
    private ViewPager mViewPager;

    private List<View> mViews;
    private MyPagerAdapter mAdapter;

    private OnDeleteItemListener mListener;
    private int mStartPosition;

    public CompleteImageView(Activity activity, ImageDownloader imageDownloader) {
        mActivity = activity;
        mImageDownloader = imageDownloader;
        init();
    }

    public void setUrls(List<String> urls, int startPosition) {
        if (mUrls == null) {
            mUrls= new ArrayList<>();
        } else {
            mUrls.clear();
        }
        mUrls.addAll(urls);
        mStatus = URLS;
        imDelete.setVisibility(View.GONE);
        if (mDownloadFiles == null) {
            mDownloadFiles = new ArrayList<>();
        } else {
            mDownloadFiles.clear();
        }
        mStartPosition = startPosition++;
        String text = startPosition + "/" + urls.size();
        tvImageCount.setText(text);
    }

    public void setFiles(List<File> files, int startPosition) {
        if (mFiles == null) {
            mFiles = new LinkedList<>();
        } else {
            mFiles.clear();
        }
        mFiles.addAll(files);
        mStatus = FILES;
        imDownload.setVisibility(View.GONE);
        mStartPosition = startPosition++;
        String text = startPosition + "/" + files.size();
        tvImageCount.setText(text);
    }

    public void setOnDeleteItemListener(OnDeleteItemListener listener) {
        mListener = listener;
    }

    private void init() {
        RelativeLayout relativeLayout = (RelativeLayout) mActivity.getLayoutInflater().inflate(R.layout.dialog_scale_image, null);
        ImageView close = (ImageView) relativeLayout.findViewById(R.id.scale_image_close);
        imDelete = (ImageView) relativeLayout.findViewById(R.id.scale_image_delete);
        imDownload = (ImageView) relativeLayout.findViewById(R.id.scale_image_save);
        tvImageCount = (TextView) relativeLayout.findViewById(R.id.scale_image_count);
        mViewPager = (ViewPager) relativeLayout.findViewById(R.id.scale_image_view_pager);
        mDialog = new Dialog(mActivity, R.style.Dialog_Fullscreen);
        mDialog.setContentView(relativeLayout);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
        imDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int size = mViews.size();
                mFiles.remove(mSelectedPosition);
                if (mListener != null) {
                    mListener.onDelete(mSelectedPosition);
                }
                mViewPager.removeView(mViews.remove(mSelectedPosition));
                if (mSelectedPosition != size) {
                    int position = mSelectedPosition + 1;
                    String text = position + "/" + mViews.size();
                    tvImageCount.setText(text);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
        imDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*try {
                    MediaStore.Images.Media.insertImage(mActivity.getContentResolver(),
                            mDownloadFiles.get(mSelectedPosition).getAbsolutePath(),
                            mDownloadFiles.get(mSelectedPosition).getName(), null);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                Snackbar.make(mViewPager, "图片保存成功", Snackbar.LENGTH_SHORT).show();*/
                Toast.makeText(mActivity, "开始下载。。。", Toast.LENGTH_SHORT).show();

                File file = null;
                try {
                    file = Glide.with(mActivity).load(mUrls.get(mSelectedPosition)).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();
                    // 最后通知图库更新
                    mActivity.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                            Uri.fromFile(new File(file.getPath()))));
                    Toast.makeText(mActivity, file.getPath(), Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mSelectedPosition = position;
                String text = ++position + "/" + mViews.size();
                tvImageCount.setText(text);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void create() {
        mDialog.show();
        mViews = new ArrayList<>();
        mAdapter = new MyPagerAdapter(mViews, mDialog);
        if (mStatus == URLS) {
            for (final String url : mUrls) {
                FrameLayout frameLayout = (FrameLayout) mActivity.getLayoutInflater().inflate(R.layout.view_scale_image, null);
                final SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) frameLayout.findViewById(R.id.scale_image_view);
                mViews.add(frameLayout);
                IOThread.getSingleThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        final File downLoadFile;
                        try {
                            downLoadFile = mImageDownloader.downLoad(url, mActivity);
                            mDownloadFiles.add(downLoadFile);
                            mActivity.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImage(ImageSource.uri(Uri.fromFile(downLoadFile)));
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            mViewPager.setAdapter(mAdapter);
        } else if (mStatus == FILES) {
            for (File file : mFiles) {
                FrameLayout frameLayout = (FrameLayout) mActivity.getLayoutInflater().inflate(R.layout.view_scale_image, null);
                SubsamplingScaleImageView imageView = (SubsamplingScaleImageView) frameLayout.findViewById(R.id.scale_image_view);
                mViews.add(frameLayout);
                imageView.setImage(ImageSource.uri(Uri.fromFile(file)));
            }
            mViewPager.setAdapter(mAdapter);
        }
        mViewPager.setCurrentItem(mStartPosition);
    }

    public interface OnDeleteItemListener {
        void onDelete(int position);
    }

}