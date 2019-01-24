package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MyCollection extends BaseBean{
    private List<ViewDataBean> viewData;

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean {
        /**
         * buildingName : 瑞安创意
         * orderID : 1543634152951
         * roomHave360 : 0
         * roomID : gHVNDkr8
         * roomImage : /chl/upload/app/2018-12-03/5d549350-b508-4834-b3e5-194ea8dc3b0dbuildingMainPic.jpg
         * roomMarginType : 2按1付
         * roomMonthly : 9000
         * roomNum : 303
         * roomSet : 空调 床 热水器 衣柜 电视机 洗衣机 沙发 冰箱 宽带 天然气
         * roomStyleType : 2
         */

        private String buildingName;
        private String orderID;
        private String roomHave360;
        private String roomID;
        private String roomImage;
        private String roomMarginType;
        private int roomMonthly;
        private int roomNum;
        private String roomSet;
        private String roomStyleType;

        public String getBuildingName() {
            return buildingName;
        }

        public void setBuildingName(String buildingName) {
            this.buildingName = buildingName;
        }

        public String getOrderID() {
            return orderID;
        }

        public void setOrderID(String orderID) {
            this.orderID = orderID;
        }

        public String getRoomHave360() {
            return roomHave360;
        }

        public void setRoomHave360(String roomHave360) {
            this.roomHave360 = roomHave360;
        }

        public String getRoomID() {
            return roomID;
        }

        public void setRoomID(String roomID) {
            this.roomID = roomID;
        }

        public String getRoomImage() {
            return roomImage;
        }

        public void setRoomImage(String roomImage) {
            this.roomImage = roomImage;
        }

        public String getRoomMarginType() {
            return roomMarginType;
        }

        public void setRoomMarginType(String roomMarginType) {
            this.roomMarginType = roomMarginType;
        }

        public int getRoomMonthly() {
            return roomMonthly;
        }

        public void setRoomMonthly(int roomMonthly) {
            this.roomMonthly = roomMonthly;
        }

        public int getRoomNum() {
            return roomNum;
        }

        public void setRoomNum(int roomNum) {
            this.roomNum = roomNum;
        }

        public String getRoomSet() {
            return roomSet;
        }

        public void setRoomSet(String roomSet) {
            this.roomSet = roomSet;
        }

        public String getRoomStyleType() {
            return roomStyleType;
        }

        public void setRoomStyleType(String roomStyleType) {
            this.roomStyleType = roomStyleType;
        }
    }
}
