package com.cloudtenant.yunmenkeji.cloudtenant.model;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.bean.BaseBeanC;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 72984 on 2018/6/30.
 */

public class MyRoom extends BaseBeanC {

    /**
     * id : 14
     * viewData : [{"myRoomLandLoardPhone":"13800138000","myRoomMan":"6","myRoomNet":"50","myRoomTem":"36","myRoomWet":"70","myRoomChartPowerAndWaterYearMax":"600","myRoomName":"东圃明珠新村6栋201","myRoomSensorList":[{"sensorName":"传感器1","sensorOn":false,"sensorID":"123456"}],"myRoomWaterArr":[14,16,11,12,18,10,21,32,17,12,17,19],"myRoomPowerArr":[30,50,81,46,204,290,310,259,530,430,498,431],"myRoomWaterUnivalence":"6","myRoomPowerUnivalence":"1.3","myRoomRent":"800","myRoomWater":"10","myRoomPower":"249","myRoomTotal":"1059","myRoomID":"1234123421","myRoomContractImageUrl":"http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg","myRoomMakeADealAvailable":true,"myRoomBuildingID":"123123","myRoomIsOwner":true,"myRoomWaterArrHalf":[23,21,18,16,19,10],"myRoomPowerArrHalf":[256,273,351,284,248,286],"myRoomLineMaxHalf":"900","myRoomWaterTotalHalf":"666","myRoomPowerTotalHalf":"10000","myRoomRentTotalHalf":"11111","myRoomManTotalHalf":"123","myRoomNetTotalHalf":"456","myRoomWaterArrQuarter":[15,6,11],"myRoomPowerArrQuarter":[62,42,32],"myRoomLineMaxQuarter":"900","myRoomWaterTotalQuarter":"123","myRoomPowerTotalQuarter":"1355","myRoomRentTotalQuarter":"11111","myRoomManTotalQuarter":"123","myRoomNetTotalQuarter":"456","myRoomHalfYearType":1,"myRoomQuarterType":1,"myRoomTotalYearHouse":"998","myRoomTotalYearWater":"100","myRoomTotalYearPower":"800","myRoomTotalYearMan":"600","myRoomTotalYearNet":"600"},{"myRoomLandLoardPhone":"13800138000","myRoomMan":"6","myRoomNet":"50","myRoomTem":"36","myRoomWet":"70","myRoomChartPowerAndWaterYearMax":"600","myRoomName":"东圃明珠新村6栋202","myRoomSensorList":[{"sensorName":"传感器1","sensorOn":true,"sensorID":"123456"}],"myRoomWaterArr":[14,16,11,12,18,10,21,32,17,12,17,19],"myRoomPowerArr":[30,50,81,46,204,290,310,259,530,430,498,431],"myRoomWaterUnivalence":"6","myRoomPowerUnivalence":"1.3","myRoomRent":"800","myRoomWater":"10","myRoomPower":"249","myRoomTotal":"1059","myRoomID":"1234123421","myRoomContractImageUrl":"http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg","myRoomMakeADealAvailable":true,"myRoomBuildingID":"123123","myRoomIsOwner":false,"myRoomWaterArrHalf":[23,21,18,16,19,10],"myRoomPowerArrHalf":[256,273,351,284,248,286],"myRoomLineMaxHalf":"900","myRoomWaterTotalHalf":"666","myRoomPowerTotalHalf":"10000","myRoomRentTotalHalf":"11111","myRoomManTotalHalf":"123","myRoomNetTotalHalf":"456","myRoomWaterArrQuarter":[15,6,11],"myRoomPowerArrQuarter":[62,42,32],"myRoomLineMaxQuarter":"900","myRoomWaterTotalQuarter":"123","myRoomPowerTotalQuarter":"1355","myRoomRentTotalQuarter":"11111","myRoomManTotalQuarter":"123","myRoomNetTotalQuarter":"456","myRoomHalfYearType":1,"myRoomQuarterType":1,"myRoomTotalYearHouse":"998","myRoomTotalYearWater":"100","myRoomTotalYearPower":"800","myRoomTotalYearMan":"600","myRoomTotalYearNet":"600"}]
     */

    private String id;

    private List<ViewDataBean> viewDataX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ViewDataBean> getViewDataX() throws Exception {
         return  JSON.parseArray(getViewData(),MyRoom.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean  implements Serializable{
        /**
         * myRoomLandLoardPhone : 13800138000
         * myRoomMan : 6
         * myRoomNet : 50
         * myRoomTem : 36
         * myRoomWet : 70
         * myRoomChartPowerAndWaterYearMax : 600
         * myRoomName : 东圃明珠新村6栋201
         * myRoomSensorList : [{"sensorName":"传感器1","sensorOn":false,"sensorID":"123456"}]
         * myRoomWaterArr : [14,16,11,12,18,10,21,32,17,12,17,19]
         * myRoomPowerArr : [30,50,81,46,204,290,310,259,530,430,498,431]
         * myRoomWaterUnivalence : 6
         * myRoomPowerUnivalence : 1.3
         * myRoomRent : 800
         * myRoomWater : 10
         * myRoomPower : 249
         * myRoomTotal : 1059
         * myRoomID : 1234123421
         * myRoomContractImageUrl : http://p3.music.126.net/VDn1p3j4g2z4p16Gux969w==/2544269907756816.jpg
         * myRoomMakeADealAvailable : true
         * myRoomBuildingID : 123123
         * myRoomIsOwner : true
         * myRoomWaterArrHalf : [23,21,18,16,19,10]
         * myRoomPowerArrHalf : [256,273,351,284,248,286]
         * myRoomLineMaxHalf : 900
         * myRoomWaterTotalHalf : 666
         * myRoomPowerTotalHalf : 10000
         * myRoomRentTotalHalf : 11111
         * myRoomManTotalHalf : 123
         * myRoomNetTotalHalf : 456
         * myRoomWaterArrQuarter : [15,6,11]
         * myRoomPowerArrQuarter : [62,42,32]
         * myRoomLineMaxQuarter : 900
         * myRoomWaterTotalQuarter : 123
         * myRoomPowerTotalQuarter : 1355
         * myRoomRentTotalQuarter : 11111
         * myRoomManTotalQuarter : 123
         * myRoomNetTotalQuarter : 456
         * myRoomHalfYearType : 1
         * myRoomQuarterType : 1
         * myRoomTotalYearHouse : 998
         * myRoomTotalYearWater : 100
         * myRoomTotalYearPower : 800
         * myRoomTotalYearMan : 600
         * myRoomTotalYearNet : 600
         */

        private String myRoomLandLoardPhone;
        private String myRoomMan;
        private String myRoomNet;
        private String myRoomTem;
        private String myRoomWet;
        private String myRoomChartPowerAndWaterYearMax;
        private String myRoomName;
        private String myRoomWaterUnivalence;
        private String myRoomPowerUnivalence;
        private String myRoomRent;
        private String myRoomWater;
        private String myRoomPower;
        private String myRoomTotal;
        private String myRoomID;
        private String myRoomContractImageUrl;
        private boolean myRoomMakeADealAvailable;
        private String myRoomBuildingID;
        private boolean myRoomIsOwner;
        private String myRoomLineMaxHalf;
        private String myRoomWaterTotalHalf;
        private String myRoomPowerTotalHalf;
        private String myRoomRentTotalHalf;
        private String myRoomManTotalHalf;
        private String myRoomNetTotalHalf;
        private String myRoomLineMaxQuarter;
        private String myRoomWaterTotalQuarter;
        private String myRoomPowerTotalQuarter;
        private String myRoomRentTotalQuarter;
        private String myRoomManTotalQuarter;
        private String myRoomNetTotalQuarter;
        private int myRoomHalfYearType;
        private int myRoomQuarterType;
        private String myRoomTotalYearHouse;
        private String myRoomTotalYearWater;
        private String myRoomTotalYearPower;
        private String myRoomTotalYearMan;
        private String myRoomTotalYearNet;
        private List<MyRoomSensorListBean> myRoomSensorList;
        private List<Integer> myRoomWaterArr;
        private List<Integer> myRoomPowerArr;
        private List<Integer> myRoomWaterArrHalf;
        private List<Integer> myRoomPowerArrHalf;
        private List<Integer> myRoomWaterArrQuarter;
        private List<Integer> myRoomPowerArrQuarter;

        public String getMyRoomLandLoardPhone() {
            return myRoomLandLoardPhone;
        }

        public void setMyRoomLandLoardPhone(String myRoomLandLoardPhone) {
            this.myRoomLandLoardPhone = myRoomLandLoardPhone;
        }

        public String getMyRoomMan() {
            return myRoomMan;
        }

        public void setMyRoomMan(String myRoomMan) {
            this.myRoomMan = myRoomMan;
        }

        public String getMyRoomNet() {
            return myRoomNet;
        }

        public void setMyRoomNet(String myRoomNet) {
            this.myRoomNet = myRoomNet;
        }

        public String getMyRoomTem() {
            return myRoomTem;
        }

        public void setMyRoomTem(String myRoomTem) {
            this.myRoomTem = myRoomTem;
        }

        public String getMyRoomWet() {
            return myRoomWet;
        }

        public void setMyRoomWet(String myRoomWet) {
            this.myRoomWet = myRoomWet;
        }

        public String getMyRoomChartPowerAndWaterYearMax() {
            return myRoomChartPowerAndWaterYearMax;
        }

        public void setMyRoomChartPowerAndWaterYearMax(String myRoomChartPowerAndWaterYearMax) {
            this.myRoomChartPowerAndWaterYearMax = myRoomChartPowerAndWaterYearMax;
        }

        public String getMyRoomName() {
            return myRoomName;
        }

        public void setMyRoomName(String myRoomName) {
            this.myRoomName = myRoomName;
        }

        public String getMyRoomWaterUnivalence() {
            return myRoomWaterUnivalence;
        }

        public void setMyRoomWaterUnivalence(String myRoomWaterUnivalence) {
            this.myRoomWaterUnivalence = myRoomWaterUnivalence;
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

        public String getMyRoomWater() {
            return myRoomWater;
        }

        public void setMyRoomWater(String myRoomWater) {
            this.myRoomWater = myRoomWater;
        }

        public String getMyRoomPower() {
            return myRoomPower;
        }

        public void setMyRoomPower(String myRoomPower) {
            this.myRoomPower = myRoomPower;
        }

        public String getMyRoomTotal() {
            return myRoomTotal;
        }

        public void setMyRoomTotal(String myRoomTotal) {
            this.myRoomTotal = myRoomTotal;
        }

        public String getMyRoomID() {
            return myRoomID;
        }

        public void setMyRoomID(String myRoomID) {
            this.myRoomID = myRoomID;
        }

        public String getMyRoomContractImageUrl() {
            return myRoomContractImageUrl;
        }

        public void setMyRoomContractImageUrl(String myRoomContractImageUrl) {
            this.myRoomContractImageUrl = myRoomContractImageUrl;
        }

        public boolean isMyRoomMakeADealAvailable() {
            return myRoomMakeADealAvailable;
        }

        public void setMyRoomMakeADealAvailable(boolean myRoomMakeADealAvailable) {
            this.myRoomMakeADealAvailable = myRoomMakeADealAvailable;
        }

        public String getMyRoomBuildingID() {
            return myRoomBuildingID;
        }

        public void setMyRoomBuildingID(String myRoomBuildingID) {
            this.myRoomBuildingID = myRoomBuildingID;
        }

        public boolean isMyRoomIsOwner() {
            return myRoomIsOwner;
        }

        public void setMyRoomIsOwner(boolean myRoomIsOwner) {
            this.myRoomIsOwner = myRoomIsOwner;
        }

        public String getMyRoomLineMaxHalf() {
            return myRoomLineMaxHalf;
        }

        public void setMyRoomLineMaxHalf(String myRoomLineMaxHalf) {
            this.myRoomLineMaxHalf = myRoomLineMaxHalf;
        }

        public String getMyRoomWaterTotalHalf() {
            return myRoomWaterTotalHalf;
        }

        public void setMyRoomWaterTotalHalf(String myRoomWaterTotalHalf) {
            this.myRoomWaterTotalHalf = myRoomWaterTotalHalf;
        }

        public String getMyRoomPowerTotalHalf() {
            return myRoomPowerTotalHalf;
        }

        public void setMyRoomPowerTotalHalf(String myRoomPowerTotalHalf) {
            this.myRoomPowerTotalHalf = myRoomPowerTotalHalf;
        }

        public String getMyRoomRentTotalHalf() {
            return myRoomRentTotalHalf;
        }

        public void setMyRoomRentTotalHalf(String myRoomRentTotalHalf) {
            this.myRoomRentTotalHalf = myRoomRentTotalHalf;
        }

        public String getMyRoomManTotalHalf() {
            return myRoomManTotalHalf;
        }

        public void setMyRoomManTotalHalf(String myRoomManTotalHalf) {
            this.myRoomManTotalHalf = myRoomManTotalHalf;
        }

        public String getMyRoomNetTotalHalf() {
            return myRoomNetTotalHalf;
        }

        public void setMyRoomNetTotalHalf(String myRoomNetTotalHalf) {
            this.myRoomNetTotalHalf = myRoomNetTotalHalf;
        }

        public String getMyRoomLineMaxQuarter() {
            return myRoomLineMaxQuarter;
        }

        public void setMyRoomLineMaxQuarter(String myRoomLineMaxQuarter) {
            this.myRoomLineMaxQuarter = myRoomLineMaxQuarter;
        }

        public String getMyRoomWaterTotalQuarter() {
            return myRoomWaterTotalQuarter;
        }

        public void setMyRoomWaterTotalQuarter(String myRoomWaterTotalQuarter) {
            this.myRoomWaterTotalQuarter = myRoomWaterTotalQuarter;
        }

        public String getMyRoomPowerTotalQuarter() {
            return myRoomPowerTotalQuarter;
        }

        public void setMyRoomPowerTotalQuarter(String myRoomPowerTotalQuarter) {
            this.myRoomPowerTotalQuarter = myRoomPowerTotalQuarter;
        }

        public String getMyRoomRentTotalQuarter() {
            return myRoomRentTotalQuarter;
        }

        public void setMyRoomRentTotalQuarter(String myRoomRentTotalQuarter) {
            this.myRoomRentTotalQuarter = myRoomRentTotalQuarter;
        }

        public String getMyRoomManTotalQuarter() {
            return myRoomManTotalQuarter;
        }

        public void setMyRoomManTotalQuarter(String myRoomManTotalQuarter) {
            this.myRoomManTotalQuarter = myRoomManTotalQuarter;
        }

        public String getMyRoomNetTotalQuarter() {
            return myRoomNetTotalQuarter;
        }

        public void setMyRoomNetTotalQuarter(String myRoomNetTotalQuarter) {
            this.myRoomNetTotalQuarter = myRoomNetTotalQuarter;
        }

        public int getMyRoomHalfYearType() {
            return myRoomHalfYearType;
        }

        public void setMyRoomHalfYearType(int myRoomHalfYearType) {
            this.myRoomHalfYearType = myRoomHalfYearType;
        }

        public int getMyRoomQuarterType() {
            return myRoomQuarterType;
        }

        public void setMyRoomQuarterType(int myRoomQuarterType) {
            this.myRoomQuarterType = myRoomQuarterType;
        }

        public String getMyRoomTotalYearHouse() {
            return myRoomTotalYearHouse;
        }

        public void setMyRoomTotalYearHouse(String myRoomTotalYearHouse) {
            this.myRoomTotalYearHouse = myRoomTotalYearHouse;
        }

        public String getMyRoomTotalYearWater() {
            return myRoomTotalYearWater;
        }

        public void setMyRoomTotalYearWater(String myRoomTotalYearWater) {
            this.myRoomTotalYearWater = myRoomTotalYearWater;
        }

        public String getMyRoomTotalYearPower() {
            return myRoomTotalYearPower;
        }

        public void setMyRoomTotalYearPower(String myRoomTotalYearPower) {
            this.myRoomTotalYearPower = myRoomTotalYearPower;
        }

        public String getMyRoomTotalYearMan() {
            return myRoomTotalYearMan;
        }

        public void setMyRoomTotalYearMan(String myRoomTotalYearMan) {
            this.myRoomTotalYearMan = myRoomTotalYearMan;
        }

        public String getMyRoomTotalYearNet() {
            return myRoomTotalYearNet;
        }

        public void setMyRoomTotalYearNet(String myRoomTotalYearNet) {
            this.myRoomTotalYearNet = myRoomTotalYearNet;
        }

        public List<MyRoomSensorListBean> getMyRoomSensorList() {
            return myRoomSensorList;
        }

        public void setMyRoomSensorList(List<MyRoomSensorListBean> myRoomSensorList) {
            this.myRoomSensorList = myRoomSensorList;
        }

        public List<Integer> getMyRoomWaterArr() {
            return myRoomWaterArr;
        }

        public void setMyRoomWaterArr(List<Integer> myRoomWaterArr) {
            this.myRoomWaterArr = myRoomWaterArr;
        }

        public List<Integer> getMyRoomPowerArr() {
            return myRoomPowerArr;
        }

        public void setMyRoomPowerArr(List<Integer> myRoomPowerArr) {
            this.myRoomPowerArr = myRoomPowerArr;
        }

        public List<Integer> getMyRoomWaterArrHalf() {
            return myRoomWaterArrHalf;
        }

        public void setMyRoomWaterArrHalf(List<Integer> myRoomWaterArrHalf) {
            this.myRoomWaterArrHalf = myRoomWaterArrHalf;
        }

        public List<Integer> getMyRoomPowerArrHalf() {
            return myRoomPowerArrHalf;
        }

        public void setMyRoomPowerArrHalf(List<Integer> myRoomPowerArrHalf) {
            this.myRoomPowerArrHalf = myRoomPowerArrHalf;
        }

        public List<Integer> getMyRoomWaterArrQuarter() {
            return myRoomWaterArrQuarter;
        }

        public void setMyRoomWaterArrQuarter(List<Integer> myRoomWaterArrQuarter) {
            this.myRoomWaterArrQuarter = myRoomWaterArrQuarter;
        }

        public List<Integer> getMyRoomPowerArrQuarter() {
            return myRoomPowerArrQuarter;
        }

        public void setMyRoomPowerArrQuarter(List<Integer> myRoomPowerArrQuarter) {
            this.myRoomPowerArrQuarter = myRoomPowerArrQuarter;
        }

        public static class MyRoomSensorListBean  implements Serializable{
            /**
             * sensorName : 传感器1
             * sensorOn : false
             * sensorID : 123456
             */

            private String sensorName;
            private boolean sensorOn;
            private String sensorID;

            public String getSensorName() {
                return sensorName;
            }

            public void setSensorName(String sensorName) {
                this.sensorName = sensorName;
            }

            public boolean isSensorOn() {
                return sensorOn;
            }

            public void setSensorOn(boolean sensorOn) {
                this.sensorOn = sensorOn;
            }

            public String getSensorID() {
                return sensorID;
            }

            public void setSensorID(String sensorID) {
                this.sensorID = sensorID;
            }
        }
    }
}
