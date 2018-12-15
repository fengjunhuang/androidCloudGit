package com.cloudtenant.yunmenkeji.cloudtenant.model;


import java.util.List;

/**
 * Created by 72984 on 2018/6/17.
 */

public class HouseDetil1 extends BaseBean {


    /**
     * bannerData : [{"bannerID":"123","bannerImage":"http://image1.admaimai.com/UpLoadFiles/commendImages/2047/6dd2cce6-425d-4be7-ba89-0e4bce6a73f2.jpg","bannerTitle":"","bannerURL":"www.baidu.com"},{"bannerID":"123","bannerImage":"http://image1.admaimai.com/UpLoadFiles/commendImages/2047/23886d04-bf7b-4814-9cbe-43da213ab748.jpg","bannerTitle":"","bannerURL":"www.baidu.com"}]
     * maxPage : 1.0
     */

    private String maxPage;
    private List<BannerDataBean> bannerData;

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

    public static class BannerDataBean {
        /**
         * bannerID : 123
         * bannerImage : http://image1.admaimai.com/UpLoadFiles/commendImages/2047/6dd2cce6-425d-4be7-ba89-0e4bce6a73f2.jpg
         * bannerTitle :
         * bannerURL : www.baidu.com
         */

        private String bannerID;
        private String bannerImage;
        private String bannerTitle;
        private String bannerURL;

        public String getBannerID() {
            return bannerID;
        }

        public void setBannerID(String bannerID) {
            this.bannerID = bannerID;
        }

        public String getBannerImage() {
            return bannerImage;
        }

        public void setBannerImage(String bannerImage) {
            this.bannerImage = bannerImage;
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
}
