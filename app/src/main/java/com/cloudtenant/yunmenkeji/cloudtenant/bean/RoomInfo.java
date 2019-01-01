package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 72984 on 2018/7/4.
 */

public class RoomInfo extends BaseBeanC{

    /**
     * id : 2
     * contract :
     * viewData : [{"roomSquare":"20","roomMoney":"280","roomNumber":"101","roomStatus":0,"roomReviewTimes":"10","roomHave360":true,"roomSet":"单间 热水器 床铺","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG","roomMarginType":0,"roomStyle":"一房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"1","imageUrl":"https://theta360cn.com/cn/gallery/img/v_04.jpg"},{"imageTitle":"屋内环境照片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6B/v800x600_ChAFD1pjWsSADtIvAA5dAQdG5QU465.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"浴室配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6D/v800x600_ChAFD1pjXBeAHhzNABBYSCeS78Q079.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"}]
     */

    private String id;
    private String contract;

    private List<RoomInfo.ViewDataBean> viewDataX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public String getContract() throws Exception {
        return AESOperator.getInstance().decrypt(contract);
    }

    public void setContract(String contract) {
        this.contract = contract;
    }


    public List<RoomInfo.ViewDataBean> getViewDataX() throws Exception {
       return this.viewDataX=JSON.parseArray(getViewData(),RoomInfo.ViewDataBean.class);
    }

    public void setViewDataX(List<RoomInfo.ViewDataBean> viewDataX) throws Exception {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean implements Serializable {
        /**
         * roomSquare : 20
         * roomMoney : 280
         * roomNumber : 101
         * roomStatus : 0
         * roomReviewTimes : 10
         * roomHave360 : true
         * roomSet : 单间 热水器 床铺
         * roomID : 11
         * roomSimpleImage : http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG
         * roomMarginType : 0
         * roomStyle : 一房一厅
         * roomMoreImageArr : [{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"1","imageUrl":"https://theta360cn.com/cn/gallery/img/v_04.jpg"},{"imageTitle":"屋内环境照片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6B/v800x600_ChAFD1pjWsSADtIvAA5dAQdG5QU465.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"浴室配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6D/v800x600_ChAFD1pjXBeAHhzNABBYSCeS78Q079.JPG"}]
         * roomBuildingID : 123123
         * roomLat : 23.000000
         * roomLng : 113.00000000
         */

        private String roomSquare;
        private String roomMoney;
        private String roomNumber;
        private int roomStatus;
        private String roomReviewTimes;
        private boolean roomHave360;
        private String roomSet;
        private String roomID;
        private String roomSimpleImage;
        private int roomMarginType;
        private String roomStyle;
        private String roomBuildingID;
        private String roomLat;
        private String roomLng;
        private List<RoomMoreImageArrBean> roomMoreImageArr;

        public String getRoomSquare() {
            return roomSquare;
        }

        public void setRoomSquare(String roomSquare) {
            this.roomSquare = roomSquare;
        }

        public String getRoomMoney() {
            return roomMoney;
        }

        public void setRoomMoney(String roomMoney) {
            this.roomMoney = roomMoney;
        }

        public String getRoomNumber() {
            return roomNumber;
        }

        public void setRoomNumber(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public int getRoomStatus() {
            return roomStatus;
        }

        public void setRoomStatus(int roomStatus) {
            this.roomStatus = roomStatus;
        }

        public String getRoomReviewTimes() {
            return roomReviewTimes;
        }

        public void setRoomReviewTimes(String roomReviewTimes) {
            this.roomReviewTimes = roomReviewTimes;
        }

        public boolean isRoomHave360() {
            return roomHave360;
        }

        public void setRoomHave360(boolean roomHave360) {
            this.roomHave360 = roomHave360;
        }

        public String getRoomSet() {
            return roomSet;
        }

        public void setRoomSet(String roomSet) {
            this.roomSet = roomSet;
        }

        public String getRoomID() {
            return roomID;
        }

        public void setRoomID(String roomID) {
            this.roomID = roomID;
        }

        public String getRoomSimpleImage() {
            return roomSimpleImage;
        }

        public void setRoomSimpleImage(String roomSimpleImage) {
            this.roomSimpleImage = roomSimpleImage;
        }

        public int getRoomMarginType() {
            return roomMarginType;
        }

        public void setRoomMarginType(int roomMarginType) {
            this.roomMarginType = roomMarginType;
        }

        public String getRoomStyle() {
            return roomStyle;
        }

        public void setRoomStyle(String roomStyle) {
            this.roomStyle = roomStyle;
        }

        public String getRoomBuildingID() {
            return roomBuildingID;
        }

        public void setRoomBuildingID(String roomBuildingID) {
            this.roomBuildingID = roomBuildingID;
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

        public List<RoomMoreImageArrBean> getRoomMoreImageArr() {
            return roomMoreImageArr;
        }

        public void setRoomMoreImageArr(List<RoomMoreImageArrBean> roomMoreImageArr) {
            this.roomMoreImageArr = roomMoreImageArr;
        }

        public static class RoomMoreImageArrBean {
            /**
             * imageTitle : 房间全景照
             * imageInfo : 房间非常舒适
             * imageFullView : 1
             * imageUrl : https://theta360cn.com/cn/gallery/img/v_04.jpg
             */

            private String imageTitle;
            private String imageInfo;
            private String imageFullView;
            private String imageUrl;

            public String getImageTitle() {
                return imageTitle;
            }

            public void setImageTitle(String imageTitle) {
                this.imageTitle = imageTitle;
            }

            public String getImageInfo() {
                return imageInfo;
            }

            public void setImageInfo(String imageInfo) {
                this.imageInfo = imageInfo;
            }

            public String getImageFullView() {
                return imageFullView;
            }

            public void setImageFullView(String imageFullView) {
                this.imageFullView = imageFullView;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }
        }

}

}
