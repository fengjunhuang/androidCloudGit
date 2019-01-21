package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class MyFamily extends BaseBeanC {

    /**
     * id : 1
     * viewData : [{"familyID":"98989898","familyName":"家庭1","isAdmin":true,"roomName":"明珠新村6栋201"},{"familyID":"98333","familyName":"家庭2","isAdmin":false,"roomName":"明珠新村6栋201"}]
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
        return JSON.parseArray(getViewData(),MyFamily.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        /**
         * familyID : 98989898
         * familyName : 家庭1
         * isAdmin : true
         * roomName : 明珠新村6栋201
         */

        private String roomId;
        private boolean isAdmin;
        private String roomName;

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public boolean isAdmin() {
            return isAdmin;
        }

        public void setAdmin(boolean admin) {
            isAdmin = admin;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }
    }
}
