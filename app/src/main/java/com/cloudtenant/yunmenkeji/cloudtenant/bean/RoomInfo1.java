package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 72984 on 2018/7/4.
 */

public class RoomInfo1 extends BaseBean {


    /**
     * contract : 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
     * viewData : [{"isCollection":false,"roomBuildingID":"1542004972597","roomHave360":"0","roomID":"gvy7vXSB","roomLat":"113.392588","roomLng":"23.125002","roomMarginType":"1按1付","roomMoney":2680,"roomMoreImageArr":[],"roomNumber":1001,"roomSet":"天然气 衣柜 热水器 床 电视机 宽带 冰箱 沙发 洗衣机 空调","roomSimpleImage":"/chl/upload/app/2018-11-30/740618d2-032e-45f2-a77b-60c2cc8dc895buildingMainPic.jpg","roomSquare":"1","roomStatus":"1","roomStyle":"1"}]
     */

    private String contract;
    private List<ViewDataBean> viewData;

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getContract() throws Exception {
        return AESOperator.getInstance().decrypt(contract);
    }

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }


    public static class ViewDataBean implements Serializable {
        /**
         * isCollection : false
         * roomBuildingID : 1540810329283
         * roomHave360 : 0
         * roomID : TiCnpHrQ
         * roomLat : 23.133931
         * roomLng : 113.407137
         * roomMarginType : 1按1付
         * roomMoney : 1650
         * roomMoreImageArr : [{"imageFullView":"2","imageShowType":2,"imageUrl":"/chl/upload/app/2018-11-30/1a89e041-f4c7-4a9a-b273-541dd7497cccroomPic.jpg"},{"imageFullView":"2","imageShowType":2,"imageUrl":"/chl/upload/app/2018-11-30/2da5d771-1ef1-45da-bf0a-e16375c43c0froomPic.jpg"},{"imageFullView":"2","imageInfo":"","imageShowType":2,"imageTitle":"","imageUrl":"/chl/upload/app/2018-11-30/416a6008-d700-4105-b8b4-6e82a6f335c7roomPic.jpg"},{"imageFullView":"2","imageInfo":"","imageShowType":2,"imageTitle":"","imageUrl":"/chl/upload/app/2018-11-30/179325e1-3873-4bb8-a32b-9b54f0813c4broomPic.jpg"},{"imageFullView":"2","imageInfo":"","imageShowType":2,"imageTitle":"","imageUrl":"/chl/upload/app/2018-11-30/f04f4e79-07ed-4890-b19f-4ffaa5d7fc2droomPic.jpg"},{"imageFullView":"2","imageShowType":2,"imageUrl":"/chl/upload/app/2018-11-30/f3a942d8-51ed-4c55-9990-76abcd6878deroomPic.jpg"}]
         * roomNumber : 405
         * roomSet : 天然气
         * roomSimpleImage : /chl/upload/app/2018-11-30/c18170b6-116b-402b-9238-0e6ff7c2658cbuildingMainPic.jpg
         * roomSquare : 1
         * roomStatus : 0
         * roomStyle : 0
         */

        private boolean isCollection;
        private String roomBuildingID;
        private String roomHave360;
        private String roomID;
        private String roomLat;
        private String roomLng;
        private String roomMarginType;
        private int roomMoney;
        private int roomNumber;
        private String roomSet;
        private String roomSimpleImage;
        private String roomSquare;
        private String roomStatus;
        private String roomStyle;
        private List<RoomMoreImageArrBean> roomMoreImageArr;

        public boolean isIsCollection() {
            return isCollection;
        }

        public void setIsCollection(boolean isCollection) {
            this.isCollection = isCollection;
        }

        public String getRoomBuildingID() {
            return roomBuildingID;
        }

        public void setRoomBuildingID(String roomBuildingID) {
            this.roomBuildingID = roomBuildingID;
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

        public String getRoomLat() {
            return roomLat;
        }

        public void setRoomLat(String roomLat) {
            this.roomLat = roomLat;
        }

        public String getRoomLng() {
            return roomLng;
        }

        public void setRoomLng(String roomLng) {
            this.roomLng = roomLng;
        }

        public String getRoomMarginType() {
            return roomMarginType;
        }

        public void setRoomMarginType(String roomMarginType) {
            this.roomMarginType = roomMarginType;
        }

        public int getRoomMoney() {
            return roomMoney;
        }

        public void setRoomMoney(int roomMoney) {
            this.roomMoney = roomMoney;
        }

        public int getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(int roomNumber) {
            this.roomNumber = roomNumber;
        }

        public String getRoomSet() {
            return roomSet;
        }

        public void setRoomSet(String roomSet) {
            this.roomSet = roomSet;
        }

        public String getRoomSimpleImage() {
            return roomSimpleImage;
        }

        public void setRoomSimpleImage(String roomSimpleImage) {
            this.roomSimpleImage = roomSimpleImage;
        }

        public String getRoomSquare() {
            return roomSquare;
        }

        public void setRoomSquare(String roomSquare) {
            this.roomSquare = roomSquare;
        }

        public String getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(String roomStatus) {
            this.roomStatus = roomStatus;
        }

        public String getRoomStyle() {
            return roomStyle;
        }

        public void setRoomStyle(String roomStyle) {
            this.roomStyle = roomStyle;
        }

        public List<RoomMoreImageArrBean> getRoomMoreImageArr() {
            return roomMoreImageArr;
        }

        public void setRoomMoreImageArr(List<RoomMoreImageArrBean> roomMoreImageArr) {
            this.roomMoreImageArr = roomMoreImageArr;
        }

        public static class RoomMoreImageArrBean {
            /**
             * imageFullView : 2
             * imageShowType : 2
             * imageUrl : /chl/upload/app/2018-11-30/1a89e041-f4c7-4a9a-b273-541dd7497cccroomPic.jpg
             * imageInfo :
             * imageTitle :
             */

            private String imageFullView;
            private int imageShowType;
            private String imageUrl;
            private String imageInfo;
            private String imageTitle;

            public String getImageFullView() {
                return imageFullView;
            }

            public void setImageFullView(String imageFullView) {
                this.imageFullView = imageFullView;
            }

            public int getImageShowType() {
                return imageShowType;
            }

            public void setImageShowType(int imageShowType) {
                this.imageShowType = imageShowType;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getImageInfo() {
                return imageInfo;
            }

            public void setImageInfo(String imageInfo) {
                this.imageInfo = imageInfo;
            }

            public String getImageTitle() {
                return imageTitle;
            }

            public void setImageTitle(String imageTitle) {
                this.imageTitle = imageTitle;
            }
        }
    }
}
