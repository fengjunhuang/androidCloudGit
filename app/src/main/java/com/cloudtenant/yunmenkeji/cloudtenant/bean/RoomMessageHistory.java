package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class RoomMessageHistory extends BaseBeanC{


    /**
     * id : 19
     * viewData : [{"historyTime":["2018-09-09 22:22:22","2018-09-09 22:22:22","2018-09-09 22:22:22"],"historyInfo":["着火了","有人进来了","没事了"],"historyStatus":["0","0","1"]}]
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
        return JSON.parseArray(getViewData(),RoomMessageHistory.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        private List<String> historyTime;
        private List<String> historyInfo;
        private List<String> historyStatus;

        public List<String> getHistoryTime() {
            return historyTime;
        }

        public void setHistoryTime(List<String> historyTime) {
            this.historyTime = historyTime;
        }

        public List<String> getHistoryInfo() {
            return historyInfo;
        }

        public void setHistoryInfo(List<String> historyInfo) {
            this.historyInfo = historyInfo;
        }

        public List<String> getHistoryStatus() {
            return historyStatus;
        }

        public void setHistoryStatus(List<String> historyStatus) {
            this.historyStatus = historyStatus;
        }
    }
}
