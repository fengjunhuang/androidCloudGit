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
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomModel;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.UserInfo;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil1;
import com.cloudtenant.yunmenkeji.cloudtenant.model.ListBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.LoginBean;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zt on 2017/3/10.
 */

public interface ApiService {
    /**
     *获取所有浮标
     * @return <List<BuoyListBean>>
     */
// @GET("buoy/getAllSimpleData")
// Observable<BuoyListBean> getAllBuoyHead();
//
//    @GET("buoy/searchBuoySimpleByType")
//    Observable<BuoyListBean> searchBuoySimpleByType(@Query("type") String type);
//
//    @POST("user/login")
//    Observable<UserBean>  login(@Body UserBean.DataBean userBean);
//    @POST("user/updateUserInfo")
//    Observable<UserBean>  updateUserInfo(@Body UserBean.DataBean userBean);
// @Multipart
//    @POST("user/uploadIcon")
//    Observable<ImageBean> upload(@Part("userId") RequestBody description,
//                                 @Part MultipartBody.Part file);
//    @GET("user/getUserInfo")
//    Observable<UserBean> getUserInfo(@Query("userId") String userId);
//
//    @POST ("buoy/getBuoyHistorysById")
//    Observable<BuoyHistoryList> getBuoyHistorysById(@Body HistoryParmerBean userBean);
       @POST("chl/tenant/account/addAccountInfo?")
       Observable<UserInfo> login(@Query("type") String type, @Query("userPhone") String userPhone);
       @POST("LoginWithAuthorization")
       Observable<UserInfo> loginWithAuthorization();

       @POST("/chl/buildings/getBuilding")
       Observable<HouseDetil> homeData(@Query("page") String page, @Query("row") String rows, @Query("longitdue") String longitdue, @Query("latitude") String latitude);
       @POST("/chl/tenant/account/updateMessage")
       Observable<HouseDetil> updateMessage(@Query("page") String page, @Query("row") String rows, @Query("longitdue") String longitdue, @Query("latitude") String latitude);
       @POST("MessageSave")
       Observable<MessageSave> messageSave();
       @POST("OtherMessage")
       Observable<MessageOther> otherMessage();
       @POST("RoomMessageHistory")
       Observable<RoomMessageHistory> roomMessageHistory();
       @POST("BrokenUpDone")
       Observable<BaseBean> brokenUpDone();
       @POST("MyContract")
       Observable<MyContract> myContract();
       @POST("MyFamilyList")
       Observable<MyFamily> myFamilyList();
       @POST("FamilyMemberList")
       Observable<MyFamilyData> familyMemberList();
       @POST("NoticeHistory")
       Observable<NoticeHistory> noticeHistory();
       @POST("BrokenUpCancel")
       Observable<BrokenUp> brokenUpCancel();
       @POST("BrokenUp")
       Observable<BrokenUp> brokenUp();
       @POST("BuildingInfo")
       Observable<BuildingInfo> buildingInfo();
       @POST("JoinFamily")
       Observable<BrokenUp> joinFamily();
       @POST("RoomInfo")
       Observable<RoomInfo> roomInfo();
   @POST("/chl/room/findRoomMessageByPhone")
   Observable<RoomModel> findRoomMessageByPhone(@Query("phone") String phone);


       @POST("MyRoom")
       Observable<MyRoom> MyRoom();

   @POST("BuildingInfo")
   Observable<BudingInfo> BudingInfo();

}
