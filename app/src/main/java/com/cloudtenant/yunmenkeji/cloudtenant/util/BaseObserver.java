//package com.cloudtenant.yunmenkeji.cloudtenant.util;
//
//import android.accounts.NetworkErrorException;
//import android.content.Context;
//
//
//import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
//
//import java.net.ConnectException;
//import java.net.UnknownHostException;
//import java.util.concurrent.TimeoutException;
//
//import io.reactivex.Observer;
//import io.reactivex.disposables.Disposable;
//
///**
// * @author yemao
// * @date 2017/4/9
// * @description 写自己的代码, 让别人说去吧!
// */
//
//public abstract class BaseObserver<T> implements Observer<BaseBean> {
//    protected Context mContext;
//
//    public BaseObserver(Context cxt) {
//        this.mContext = cxt;
//    }
//
//    public BaseObserver() {
//
//    }
//
//    @Override
//    public void onSubscribe(Disposable d) {
//        onRequestStart();
//
//    }
//
//    @Override
////    public void onNext(BaseBean tBaseEntity) {
////        onRequestEnd();
////        if (tBaseEntity.isSuccess()) {
////            try {
////                onSuccees(tBaseEntity);
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        } else {
////            try {
////                onCodeError(tBaseEntity);
////
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        }
////    }
//
//    @Override
//    public void onError(Throwable e) {
////        Log.w(TAG, "onError: ", );这里可以打印错误信息
//        onRequestEnd();
//        try {
//            if (e instanceof ConnectException
//                    || e instanceof TimeoutException
//                    || e instanceof NetworkErrorException
//                    || e instanceof UnknownHostException) {
//                onFailure(e, true);
//            } else {
//                onFailure(e, false);
//            }
//        } catch (Exception e1) {
//            e1.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onComplete() {
//    }
//
//    /**
//     * 返回成功
//     *
//     * @param t
//     * @throws Exception
//     */
//    protected abstract void onSuccees(BaseBean t) throws Exception;
//
//    /**
//     * 返回成功了,但是code错误
//     *
//     * @param t
//     * @throws Exception
//     */
//    protected void onCodeError(BaseBean t) throws Exception {
//
//    }
//
//    /**
//     * 返回失败
//     *
//     * @param e
//     * @param isNetWorkError 是否是网络错误
//     * @throws Exception
//     */
//    protected abstract void onFailure(Throwable e, boolean isNetWorkError) throws Exception;
//
//    protected void onRequestStart() {
//    }
//
//    protected void onRequestEnd() {
//
//
///*        closeProgressDialog();*/
//    }
//
//   /* public void showProgressDialog() {
//        ProgressDialog.show(mContext, false, "请稍后");
//    }
//
//    public void closeProgressDialog() {
//        ProgressDialog.cancle();
//    }*/
//
//}