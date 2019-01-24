package com.cloudtenant.yunmenkeji.cloudtenant.http;



import com.cloudtenant.yunmenkeji.cloudtenant.bean.BrokenUp;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BudingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BuildingInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageOther;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MessageSave;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyCollection;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyContract;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamily;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.MyFamilyData;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.NoticeHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo1;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo3;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomMessageHistory;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BillHistoryModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil1;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ListBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.LoginBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MessageNoticeModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.cloudtenant.yunmenkeji.cloudtenant.util.BaseObserver;
import com.cloudtenant.yunmenkeji.cloudtenant.util.NewBaseObserver;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by zt on 2017/3/10.
 */

public class HttpMethods {

    private static final String BASE_URL1 = "http://192.168.50.13:8080/";
    public static final String BASE_URL = "http://123.207.91.208:80/";
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
    public void login(BaseObserver<UserInfo> observer, String type, String userPhone,String pwd,boolean isLogin,String registrationID){
        apiService.login(type,userPhone,pwd,isLogin,registrationID).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
//    public void loginWithAuthorization(BaseObserver<UserInfo> observer, String aa){
//        apiService.loginWithAuthorization().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }


    public void homeData(BaseObserver<HouseDetil> observer, String page, String row, String longitdue, String latitude,String areNames,String omit,String city,String town,String minPrice,String maxPrice,String houseConfigNote,String depositType,String score){
        apiService.homeData(page,row,longitdue,latitude,areNames,omit,city,town,minPrice,maxPrice,houseConfigNote,depositType,score).subscribeOn(Schedulers.io())
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
    public void feedbackProblem(BaseObserver<BrokenUp> observer, String userPhone,String content){
        apiService.feedbackProblem(userPhone,content).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void upStatus(BaseObserver<BrokenUp> observer, String phone,String status,String type){
        apiService.upStatus(phone,status,type).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void updatePassword(BaseObserver<BrokenUp> observer, String userPhone,String newPassword){
        apiService.updatePassword(userPhone,newPassword).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void findRoomMessageByPhone(BaseObserver<RoomModel> observer, String phone,String landingPhone){
        apiService.findRoomMessageByPhone(phone,landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void roomInfo(BaseObserver<RoomInfo> observer, String roomId){
        apiService.roomInfo(roomId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);

    }public void roomInfo1(BaseObserver<RoomInfo3> observer, String roomId, String phone){
        apiService.roomInfo1(roomId,phone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //    public void messageSave(BaseObserver<MessageSave> observer, String aa){
//        apiService.messageSave().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//    public void roomMessageHistory(BaseObserver<RoomMessageHistory> observer, String aa){
//        apiService.roomMessageHistory().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//    }
//    public void brokenUpDone(BaseObserver<BaseBean> observer, String aa){
//        apiService.brokenUpDone(aa).subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//
//    }
    public void myContract(BaseObserver<MyContract> observer, String phone){
        apiService.myContract(phone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void myFamilyList(BaseObserver<MyFamily> observer, String phone,String landingPhone){
        apiService.myFamilyList(phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    //    public void brokenUpCancel(BaseObserver<BrokenUp> observer, String aa){
//        apiService.brokenUpCancel().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//    public void brokenUp(BaseObserver<BrokenUp> observer, String aa){
//        apiService.brokenUp().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//    public void noticeHistory(BaseObserver<NoticeHistory> observer, String aa){
//        apiService.noticeHistory().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//    public void buildingInfo(BaseObserver<BuildingInfo> observer, String aa){
//        apiService.buildingInfo().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
    public void familyMemberList(BaseObserver<MyFamilyData> observer, String phone, String roomId, String landingPhone){
        apiService.familyMemberList(phone, landingPhone, roomId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    public void joinFamily(BaseObserver<BrokenUp> observer, String roomId,String phone,String idCard,String name,String landingPhone){
        apiService.joinFamily(roomId, phone, idCard, name, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
//    public void otherMessage(BaseObserver<MessageOther> observer, String aa){
//        apiService.otherMessage().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }
//   public void myRoom(BaseObserver<MyRoom> observer, String aa){
//        apiService.MyRoom().subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(observer);
//    }

    public void BudingInfo(BaseObserver<BudingInfo> observer, String orderId,String page,String row,String phone){
        apiService.BudingInfo(orderId,page,row,phone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //JAX Create
    public void checkAuthorization(BaseObserver<UserInfo> observer, String type,String uid){
        apiService.checkAuthorization(type, uid).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getSMSLogin(BaseObserver<BrokenUp> observer, String phone){
        apiService.getSMSLogin(phone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void signContractAction(BaseObserver<BrokenUp> observer, String buildingID,String roomId,String userPhone,String other,String IDNum,String name,String landLoardPhone,String roomNum,String contractTime){
        apiService.signContractAction(buildingID, roomId, userPhone, other, IDNum, name, landLoardPhone, roomNum, contractTime).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void updateReviewTimes(BaseObserver<BrokenUp> observer, String roomId,String ip,String landingPhone,String phone,String isLogin){
        apiService.updateReviewTimes(roomId, ip, landingPhone, phone, isLogin).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void addCollectionAction(BaseObserver<BrokenUp> observer, String roomId,String phone,String landingPhone){
        apiService.addCollectionAction(roomId, phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void deleteCollectionAction(BaseObserver<BrokenUp> observer, String roomId,String phone,String landingPhone){
        apiService.deleteCollectionAction(roomId, phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getContractUrl(BaseObserver<BrokenUp> observer, String str){
        apiService.getContractUrl(str).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getCollectionList(BaseObserver<MyCollection> observer, String phone, String landingPhone){
        apiService.getCollectionList(phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getReviewList(BaseObserver<BrokenUp> observer, String phone,String landingPhone){
        apiService.getReviewList(phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void deleteFamilyMember(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String signId){
        apiService.deleteFamilyMember(phone, landingPhone, signId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void broenUpContractAction(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String signId,String checkOutDate,String type){
        apiService.broenUpContractAction(phone, landingPhone, signId, checkOutDate, type).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void payTheCash(BaseObserver<BrokenUp> observer, String roomId,String roomRentId,String widoutTradeNo,String landingPhone){
        apiService.payTheCash(roomId, roomRentId, widoutTradeNo, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getMarginPayStatus(BaseObserver<BrokenUp> observer, String authId,String widoutTradeNo,String landingPhone,String roomId,String signId){
        apiService.getMarginPayStatus(authId, widoutTradeNo, landingPhone, roomId, signId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getNroamlPayStatus(BaseObserver<BrokenUp> observer, String authId,String widoutTradeNo,String landingPhone,String roomId,String signId){
        apiService.getNroamlPayStatus(authId, widoutTradeNo, landingPhone, roomId, signId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void checkOrderHadPay(BaseObserver<BrokenUp> observer, String roomId,String phone,String landingPhone){
        apiService.checkOrderHadPay(roomId, phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getBillHistory(BaseObserver<BrokenUp> observer, String phone,String landingPhone){
        apiService.getBillHistory(phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getNoCompleteBill(BaseObserver<BillHistoryModel> observer, String phone, String landingPhone, String roomId){
        apiService.getNoCompleteBill(phone, landingPhone, roomId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getSensorCycleList(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String sensorId){
        apiService.getSensorCycleList(phone, landingPhone, sensorId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void setSensorWorkCycle(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String startTime,String endTime,String cycleDate,String modeName,String sensorId,String type,String ids){
        apiService.setSensorWorkCycle(phone, landingPhone, startTime, endTime, cycleDate, modeName, sensorId, type, ids).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void setSensorCycleWorkMode(BaseObserver<BrokenUp> observer, String phone,String timeStatus,String ids,String landingPhone){
        apiService.setSensorCycleWorkMode(phone, timeStatus, ids, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getRoomSensorList(BaseObserver<SensorModel> observer, String landingPhone, String roomId){
        apiService.getRoomSensorList(landingPhone, roomId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void setSensorWorkMode(BaseObserver<BrokenUp> observer, String phone,String sensorId,String sensorStatus,String landingPhone){
        apiService.setSensorWorkMode(phone, sensorId, sensorStatus, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getBuildingNotice(BaseObserver<MessageNoticeModel> observer, String phone, String landingPhone){
        apiService.getBuildingNotice(phone, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getOrderMessageAndPaMessage(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String type){
        apiService.getOrderMessageAndPaMessage(phone, landingPhone, type).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void brokenUpDone(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String signId){
        apiService.brokenUpDone(phone, landingPhone, signId).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getSensorMessageList(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String roomId,String type){
        apiService.getSensorMessageList(phone, landingPhone, roomId, type).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void deleteSensorData(BaseObserver<BrokenUp> observer, String phone,String landingPhone,String sensorId,String type){
        apiService.deleteSensorData(phone, landingPhone, sensorId, type).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void cancelAuthorization(BaseObserver<BrokenUp> observer, String userPhone,String unidType,String landingPhone){
        apiService.cancelAuthorization(userPhone, unidType, landingPhone).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getStatAD(BaseObserver<BrokenUp> observer, String isLogin){
        apiService.getStatAD(isLogin).subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
