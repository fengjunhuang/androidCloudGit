package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 72984 on 2018/12/15.
 */

public class RoomModel  extends  BaseBean {


    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean implements Serializable {
        /**
         * myRoomBuildingID : 1540806796986
         * myRoomContractImageUrl :
         * myRoomDealHadNoComplete : true
         * myRoomID : 3gZxTNvS
         * myRoomIsOwner : true
         * myRoomLandLoardPhone : 13800138000
         * myRoomMakeADealAvailable : true
         * myRoomMakeADealInfo : 已经交房租
         * myRoomMan : 50
         * myRoomName : 安合花园 101
         * myRoomNet : 50
         * myRoomPayBillServerId :
         * myRoomPower : 0.0
         * myRoomPowerArr : [0,0,0,0,0,0,0,0,0,0,0,0]
         * myRoomPowerUnivalence : 1.6
         * myRoomRent : 1750
         * myRoomRentDate : 2018-12-01至2018-12-31
         * myRoomSensorList : [{"sensorID":"123456","sensorName":"室内多功能集成传感器","sensorOn":"fasle"}]
         * myRoomServiceCharge : 30
         * myRoomTem : 36
         * myRoomTotal : 1880.0
         * myRoomWater : 0.0
         * myRoomWaterArr : [0,0,0,0,0,0,0,0,0,0,0,0]
         * myRoomWaterUnivalence : 6.0
         * myRoomWet : 100
         */
        private String myRoomPayBillServerId;
        private String myRoomName;
        private String myRoomWaterUnivalence;
        private String myRoomPowerUnivalence;
        private String myRoomRent;
        private String myRoomPower;
        private String myRoomWater;
        private String myRoomTotal;
        private String myRoomID;
        private String myRoomMakeADealAvailable;
        private String myRoomMakeADealInfo;
        private String myRoomLandLoardPhone;
        private String myRoomMan;
        private String myRoomNet;
        private String myRoomBuildingID;
        private Boolean myRoomIsOwner;
        private String myRoomServiceCharge;
        private String myRoomRentDate;
        private String myRoomDealHadNoComplete;
        private List<Double> myRoomPowerArr;
        private List<Double> myRoomWaterArr;

        //可能会弃用的字段
        private String myRoomContractImageUrl;
        private String myRoomTem;
        private String myRoomWet;
        private List<MyRoomSensorListBean> myRoomSensorList;

        public String getMyRoomBuildingID() {
            return myRoomBuildingID;
        }

        public void setMyRoomBuildingID(String myRoomBuildingID) {
            this.myRoomBuildingID = myRoomBuildingID;
        }

        public String getMyRoomContractImageUrl() {
            return myRoomContractImageUrl;
        }

        public void setMyRoomContractImageUrl(String myRoomContractImageUrl) {
            this.myRoomContractImageUrl = myRoomContractImageUrl;
        }

        public String getMyRoomDealHadNoComplete() {
            return myRoomDealHadNoComplete;
        }

        public void setMyRoomDealHadNoComplete(String myRoomDealHadNoComplete) {
            this.myRoomDealHadNoComplete = myRoomDealHadNoComplete;
        }

        public String getMyRoomID() {
            return myRoomID;
        }

        public void setMyRoomID(String myRoomID) {
            this.myRoomID = myRoomID;
        }

        public Boolean getMyRoomIsOwner() {
            return myRoomIsOwner;
        }

        public void setMyRoomIsOwner(Boolean myRoomIsOwner) {
            this.myRoomIsOwner = myRoomIsOwner;
        }

        public String getMyRoomLandLoardPhone() {
            return myRoomLandLoardPhone;
        }

        public void setMyRoomLandLoardPhone(String myRoomLandLoardPhone) {
            this.myRoomLandLoardPhone = myRoomLandLoardPhone;
        }

        public String getMyRoomMakeADealAvailable() {
            return myRoomMakeADealAvailable;
        }

        public void setMyRoomMakeADealAvailable(String myRoomMakeADealAvailable) {
            this.myRoomMakeADealAvailable = myRoomMakeADealAvailable;
        }

        public String getMyRoomMakeADealInfo() {
            return myRoomMakeADealInfo;
        }

        public void setMyRoomMakeADealInfo(String myRoomMakeADealInfo) {
            this.myRoomMakeADealInfo = myRoomMakeADealInfo;
        }

        public String getMyRoomMan() {
            return myRoomMan;
        }

        public void setMyRoomMan(String myRoomMan) {
            this.myRoomMan = myRoomMan;
        }

        public String getMyRoomName() {
            return myRoomName;
        }

        public void setMyRoomName(String myRoomName) {
            this.myRoomName = myRoomName;
        }

        public String getMyRoomNet() {
            return myRoomNet;
        }

        public void setMyRoomNet(String myRoomNet) {
            this.myRoomNet = myRoomNet;
        }

        public String getMyRoomPayBillServerId() {
            return myRoomPayBillServerId;
        }

        public void setMyRoomPayBillServerId(String myRoomPayBillServerId) {
            this.myRoomPayBillServerId = myRoomPayBillServerId;
        }

        public String getMyRoomPower() {
            return myRoomPower;
        }

        public void setMyRoomPower(String myRoomPower) {
            this.myRoomPower = myRoomPower;
        }

        public String getMyRoomPowerUnivalence() {
            return myRoomPowerUnivalence;
        }

        public void setMyRoomPowerUnivalence(String myRoomPowerUnivalence) {
            this.myRoomPowerUnivalence = myRoomPowerUnivalence;
        }

        public String getMyRoomRent() {
            return myRoomRent;
        }

        public void setMyRoomRent(String myRoomRent) {
            this.myRoomRent = myRoomRent;
        }

        public String getMyRoomRentDate() {
            return myRoomRentDate;
        }

        public void setMyRoomRentDate(String myRoomRentDate) {
            this.myRoomRentDate = myRoomRentDate;
        }

        public String getMyRoomServiceCharge() {
            return myRoomServiceCharge;
        }

        public void setMyRoomServiceCharge(String myRoomServiceCharge) {
            this.myRoomServiceCharge = myRoomServiceCharge;
        }

        public String getMyRoomTem() {
            return myRoomTem;
        }

        public void setMyRoomTem(String myRoomTem) {
            this.myRoomTem = myRoomTem;
        }

        public String getMyRoomTotal() {
            return myRoomTotal;
        }

        public void setMyRoomTotal(String myRoomTotal) {
            this.myRoomTotal = myRoomTotal;
        }

        public String getMyRoomWater() {
            return myRoomWater;
        }

        public void setMyRoomWater(String myRoomWater) {
            this.myRoomWater = myRoomWater;
        }

        public String getMyRoomWaterUnivalence() {
            return myRoomWaterUnivalence;
        }

        public void setMyRoomWaterUnivalence(String myRoomWaterUnivalence) {
            this.myRoomWaterUnivalence = myRoomWaterUnivalence;
        }

        public String getMyRoomWet() {
            return myRoomWet;
        }

        public void setMyRoomWet(String myRoomWet) {
            this.myRoomWet = myRoomWet;
        }

        public List<Double> getMyRoomPowerArr() {
            return myRoomPowerArr;
        }

        public void setMyRoomPowerArr(List<Double> myRoomPowerArr) {
            this.myRoomPowerArr = myRoomPowerArr;
        }

        public List<MyRoomSensorListBean> getMyRoomSensorList() {
            return myRoomSensorList;
        }

        public void setMyRoomSensorList(List<MyRoomSensorListBean> myRoomSensorList) {
            this.myRoomSensorList = myRoomSensorList;
        }

        public List<Double> getMyRoomWaterArr() {
            return myRoomWaterArr;
        }

        public void setMyRoomWaterArr(List<Double> myRoomWaterArr) {
            this.myRoomWaterArr = myRoomWaterArr;
        }

        public static class MyRoomSensorListBean implements Serializable {
            /**
             * sensorID : 123456
             * sensorName : 室内多功能集成传感器
             * sensorOn : fasle
             */

            private String sensorID;
            private String sensorName;
            private String sensorOn;

            public String getSensorID() {
                return sensorID;
            }

            public void setSensorID(String sensorID) {
                this.sensorID = sensorID;
            }

            public String getSensorName() {
                return sensorName;
            }

            public void setSensorName(String sensorName) {
                this.sensorName = sensorName;
            }

            public String getSensorOn() {
                return sensorOn;
            }

            public void setSensorOn(String sensorOn) {
                this.sensorOn = sensorOn;
            }
        }
    }
}
