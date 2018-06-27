package com.cloudtenant.yunmenkeji.cloudtenant.model;

import com.alibaba.fastjson.JSON;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by 72984 on 2018/6/17.
 */

public class HouseDetil extends BaseBean {


    /**
     * id : 11
     * maxPage : 1
     * bannerData : [{"bannerImage":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG","bannerID":"123","bannerTitle":"11111","bannerURL":"https://github.com/crazypoo"},{"bannerImage":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG","bannerID":"123","bannerTitle":"11111","bannerURL":"https://github.com/crazypoo"},{"bannerImage":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG","bannerID":"123","bannerTitle":"11111","bannerURL":"https://github.com/crazypoo"},{"bannerImage":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG","bannerID":"123","bannerTitle":"11111","bannerURL":"https://github.com/crazypoo"},{"bannerImage":"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1526407090184&di=1d19ac1630e7ce00901224415cc8083e&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F01c2e05777054e0000012e7eceda20.jpg%401280w_1l_2o_100sh.jpg","bannerID":"1234","bannerTitle":"55555","bannerURL":"www.qq.com"}]
     * viewData : [{"cellImage":"http://img.zcool.cn/community/0126825548ff270000019ae99b6ff7.jpg@1280w_1l_2o_100sh.jpg","cellName":"明珠公寓","cellRemain":"3","cellCost":"280","cellBuildID":"998","cellAddress":"东圃明珠新村5号","cellBuildingSet":"阳光好,临近地铁5号线,带空调热水器","cellLatitude":"23.115524","cellLongitude":"113.398527"},{"cellImage":"http://i8.qhmsg.com/t010aaa74de6a3c8c69.jpg","cellName":"东圃穗东之家","cellRemain":"3","cellCost":"380","cellBuildID":"998","cellAddress":"东圃明珠新村78号","cellBuildingSet":"阳光好,临近地铁1号线,带空调热水器","cellLatitude":"23.112793","cellLongitude":"113.398591"},{"cellImage":"http://dk.sun0769.com/uploads/allimg/oldarticlepic/2010111105431810.jpg","cellName":"碧豪公寓","cellRemain":"3","cellCost":"999","cellBuildID":"998","cellAddress":"东圃明珠新村135号","cellBuildingSet":"阳光好,临近地铁3号线,带空调热水器","cellLatitude":"23.112258","cellLongitude":"113.398004"},{"cellImage":"http://news.hqcr.com/UploadFile/2013/9/20130912150556219.jpg","cellName":"广厦公寓","cellRemain":"3","cellCost":"480","cellBuildID":"998","cellAddress":"东圃明珠新村235号","cellBuildingSet":"阳光好,临近地铁4号线,带空调热水器","cellLatitude":"23.111946","cellLongitude":"113.398610"},{"cellImage":"http://whimg.focus.cn/images/effect120877_1181265041.jpg","cellName":"人和公寓","cellRemain":"3","cellCost":"280","cellBuildID":"998","cellAddress":"东圃明珠新村335号","cellBuildingSet":"阳光好,临近地铁6号线,带空调热水器","cellLatitude":"23.112737","cellLongitude":"113.398231"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"岑铭公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"岑村村南大马路5号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.162806","cellLongitude":"113.378262"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"自在之家","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"岑村大马路78号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.164310","cellLongitude":"113.378312"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"文豪公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"岑村东大街135号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.164633","cellLongitude":"113.381289"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"安寨公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"岑村中区235号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.164347","cellLongitude":"113.377754"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"致和公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"岑村北区335号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.166695","cellLongitude":"113.381115"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"黄晟公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"黄村村南大马路5号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.126222","cellLongitude":"113.413601"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"我行我住","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"黄村大马路78号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.123804","cellLongitude":"113.378262"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"豪杰公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"黄村东大街135号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.124297","cellLongitude":"113.416111"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"安家公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"黄村中区235号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.123202","cellLongitude":"113.414952"},{"cellImage":"http://images4.c-ctrip.com/target/hotel/108000/107617/C78F2F6C-C0DC-49AC-8E28-5A306E3FE9B8_550_412.jpg","cellName":"文华公寓","cellRemain":"3","cellCost":"180","cellBuildID":"998","cellAddress":"黄村北区335号","cellBuildingSet":"阳光好,临近地铁8号线,带空调热水器","cellLatitude":"23.126383","cellLongitude":"113.416028"}]
     */

    private String id;
    private String maxPage;
    private List<BannerDataBean> bannerData;

    private List<ViewDataBean> viewDataX;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public List<ViewDataBean> getViewDataX() throws Exception {

        return  JSON.parseArray(getViewData(),ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
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
         * cellName : 明珠公寓
         * cellRemain : 3
         * cellCost : 280
         * cellBuildID : 998
         * cellAddress : 东圃明珠新村5号
         * cellBuildingSet : 阳光好,临近地铁5号线,带空调热水器
         * cellLatitude : 23.115524
         * cellLongitude : 113.398527
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
