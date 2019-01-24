package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class MyFamily extends BaseBean {


    /**
     * resule : true
     * viewData : [{"isAdmin":"true","roomId":"er4FoYFG","roomName":"越秀·滨海新城 203"},{"isAdmin":"true","roomId":"kAO3fFd7","roomName":"越秀·滨海新城 201"},{"isAdmin":"true","roomId":"sy5nwWYn","roomName":"碧桂园玺悦 102"},{"isAdmin":"true","roomId":"fp7fu5Dg","roomName":"三江盛汇 102"},{"isAdmin":"true","roomId":"NfRoE46A","roomName":"碧桂园玺悦 101"},{"isAdmin":"true","roomId":"sy5nwWYn","roomName":"碧桂园玺悦 102"},{"isAdmin":"true","roomId":"0MRRxnY2","roomName":"碧桂园玺悦 103"},{"isAdmin":"true","roomId":"uq5P7nSe","roomName":"碧桂园玺悦 104"},{"isAdmin":"true","roomId":"S5nu26ze","roomName":"碧桂园玺悦 201"},{"isAdmin":"true","roomId":"3XYrh9eF","roomName":"碧桂园玺悦 202"},{"isAdmin":"true","roomId":"QvVP5OgE","roomName":"碧桂园玺悦 203"},{"isAdmin":"true","roomId":"u6U8Dy8o","roomName":"碧桂园玺悦 204"},{"isAdmin":"true","roomId":"Zs1QpCTV","roomName":"三江盛汇 103"},{"isAdmin":"true","roomId":"ynfuJLR8","roomName":"三江盛汇 104"},{"isAdmin":"true","roomId":"x8n2xNDW","roomName":"三江盛汇 105"},{"isAdmin":"true","roomId":"sm2F8gEw","roomName":"三江盛汇 201"},{"isAdmin":"true","roomId":"cvyRn2v1","roomName":"三江盛汇 202"},{"isAdmin":"true","roomId":"hyauAaWI","roomName":"三江盛汇 203"},{"isAdmin":"true","roomId":"PH872aAh","roomName":"碧桂园玺悦二期101"},{"isAdmin":"true","roomId":"gvy7vXSB","roomName":"越秀·滨海新城 1001"},{"isAdmin":"true","roomId":"DCZvQP5W","roomName":"越秀·滨海新城 1002"},{"isAdmin":"true","roomId":"sCXQLX95","roomName":"越秀·滨海新城 1003"},{"isAdmin":"true","roomId":"kAUJQ1hj","roomName":"越秀·滨海新城 1004"},{"isAdmin":"true","roomId":"ZOSDpmPP","roomName":"越秀·滨海新城 1005"},{"isAdmin":"true","roomId":"0C4v1mHC","roomName":"越秀·滨海新城 1006"},{"isAdmin":"true","roomId":"yzoc1LAO","roomName":"越秀·滨海新城 1007"},{"isAdmin":"true","roomId":"3gZxTNvS","roomName":"安合花园 101"},{"isAdmin":"true","roomId":"zF84okYH","roomName":"安合花园 102"},{"isAdmin":"true","roomId":"K7sregZ0","roomName":"三江盛汇 301"},{"isAdmin":"true","roomId":"LaCeulg2","roomName":"碧桂园玺悦 301"},{"isAdmin":"true","roomId":"LaCeulg2","roomName":"碧桂园玺悦 301"},{"isAdmin":"true","roomId":"QsWSPOqo","roomName":"三江盛汇 205"},{"isAdmin":"true","roomId":"qOyQl0cD","roomName":"三江盛汇 302"},{"isAdmin":"true","roomId":"b2vzq1eP","roomName":"三江盛汇 304"},{"isAdmin":"true","roomId":"4QxlBGSc","roomName":"三江盛汇 305"},{"isAdmin":"true","roomId":"lsIU6pok","roomName":"三江盛汇 401"},{"isAdmin":"true","roomId":"AbnRZebs","roomName":"三江盛汇 402"},{"isAdmin":"true","roomId":"PtUNzEfM","roomName":"绿地越秀·海玥101"},{"isAdmin":"true","roomId":"rCsSW3ND","roomName":"港航中心101"},{"isAdmin":"true","roomId":"bUAq4lRb","roomName":"碧桂园玺悦二期102"},{"isAdmin":"true","roomId":"BAABrdCp","roomName":"绿地越秀·海玥102"},{"isAdmin":"true","roomId":"yOqe5Di2","roomName":"金融街·花溪小镇102"},{"isAdmin":"true","roomId":"0EwLBZLW","roomName":"绿地越秀·海玥103"},{"isAdmin":"true","roomId":"0EwLBZLW","roomName":"绿地越秀·海玥103"},{"isAdmin":"true","roomId":"qhHm3qUn","roomName":"绿地越秀·海玥104"},{"isAdmin":"true","roomId":"qhHm3qUn","roomName":"绿地越秀·海玥104"},{"isAdmin":"true","roomId":"1j4vnwIO","roomName":"绿地越秀·海玥201"}]
     */

    private String resule;
    private List<ViewDataBean> viewData;

    public String getResule() {
        return resule;
    }

    public void setResule(String resule) {
        this.resule = resule;
    }

    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean {
        /**
         * isAdmin : true
         * roomId : er4FoYFG
         * roomName : 越秀·滨海新城 203
         */

        private String isAdmin;
        private String roomId;
        private String roomName;

        public String getIsAdmin() {
            return isAdmin;
        }

        public void setIsAdmin(String isAdmin) {
            this.isAdmin = isAdmin;
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }
    }
}
