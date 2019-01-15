package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;
import com.cloudtenant.yunmenkeji.cloudtenant.util.AESOperator;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 72984 on 2018/7/4.
 */

public class BudingInfo extends BaseBeanC{


    /**
     * id : 6
     * maxPage : 1
     * contract : 房屋租赁合同/n根据《中华人民共和国合同法》及国家有关法律、法规的规定，就出租方和承租方的权力和义务关系经双方协商一致达成协议如下。/n出租房坐落、面积、交付情况/n1.出租房位于：%@；/n出租房面积共%@平方米（建筑面积）；/n租赁期限、用途、交付时间/n2.租赁期共%@个月。自%@起至%@止；/n3.乙方向甲方承诺，租赁该第一条 出租房仅作为居住用途，保证该第一条 出租房不被利用进行违法活动。/n租金、押金及支付方式/n4.出租房的每月租金为%@元/n（大写%@元整）。/n房租押金：%@元/n5.乙方应于每月30日之前向甲方支付本月租金/n甲方收款后应提供给乙方收款凭证。/n6.在本合同租赁期内，月租金从第 2年起每 1年递增 50元。/n即：（1）自%@，每月租金为%@元；/n（2）自%@至%@，每月租金为%@元；/n7.乙方仅依据与甲方签订的双方租赁合同向甲方支付租赁费用，甲方对此不得以任何理由干涉或提出异议。/n租赁期间相关费用及税金/n8.甲方应承担的费用：租赁期间，出租房因土地使用权、所有权和甲方出租行为而产生的国家或地方规定的税收及费用（如产权税、房产（出租）税、所得税等）由甲方承担。如果发生政府有关部门征收与出租房有关的本合同中未列出的税费，应由甲方负担。/n出租房管理/n8.租赁期间出租房内统一由乙方单独进行管理，包括但不限于防火、防盗以及房内设施管理等；/n9.甲方有权监督、检查出租房的使用情况，如发现乙方违反本合同和法律法规使用出租房，甲方有权要求乙方限期整改，若乙方拒不整改甲方有权单方终止本合同，要求乙方限期搬离，甲方不退房租押金；/n出租房修缮与使用/n10.在租赁期内出租房及所属设施的维修由甲方负责；/n11.乙方提出对出租房进行维修须提前 拾伍 工作日书面通知对甲方，其维修应尽可能减少对乙方生活的影响。/n12.乙方通过甲方提出维修请求后，甲方应及时提供维修。/n13.乙方应合理使用出租房及其附属设施。如因使用不当造成出租房及设施损，乙方应负责修复或经济赔偿。/n出租房交付及收回的验收/n14.甲方保证出租房本身及附属设施、设备处于能够正常使用状态。/n15.出租房交付及收回验收时出租方和承租方应共同参与，如对主体结构、器物等硬件设施、设备有异议应当场提出。当场难以检测判断的，应于 拾 日内向对方主张。/n出租房的转让与转租/n16.租赁期间，甲方有权依照法定程序转让出租房，转让后本合同对新所有人和乙方继续有效。/n17.租赁期间，乙方无转租权。/n合同的变更、解除与终止/n18.未经双方书面同意，任何一方均不得变更、解除或终止本合同。/n19.甲方有以下行为之一的，乙方有权解除合同：/n（1）不能提供出租房或所提供出租房不符合约定条件，严重影响乙方生活居住的。/n（2）甲方未尽出租房修缮义务，严重影响乙方生活居住的。/n20.出租房租赁期间，乙方有下列行为之一的，甲方有权解除同乙方的租赁合同关系：/n（1）逾期未交纳按约定应当由乙方交纳的各项费用，已经给甲方造成严重损害的。/n（2）拖欠租金累计 壹 个月或以上。/n21.租赁期满前，各方均未书面明确提出不再续签本合同的，本合同自动续期%@个月。/n乙方违约责任/n租赁期间，乙方拖欠房租累计 壹 个月以上的，甲方有权按照本合同的约定终止同乙方的合同，乙方应按照本合同总租金的 50%向甲方支付违约金。若支付的违约金不足弥补甲方损失的，乙方还应负责赔偿直至达到弥补全部损失为止。/n在租赁期内，乙方逾期交纳本合同约定应由乙方负担的费用的，每逾期一天，则应按上述拖欠费用总额的万分之一/n支付甲方滞纳金。/n租赁期满，乙方应如期交还该出租房。乙方逾期归还，则每逾期一日应向甲方支付原日租金 贰 倍的滞纳金。乙方还应承担因逾期归还给甲方造成的损失。/n免责条款/n25.因不可抗力原因致使本合同不能继续履行、导致出租房毁损或造成其他损失，各方互不承担责任。不可抗力系指“不能预见、不能避免并不能克服的客观情况”，该等情况包括但不限于发生严重地震、台风、洪水等自然灾害、战争等。/n26.因国家政策需要拆除或改造出租房，或因政府有关租赁行为导致一方无法继续履行本协议及具体租赁合同，给其他方造成损失的，互不承担责任。/n27.遇有上述免责情况的一方，应立即用邮递或传真等书面方式通知对方，并应在三十日内，提供不可抗力及政府行为的详情及合同不能履行，或不能部分履行，或需延期履行理由的证明文件。该项证明文件应由不可抗力及政府行为发生地区的公证机关或政府出具，如无法获得公证出具的证明文件，则提供其他有力证明。遭受不可抗力及政府行为的一方由此而免责。/n31. 如果本合同的部分条款因违法、无效或不可执行时，其它非关联条款不得因此停止执行。/n32.本合同未尽事宜，甲方、乙方双方协商一致后可签订书面补充合同。/n33.本合同为电子合同，经乙方在本系统点击“确认签署”及支付本合同项下账单（租金及相应押金）后生效
     * viewData : [{"floor":"2","data":[{"roomSquare":"20","roomMoney":"850","roomNumber":"201","roomStatus":0,"roomHave360":true,"roomReviewTimes":"10","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG","roomMarginType":0,"roomStyle":"一房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"1","imageUrl":"https://theta360cn.com/cn/gallery/img/v_04.jpg"},{"imageTitle":"屋内环境照片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6B/v800x600_ChAFD1pjWsSADtIvAA5dAQdG5QU465.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"浴室配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6D/v800x600_ChAFD1pjXBeAHhzNABBYSCeS78Q079.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"20","roomMoney":"1350","roomNumber":"202","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG","roomMarginType":1,"roomStyle":"两房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG"},{"imageTitle":"屋内环境片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572279647-3.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572289859-4.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"20","roomMoney":"950","roomNumber":"203","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG","roomMarginType":1,"roomStyle":"两房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG"},{"imageTitle":"屋内环境片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572279647-3.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572289859-4.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"}]},{"floor":"3","data":[{"roomSquare":"30","roomMoney":"1000","roomNumber":"301","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/C9/BA/v800x600_ChAFfVr68tWAfSvHAAZvrEKIGUQ811.JPG","roomMarginType":0,"roomStyle":"两房一厅","roomMoreImageArr":[{"imageTitle":"屋内环境照片","imageInfo":"睡房配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/C9/BA/v800x600_ChAFfVr68sKAJa6JAAhls84lfnI581.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"睡房配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/C9/B2/v800x600_ChAFD1r68WiAaFvLAAhWxg_WBVs658.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"客厅配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/C9/BA/v800x600_ChAFfVr68tWAfSvHAAZvrEKIGUQ811.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"厨房配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/C9/B3/v800x600_ChAFD1r68amAZocTAAiYLlN7Bv8630.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"30","roomMoney":"1250","roomNumber":"302","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/C9/BA/v800x600_ChAFfVr68tWAfSvHAAZvrEKIGUQ811.JPG","roomMarginType":0,"roomStyle":"两房一厅","roomMoreImageArr":[],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"30","roomMoney":"1250","roomNumber":"303","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/C9/BA/v800x600_ChAFfVr68tWAfSvHAAZvrEKIGUQ811.JPG","roomMarginType":0,"roomStyle":"两房一厅","roomMoreImageArr":[],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"30","roomMoney":"950","roomNumber":"304","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/C9/BA/v800x600_ChAFfVr68tWAfSvHAAZvrEKIGUQ811.JPG","roomMarginType":0,"roomStyle":"两房一厅","roomMoreImageArr":[],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"}]}]
     */

    private String id;
    private String maxPage;
    private String contract;

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

    public String getContract() throws Exception {
        return AESOperator.getInstance().decrypt(contract);
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public List<ViewDataBean> getViewDataX() throws Exception {
      return   this.viewDataX = JSON.parseArray(getViewData(),BudingInfo.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) throws Exception {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean  implements Serializable {
        /**
         * floor : 2
         * data : [{"roomSquare":"20","roomMoney":"850","roomNumber":"201","roomStatus":0,"roomHave360":true,"roomReviewTimes":"10","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG","roomMarginType":0,"roomStyle":"一房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"1","imageUrl":"https://theta360cn.com/cn/gallery/img/v_04.jpg"},{"imageTitle":"屋内环境照片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/72/v800x600_ChAFfVpjW8SAVxlTAA4eIwfrEgI392.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6B/v800x600_ChAFD1pjWsSADtIvAA5dAQdG5QU465.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/74/v800x600_ChAFfVpjXS2AaxWXAA7iv6GMBmA527.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"浴室配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/house_images/g2/M00/FD/6D/v800x600_ChAFD1pjXBeAHhzNABBYSCeS78Q079.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"20","roomMoney":"1350","roomNumber":"202","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG","roomMarginType":1,"roomStyle":"两房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG"},{"imageTitle":"屋内环境片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572279647-3.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572289859-4.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"},{"roomSquare":"20","roomMoney":"950","roomNumber":"203","roomStatus":0,"roomHave360":false,"roomReviewTimes":"11","roomSet":"床 热水器 空调 宽带","roomID":"11","roomSimpleImage":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG","roomMarginType":1,"roomStyle":"两房一厅","roomMoreImageArr":[{"imageTitle":"房间全景照","imageInfo":"房间非常舒适","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572250793-1.JPG"},{"imageTitle":"屋内环境片","imageInfo":"房间","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572279647-3.JPG"},{"imageTitle":"屋内环境照片","imageInfo":"床屋内配置","imageFullView":"0","imageUrl":"http://pic.ziroom.com/apartment/upload/20161004/1475572289859-4.JPG"}],"roomBuildingID":"123123","roomLat":"23.000000","roomLng":"113.00000000"}]
         */

        private String floor;
        private List<DataBean> data;

        public String getFloor() {
            return floor;
        }

        public void setFloor(String floor) {
            this.floor = floor;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public  class DataBean implements  Serializable{
            @Override
            public String toString() {
                return "DataBean{" +
                        "roomSquare='" + roomSquare + '\'' +
                        ", roomMoney='" + roomMoney + '\'' +
                        ", roomNumber='" + roomNumber + '\'' +
                        ", roomStatus=" + roomStatus +
                        ", roomHave360=" + roomHave360 +
                        ", roomReviewTimes='" + roomReviewTimes + '\'' +
                        ", roomSet='" + roomSet + '\'' +
                        ", roomID='" + roomID + '\'' +
                        ", roomSimpleImage='" + roomSimpleImage + '\'' +
                        ", roomMarginType=" + roomMarginType +
                        ", roomStyle='" + roomStyle + '\'' +
                        ", roomBuildingID='" + roomBuildingID + '\'' +
                        ", roomLat='" + roomLat + '\'' +
                        ", roomLng='" + roomLng + '\'' +
                        ", roomMoreImageArr=" + roomMoreImageArr +
                        '}';
            }

            /**
             * roomSquare : 20
             * roomMoney : 850
             * roomNumber : 201
             * roomStatus : 0
             * isCollection : 0
             * roomHave360 : true
             * roomReviewTimes : 10
             * roomSet : 床 热水器 空调 宽带
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

            public String getIsCollection() {
                return isCollection;
            }

            public void setIsCollection(String isCollection) {
                this.isCollection = isCollection;
            }

            private String isCollection;
            private String roomNumber;
            private int roomStatus;
            private boolean roomHave360;
            private String roomReviewTimes;

            public String getRoomReadNum() {
                return roomReadNum;
            }

            public void setRoomReadNum(String roomReadNum) {
                this.roomReadNum = roomReadNum;
            }

            private String roomReadNum;
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

            public boolean isRoomHave360() {
                return roomHave360;
            }

            public void setRoomHave360(boolean roomHave360) {
                this.roomHave360 = roomHave360;
            }

            public String getRoomReviewTimes() {
                return roomReviewTimes;
            }

            public void setRoomReviewTimes(String roomReviewTimes) {
                this.roomReviewTimes = roomReviewTimes;
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

            public  class RoomMoreImageArrBean  implements Serializable {
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
}
