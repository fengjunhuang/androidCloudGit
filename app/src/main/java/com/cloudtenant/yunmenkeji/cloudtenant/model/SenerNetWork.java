package com.cloudtenant.yunmenkeji.cloudtenant.model;

import java.util.List;

/**
 * Created by Administrator on 2019/1/31 0031.
 */

public class SenerNetWork extends BaseBean {


    /**
     * message : 获取成功
     * result : true
     * viewData : [{"cycleDate":"每天","endTime":"23:59","ids":"e6defc4d-d9cb-481c-9ddd-2f5b2a812700","modeName":"安全模式","sensorIds":"xr4gst3xyi2030","startTime":"00:00","status":1}]
     */


    private List<ViewDataBean> viewData;



    public List<ViewDataBean> getViewData() {
        return viewData;
    }

    public void setViewData(List<ViewDataBean> viewData) {
        this.viewData = viewData;
    }

    public static class ViewDataBean {
        /**
         * cycleDate : 每天
         * endTime : 23:59
         * ids : e6defc4d-d9cb-481c-9ddd-2f5b2a812700
         * modeName : 安全模式
         * sensorIds : xr4gst3xyi2030
         * startTime : 00:00
         * status : 1
         */

        private String cycleDate;
        private String endTime;
        private String ids;
        private String modeName;
        private String sensorIds;
        private String startTime;
        private int status;

        public String getCycleDate() {
            return cycleDate;
        }

        public void setCycleDate(String cycleDate) {
            this.cycleDate = cycleDate;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getIds() {
            return ids;
        }

        public void setIds(String ids) {
            this.ids = ids;
        }

        public String getModeName() {
            return modeName;
        }

        public void setModeName(String modeName) {
            this.modeName = modeName;
        }

        public String getSensorIds() {
            return sensorIds;
        }

        public void setSensorIds(String sensorIds) {
            this.sensorIds = sensorIds;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
