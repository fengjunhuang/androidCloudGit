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
import com.cloudtenant.yunmenkeji.cloudtenant.model.BillHistoryModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.CollectionAndReViewModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.HouseDetil;
import com.cloudtenant.yunmenkeji.cloudtenant.model.MyRoom;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorCycleModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.SensorModel;
import com.cloudtenant.yunmenkeji.cloudtenant.model.StarAdModel;

import io.reactivex.Observable;
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
    //注册登录模块
    @POST("chl/tenant/account/addAccountInfo?")
    Observable<UserInfo> login(
            @Query("type") String type,
            @Query("userPhone") String userPhone
    );
    @POST("chl/tenant/account/addAccountInfo?")
    Observable<UserInfo> login(@Query("type") String type,
                               @Query("userPhone") String userPhone,
                               @Query("password") String pwd,
                               @Query("isLogin") boolean isLogin,
                               @Query("registrationID") String registrationID
    );
    //检测第三方是否有登录过
    @POST("chl/tenant/account/isRegister")
    Observable<UserInfo> checkAuthorization(
            @Query("type") String type,
            @Query("uid") String uid

    );

    //获取短信接口
    @POST("chl/tenant/account/sendLoginCode")
    Observable<BrokenUp> getSMSLogin(
            @Query("phone") String phone
    );
    //设置密码
    @POST("/chl/tenant/account/updatePassword")
    Observable<BrokenUp> updatePassword(
            @Query("userPhone") String userPhone,
            @Query("newPassword") String newPassword);

    //首页模块
    @POST("/chl/buildings/getBuilding")
    Observable<HouseDetil> homeData(@Query("page") String page,
                                    @Query("row") String rows,
                                    @Query("longitdue") String longitdue,
                                    @Query("latitude") String latitude
    );
    @POST("/chl/room/getRoomList")
    Observable<BudingInfo> BudingInfo(@Query("orderId") String orderId,
                                      @Query("page") String page,
                                      @Query("row") String row,
                                      @Query("phone") String phone
    );
    //上传合同,注意:这里须要用data形式上传,以保证图片质量
    @POST("chl/sign/contract/save")
    Observable<BrokenUp> signContractAction(
            @Query("buildingID") String buildingID,
            @Query("roomId") String roomId,
            @Query("userPhone") String userPhone,
            @Query("other") String other,//这里是多个其他人的model转成string形式的json字符串
            @Query("IDNum") String IDNum,
            @Query("name") String name,
            @Query("landLoardPhone") String landLoardPhone,
            @Query("roomNum") String roomNum,
            @Query("contractTime") String contractTime
    );

    //加入到家庭组
    @POST("/chl/sign/contract/addSignContract")
    Observable<BrokenUp> joinFamily(
            @Query("roomId") String roomId,
            @Query("phone") String phone,
            @Query("idCard") String idCard,
            @Query("name") String name,
            @Query("landingPhone") String landingPhone);

    @POST("chl/room/getRoomById")
    Observable<RoomInfo> roomInfo(
            @Query("roomId") String roomId
    );
    @POST("chl/room/getRoomById")
    Observable<RoomInfo> roomInfo1(
            @Query("roomId") String roomId,
            @Query("phone") String phone
    );
    //增加浏览次数
    @POST("chl/room/addRoomReadNum")
    Observable<BrokenUp> updateReviewTimes(
            @Query("roomId") String roomId,
            @Query("ip") String ip,
            @Query("landingPhone") String landingPhone,
            @Query("phone") String phone,
            @Query("isLogin") String isLogin);

    //收藏&删除收藏
    @POST("chl/user/experience/addCollection")
    Observable<BrokenUp> addCollectionAction(
            @Query("roomId") String roomId,
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone);
    @POST("chl/user/experience/deleteCollection")
    Observable<BrokenUp> deleteCollectionAction(
            @Query("roomId") String roomId,
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone);
    //获取合同地址
    @POST("chl/sign/contract/getSignContractHtml")
    Observable<BrokenUp> getContractUrl(
            @Query("str") String str //字符串拼接方式请查看文档
    );

    //我的模块
    //获取收藏列表
    @POST("chl/user/experience/getCollection")
    Observable<CollectionAndReViewModel> getCollectionList(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone
    );
    //获取浏览记录列表
    @POST("chl/user/experience/getBrowsingHistory")
    Observable<CollectionAndReViewModel> getReviewList(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone
    );
    @POST("/chl/tenant/account/updateMessage")
    Observable<BrokenUp> updateMessage(
            @Query("userName") String userName,
            @Query("userSex") String userSex,
            @Query("userBirthday") String userBirthday,
            @Query("userConstellation") String userConstellation,
            @Query("userJob") String userJob,
            @Query("userPhone") String userPhone,
            @Query("userFavourite") String userFavourite
            //以下待添加
//            @Query("userIcon") String userIcon,
//            @Query("wechatUID") String wechatUID,
//            @Query("weiboUID") String weiboUID,
//            @Query("qqUID") String qqUID,
//            @Query("alipayUID") String alipayUID,
//            @Query("userIsFirstLogin") String userIsFirstLogin,
//            @Query("userHadContract") String userHadContract
    );
    //    @POST("/chl/tenant/account/updateMessage")
//    Observable<HouseDetil> updateMessage(@Query("page") String page, @Query("row") String rows, @Query("longitdue") String longitdue, @Query("latitude") String latitude);
    @POST("/chl/tenant/account/upImages")
    Observable<BrokenUp> upImages(
            @Query("phone") String userPhone,
            @Query("base64Pic") String base64Pic
    );
    @POST("/chl/sign/contract/getContractPic")
    Observable<MyContract> myContract(
            @Query("phone") String phone
    );
    //获取家庭组列表
    @POST("chl/sign/contract/phoneAllRoom")
    Observable<MyFamily> myFamilyList(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone
    );
    //家庭组成员列表
    @POST("chl/sign/contract/findRoomSignPeople")
    Observable<MyFamilyData> familyMemberList(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone,
            @Query("roomId") String roomId
    );
    //删除成员
    @POST("chl/sign/contract/deleteSignContract")
    Observable<BrokenUp> deleteFamilyMember(
            @Query("phone") String phone,
            @Query("signId") String signId,
            @Query("landingPhone") String landingPhone
    );
    //房间退订
    @POST("chl/sign/contract/ApplicationForCheckOut")
    Observable<BrokenUp> broenUpContractAction(
            @Query("phone") String phone,
            @Query("signId") String signId,
            @Query("checkOutDate") String checkOutDate,
            @Query("type") String type,
            @Query("landingPhone") String landingPhone
    );

    //支付模块
    //现金支付
    @POST("/chl/api/alipay/confirmPaymentOfCash")
    Observable<BrokenUp> payTheCash(
            @Query("roomId") String roomId,
            @Query("roomRentId") String roomRentId,
            @Query("widoutTradeNo") String widoutTradeNo,
            @Query("landingPhone") String landingPhone
    );
    //获取支付状态
    //按金
    @POST("/chl/api/alipay/findOrderMessageByAuid")
    Observable<BrokenUp> getMarginPayStatus(
            @Query("authId") String authId,
            @Query("widoutTradeNo") String widoutTradeNo,
            @Query("landingPhone") String landingPhone,
            @Query("roomId") String roomId,
            @Query("signId") String signId
    );
    @POST("chl/api/alipay/room/findOrderMessageByAuid")
    Observable<BrokenUp> getNroamlPayStatus(
            @Query("authId") String authId,
            @Query("widoutTradeNo") String widoutTradeNo,
            @Query("landingPhone") String landingPhone,
            @Query("roomRentId") String roomRentId,
            @Query("roomId") String roomId
    );
    //检查房间是否被支付过
    //按金
    @POST("chl/sign/contract/signRoomIsPay")
    Observable<BrokenUp> checkOrderHadPay(
            @Query("roomId") String roomId,
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone
    );
    //此地址用作检查用
    //    @POST("chl/api/alipay/createOrder")

    //我的房间模块
    @POST("/chl/room/findRoomMessageByPhone")
    Observable<RoomModel> findRoomMessageByPhone(
            @Query("phone") String phone
    );
    //订单历史
    @POST("chl/api/alipay/YunMenPayList")
    Observable<BrokenUp> getBillHistory(//这里返回的是多个model,暂时不知道怎么处理,但是基础model已经生成了BillHistoryModel
                                        @Query("phone") String phone,
                                        @Query("landingPhone") String landingPhone
    );
    //未完成的订单列表
    @POST("chl/room/findNoPayRoomRent")
    Observable<BillHistoryModel> getNoCompleteBill(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone,
            @Query("roomId") String roomId
    );
    //传感器
    //获取传感器周期列表
    @POST("chl/api/sensor/sensorList")
    Observable<SensorCycleModel> getSensorCycleList(
            @Query("phone") String phone,
            @Query("sensorId") String sensorId,
            @Query("landingPhone") String landingPhone
    );
    //设置传感器周期
    @POST("/chl/api/sensor/saveSensorTime")
    Observable<SensorCycleModel> setSensorWorkCycle(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone,
            @Query("startTime") String startTime,
            @Query("endTime") String endTime,
            @Query("cycleDate") String cycleDate,
            @Query("modeName") String modeName,
            @Query("sensorId") String sensorId,
            @Query("type") String type,
            @Query("ids") String ids
    );
    //传感器周期开关
    @POST("chl/api/sensor/updateSensorTimeStatus")
    Observable<SensorCycleModel> setSensorCycleWorkMode(
            @Query("phone") String phone,
            @Query("timeStatus") String timeStatus,
            @Query("ids") String ids,
            @Query("landingPhone") String landingPhone
    );
    //获取传感器列表
    @POST("chl/api/sensor/findRoomSensorTens")
    Observable<SensorModel> getRoomSensorList(
            @Query("roomId") String roomId,
            @Query("landingPhone") String landingPhone
    );
    //更新传感器工作状态
    @POST("chl/api/sensor/updateSensorStatus")
    Observable<BrokenUp> setSensorWorkMode(
            @Query("phone") String phone,
            @Query("sensorId") String sensorId,
            @Query("sensorStatus") String sensorStatus,
            @Query("landingPhone") String landingPhone
    );
    //消息模块
    //楼宇公告
    @POST("chl/buildings/findAdviceByPhone")
    Observable<BrokenUp> getBuildingNotice(//这里返回的数据格式跟我的房间差不多
                                           @Query("phone") String phone,
                                           @Query("landingPhone") String landingPhone
    );
    //其他消息/支付消息
    @POST("chl/sign/contract/findLandlordNew")
    Observable<BrokenUp> getOrderMessageAndPaMessage(//model还没做
                                                     @Query("phone") String phone,
                                                     @Query("landingPhone") String landingPhone,
                                                     @Query("type") String type
    );
    //确认退房
    @POST("chl/sign/contract/checkOut")
    Observable<BrokenUp> brokenUpDone(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone,
            @Query("signId") String signId
    );
    //获取传感器的消息
    @POST("chl/api/sensor/getRoomSensorBodyList")
    Observable<BrokenUp> getSensorMessageList(//model还没做
                                              @Query("phone") String phone,
                                              @Query("landingPhone") String landingPhone,
                                              @Query("roomId") String roomId,
                                              @Query("type") String type
    );
    //删除某部分传感器消息
    @POST("/chl/api/sensor/deleteSensorMessage")
    Observable<BrokenUp> deleteSensorData(
            @Query("phone") String phone,
            @Query("landingPhone") String landingPhone,
            @Query("sensorId") String sensorId,
            @Query("type") String type
    );

    //设置模块
    //提交反馈
    @POST("/chl/propelling/feedbackProblem")
    Observable<BrokenUp> feedbackProblem(
            @Query("phone") String phone,
            @Query("content") String content
    );
    //更新推送状态
    @POST("/chl/jdpush/upStatus")
    Observable<BrokenUp> upStatus(
            @Query("phone") String phone,
            @Query("status") String status,
            @Query("type") String type
    );
    //取消第三方授权
    @POST("chl/tenant/account/revoke")
    Observable<BrokenUp> cancelAuthorization(
            @Query("userPhone") String userPhone,
            @Query("unidType") String unidType,
            @Query("landingPhone") String landingPhone
    );

    //广告模块
    @POST("chl/enteringAdver/findFirstPic")
    Observable<StarAdModel> getStatAD(
            @Query("isLogin") String isLogin
    );

    //用户隐私&协议,直接拼接使用
    //    @POST("/chl/reult/rule2.html")
    //    @POST("/chl/reult/rule3.html")
}
