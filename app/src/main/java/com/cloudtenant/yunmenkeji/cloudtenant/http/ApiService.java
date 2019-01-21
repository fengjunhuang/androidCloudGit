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
import com.cloudtenant.yunmenkeji.cloudtenant.bean.RoomInfo3;
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
   /*@POST("chl/tenant/account/addAccountInfo?")
   Observable<UserInfo> login(@Body LoginBean loginBean );*/
   @POST("chl/tenant/account/addAccountInfo?")
   Observable<UserInfo> login(@Query("type") String type, @Query("userPhone") String userPhone, @Query("password") String pwd, @Query("isLogin") boolean isLogin, @Query("registrationID") String registrationID);


       @POST("LoginWithAuthorization")
       Observable<UserInfo> loginWithAuthorization();

       @POST("/chl/buildings/getBuilding")
       Observable<HouseDetil> homeData(@Query("page") String page, @Query("row") String rows, @Query("longitdue") String longitdue, @Query("latitude") String latitude);
     @POST("/chl/tenant/account/updateMessage")
       Observable<BrokenUp> updateMessage(
                @Query("userName") String userName,
                @Query("userSex") String userSex,
                @Query("userBirthday") String userBirthday,
                @Query("userConstellation") String userConstellation,
                @Query("userJob") String userJob,
                @Query("userPhone") String userPhone,
                @Query("userFavourite") String userFavourite);
     @POST("/chl/tenant/account/upImages")
       Observable<BrokenUp> upImages(
                @Query("userPhone") String userPhone,
                @Query("base64Pic") String base64Pic);
     @POST("/chl/propelling/feedbackProblem")
       Observable<BrokenUp> feedbackProblem(
                @Query("phone") String phone,
                @Query("content") String content);
     @POST("/chl/jdpush/upStatus")
       Observable<BrokenUp> upStatus(
                @Query("phone") String phone,
                @Query("status") String status,
                @Query("type") String type);
     @POST("/chl/tenant/account/updatePassword")
       Observable<BrokenUp> updatePassword(
                @Query("userPhone") String userPhone,
                @Query("newPassword") String newPassword);
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
       @POST("/chl/sign/contract/getContractPic")
       Observable<MyContract> myContract(@Query("phone") String phone);
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
       @POST("chl/room/getRoomById")
       Observable<RoomInfo> roomInfo(@Query("roomId") String roomId);
       @POST("chl/room/getRoomById")
       Observable<RoomInfo3> roomInfo1(@Query("roomId") String roomId, @Query("phone") String phone);
   @POST("/chl/room/findRoomMessageByPhone")
   Observable<RoomModel> findRoomMessageByPhone(@Query("phone") String phone);

       @POST("MyRoom")
       Observable<MyRoom> MyRoom();

   @POST("/chl/room/getRoomList")
   Observable<BudingInfo> BudingInfo(@Query("orderId") String orderId,@Query("page") String page,@Query("row") String row,@Query("phone") String phone);

}
