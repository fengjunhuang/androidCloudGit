package com.cloudtenant.yunmenkeji.cloudtenant.http;



import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BuildingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamilyData;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.NoticeHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil1;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ListBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.LoginBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zt on 2017/3/10.
 */

public class HttpMethods {

    private static final String BASE_URL1 = "http://5ae10bf1ee98370014cf2455.mockapi.io/";
    private static final String BASE_URL = "http://123.207.91.208:80/";
    private static final int TIME_OUT=4;
    private Retrofit retrofit;
    private ApiService apiService;

    private HttpMethods() {
        /**
         * 构造函数私有化
         * 并在构造函数中进行retrofit的初始化
         */

        /**
         * 由于retrofit底层的实现是通过okhttp实现的，所以可以通过okHttp来设置一些连接参数
         * 如超时等
         */
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        apiService=retrofit.create(ApiService.class);

    }


    private static class sinalInstance {
        public static final HttpMethods instance = new HttpMethods();
    }

    public  static HttpMethods getInstance(){
        return sinalInstance.instance;
    }

    public void login(BaseObserver<UserInfo> observer, String type, String userPhone){
        apiService.login(type,userPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void login(BaseObserver<UserInfo> observer, String type, String userPhone,String pwd){
        apiService.login(type,userPhone,pwd).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void loginWithAuthorization(BaseObserver<UserInfo> observer, String aa){
        apiService.loginWithAuthorization().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void homeData(BaseObserver<HouseDetil> observer, String page, String row, String longitdue, String latitude){
        apiService.homeData(page,row,longitdue,latitude).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }public void updateMessage(BaseObserver<BrokenUp> observer, String name, String sex, String birthday, String constellation,String job,String userPhone,String favourite){
        apiService.updateMessage(name,sex,birthday,constellation,job,userPhone,favourite).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void upImages(BaseObserver<BrokenUp> observer, String userPhone,String base64Pic){
        apiService.upImages(userPhone,base64Pic).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void roomInfo(BaseObserver<RoomInfo> observer, String aa){
        apiService.roomInfo().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void messageSave(BaseObserver<MessageSave> observer, String aa){
        apiService.messageSave().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    public void roomMessageHistory(BaseObserver<RoomMessageHistory> observer, String aa){
        apiService.roomMessageHistory().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    public void brokenUpDone(BaseObserver<BaseBean> observer, String aa){
        apiService.brokenUpDone().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }
    public void myContract(BaseObserver<MyContract> observer, String aa){
        apiService.myContract().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void myFamilyList(BaseObserver<MyFamily> observer, String aa){
        apiService.myFamilyList().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void brokenUpCancel(BaseObserver<BrokenUp> observer, String aa){
        apiService.brokenUpCancel().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void brokenUp(BaseObserver<BrokenUp> observer, String aa){
        apiService.brokenUp().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void noticeHistory(BaseObserver<NoticeHistory> observer, String aa){
        apiService.noticeHistory().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void buildingInfo(BaseObserver<BuildingInfo> observer, String aa){
        apiService.buildingInfo().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void familyMemberList(BaseObserver<MyFamilyData> observer, String aa){
        apiService.familyMemberList().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void joinFamily(BaseObserver<BrokenUp> observer, String aa){
        apiService.joinFamily().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void otherMessage(BaseObserver<MessageOther> observer, String aa){
        apiService.otherMessage().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
   public void myRoom(BaseObserver<MyRoom> observer, String aa){
        apiService.MyRoom().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }

    public void BudingInfo(BaseObserver<BudingInfo> observer, String aa){
        apiService.BudingInfo().subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);


    }
    }



//   public  void getAllBuoyHead(BaseObserver<BuoyListBean> observer){
//        apiService.getAllBuoyHead().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//    }
//
//    public void uploadIcon(Observer<ImageBean> observer, File file, String userId){
//
//        RequestBody requestFile =
//                RequestBody.create(MediaType.parse("multipart/form-data"), file);
//        MultipartBody.Part body =
//                MultipartBody.Part.createFormData("file",file.getName(), requestFile);
//        // 添加描述
//
//        RequestBody description =
//                RequestBody.create(
//                        MediaType.parse("multipart/form-data"), userId);
//        apiService.upload(description,body).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//    }
//    public void login(BaseObserver<UserBean> observer, UserBean.DataBean userBean){
//        apiService.login(userBean).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//    }
//    public void updateUserInfo(BaseObserver<UserBean.DataBean> observer, UserBean.DataBean userBean){
//        apiService.updateUserInfo(userBean).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//    }
//    public void getUserInfo(BaseObserver<UserBean.DataBean> observer, String  userId){
//        apiService.getUserInfo(userId).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//
//
//    }
//    public void searchBuoySimpleByType(BaseObserver<BuoyListBean> observer, String  userType){
//        apiService.searchBuoySimpleByType(userType).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//
//
//    }
//    public void   getBuoyHistorysById(BaseObserver<BuoyHistoryList> observer, HistoryParmerBean historyParmerBean){
//        apiService.getBuoyHistorysById(historyParmerBean).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
//    }
   /* public void getJoke(Observer<List<MyJoke>> observer){

        apiService.getData()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }*/


