package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import com.alibaba.fastjson.JSON;
import com.cloudtenant.yunmenkeji.cloudtenant.model.BaseBean;

import java.util.List;

public class NoticeHistory extends BaseBean{


    /**
     * id : 4
     * viewData : [{"messageTime":"2019-09-16","messageInfo":"今晚送西瓜"},{"messageTime":"2019-09-16","messageInfo":"停电时间：2017-09-26 07:00\u20142017-09-26 20:00\n停电范围：龙潭街道办事处安化楼社区居委会广渠门内大街广渠门内大街6、8、12、甲14号、东城区二幼、幸福菜馆、三顺紫菜包饭、安婕妤、海王星辰药房、张老坎火锅、兰州拉面、链家、金之杰旅馆、金之杰理发、崇文日杂泵房、红房子菜馆、满天园饭店、京房国源房屋出租公司、换热站,龙潭街道办事处安化楼社区居委会安化北里安化北里2、3、4、5、6号\n停电时间：2017-09-27 07:00\u20142017-09-27 20:00\n停电范围：龙潭街道办事处安化楼社区居委会培新街培新街3号院\n停电时间：2017-09-27 22:00\u20142017-09-28 07:00\n停电范围：崇文门外街道办事处西花市南里西区社区居委会西花市大街朝丰达物业配电室"}]
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
        return JSON.parseArray(getViewData(),NoticeHistory.ViewDataBean.class);
    }

    public void setViewDataX(List<ViewDataBean> viewDataX) {
        this.viewDataX = viewDataX;
    }

    public static class ViewDataBean {
        /**
         * messageTime : 2019-09-16
         * messageInfo : 今晚送西瓜
         */

        private String messageTime;
        private String messageInfo;

        public String getMessageTime() {
            return messageTime;
        }

        public void setMessageTime(String messageTime) {
            this.messageTime = messageTime;
        }

        public String getMessageInfo() {
            return messageInfo;
        }

        public void setMessageInfo(String messageInfo) {
            this.messageInfo = messageInfo;
        }
    }
}
