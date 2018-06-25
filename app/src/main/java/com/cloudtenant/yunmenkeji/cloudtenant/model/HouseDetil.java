package com.cloudtenant.yunmenkeji.cloudtenant.model;

import java.util.List;

/**
 * Created by 72984 on 2018/6/17.
 */

public class HouseDetil extends BaseBean {


    /**
     * maxPage : 1
     * bannerData : [{"bannerImage":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG","bannerID":"123","bannerTitle":"11111","bannerURL":"https://github.com/crazypoo"}]
     * viewData : [{"cellImage":"http://img.zcool.cn/community/0126825548ff270000019ae99b6ff7.jpg@1280w_1l_2o_100sh.jpg","cellName":"东圃镇明珠新村","cellRemain":"3","cellCost":"280","cellBuildID":"998","cellAddress":"东圃大马路6号","cellBuildingSet":"阳光好,临近地铁5号线,带空调热水器","cellLatitude":"23.118937","cellLongitude":"113.363266"}]
     */

    private String maxPage;
    private List<BannerDataBean> bannerData;
    private List<ViewDataBean> viewData;

    public String getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(String maxPage) {
        this.maxPage = maxPage;
    }

    public List<BannerDataBean> getBannerData() {
        return bannerData;
    }

    public void setBannerData(List<BannerDataBean> bannerData) {
        this.bannerData = bannerData;
    }

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class BannerDataBean {
        /**
         * bannerImage : http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG
         * bannerID : 123
         * bannerTitle : 11111
         * bannerURL : https://github.com/crazypoo
         */

        private String bannerImage;
        private String bannerID;
        private String bannerTitle;
        private String bannerURL;

        public String getBannerImage() {
            return bannerImage;
        }

        public void setBannerImage(String bannerImage) {
            this.bannerImage = bannerImage;
        }

        public String getBannerID() {
            return bannerID;
        }

        public void setBannerID(String bannerID) {
            this.bannerID = bannerID;
        }

        public String getBannerTitle() {
            return bannerTitle;
        }

        public void setBannerTitle(String bannerTitle) {
            this.bannerTitle = bannerTitle;
        }

        public String getBannerURL() {
            return bannerURL;
        }

        public void setBannerURL(String bannerURL) {
            this.bannerURL = bannerURL;
        }
    }

    public static class ViewDataBean {
        /**
         * cellImage : http://img.zcool.cn/community/0126825548ff270000019ae99b6ff7.jpg@1280w_1l_2o_100sh.jpg
         * cellName : 东圃镇明珠新村
         * cellRemain : 3
         * cellCost : 280
         * cellBuildID : 998
         * cellAddress : 东圃大马路6号
         * cellBuildingSet : 阳光好,临近地铁5号线,带空调热水器
         * cellLatitude : 23.118937
         * cellLongitude : 113.363266
         */

        private String cellImage;
        private String cellName;
        private String cellRemain;
        private String cellCost;
        private String cellBuildID;
        private String cellAddress;
        private String cellBuildingSet;
        private String cellLatitude;
        private String cellLongitude;

        public String getCellImage() {
            return cellImage;
        }

        public void setCellImage(String cellImage) {
            this.cellImage = cellImage;
        }

        public String getCellName() {
            return cellName;
        }

        public void setCellName(String cellName) {
            this.cellName = cellName;
        }

        public String getCellRemain() {
            return cellRemain;
        }

        public void setCellRemain(String cellRemain) {
            this.cellRemain = cellRemain;
        }

        public String getCellCost() {
            return cellCost;
        }

        public void setCellCost(String cellCost) {
            this.cellCost = cellCost;
        }

        public String getCellBuildID() {
            return cellBuildID;
        }

        public void setCellBuildID(String cellBuildID) {
            this.cellBuildID = cellBuildID;
        }

        public String getCellAddress() {
            return cellAddress;
        }

        public void setCellAddress(String cellAddress) {
            this.cellAddress = cellAddress;
        }

        public String getCellBuildingSet() {
            return cellBuildingSet;
        }

        public void setCellBuildingSet(String cellBuildingSet) {
            this.cellBuildingSet = cellBuildingSet;
        }

        public String getCellLatitude() {
            return cellLatitude;
        }

        public void setCellLatitude(String cellLatitude) {
            this.cellLatitude = cellLatitude;
        }

        public String getCellLongitude() {
            return cellLongitude;
        }

        public void setCellLongitude(String cellLongitude) {
            this.cellLongitude = cellLongitude;
        }
    }
}
