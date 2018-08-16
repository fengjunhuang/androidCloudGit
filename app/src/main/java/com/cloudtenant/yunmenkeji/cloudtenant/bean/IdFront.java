package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import java.util.List;

public class IdFront {
    /**
     * errorcode : 0
     * errormsg : OK
     * session_id :
     * name_confidence_all : []
     * sex_confidence_all : []
     * nation_confidence_all : []
     * birth_confidence_all : []
     * address_confidence_all : []
     * id_confidence_all : []
     * frontimage_confidence_all : []
     * watermask_confidence_all : []
     * valid_date : 2014.05.05-2024.05.05
     * valid_date_confidence_all : [99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99,99]
     * authority : 揭阳市公安局揭东分局
     * authority_confidence_all : [100]
     * detail_errorcode : []
     * detail_errormsg : []
     */

    private int errorcode;
    private String errormsg;
    private String session_id;

    @Override
    public String toString() {
        return "IdFront{" +
                "errorcode=" + errorcode +
                ", errormsg='" + errormsg + '\'' +
                ", session_id='" + session_id + '\'' +
                ", valid_date='" + valid_date + '\'' +
                ", authority='" + authority + '\'' +
                ", valid_date_confidence_all=" + valid_date_confidence_all +
                ", authority_confidence_all=" + authority_confidence_all +
                '}';
    }

    private String valid_date;
    private String authority;
    private List<?> name_confidence_all;
    private List<?> sex_confidence_all;
    private List<?> nation_confidence_all;
    private List<?> birth_confidence_all;
    private List<?> address_confidence_all;
    private List<?> id_confidence_all;
    private List<?> frontimage_confidence_all;
    private List<?> watermask_confidence_all;
    private List<Integer> valid_date_confidence_all;
    private List<Integer> authority_confidence_all;
    private List<?> detail_errorcode;
    private List<?> detail_errormsg;

    public int getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(int errorcode) {
        this.errorcode = errorcode;
    }

    public String getErrormsg() {
        return errormsg;
    }

    public void setErrormsg(String errormsg) {
        this.errormsg = errormsg;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public String getValid_date() {
        return valid_date;
    }

    public void setValid_date(String valid_date) {
        this.valid_date = valid_date;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public List<?> getName_confidence_all() {
        return name_confidence_all;
    }

    public void setName_confidence_all(List<?> name_confidence_all) {
        this.name_confidence_all = name_confidence_all;
    }

    public List<?> getSex_confidence_all() {
        return sex_confidence_all;
    }

    public void setSex_confidence_all(List<?> sex_confidence_all) {
        this.sex_confidence_all = sex_confidence_all;
    }

    public List<?> getNation_confidence_all() {
        return nation_confidence_all;
    }

    public void setNation_confidence_all(List<?> nation_confidence_all) {
        this.nation_confidence_all = nation_confidence_all;
    }

    public List<?> getBirth_confidence_all() {
        return birth_confidence_all;
    }

    public void setBirth_confidence_all(List<?> birth_confidence_all) {
        this.birth_confidence_all = birth_confidence_all;
    }

    public List<?> getAddress_confidence_all() {
        return address_confidence_all;
    }

    public void setAddress_confidence_all(List<?> address_confidence_all) {
        this.address_confidence_all = address_confidence_all;
    }

    public List<?> getId_confidence_all() {
        return id_confidence_all;
    }

    public void setId_confidence_all(List<?> id_confidence_all) {
        this.id_confidence_all = id_confidence_all;
    }

    public List<?> getFrontimage_confidence_all() {
        return frontimage_confidence_all;
    }

    public void setFrontimage_confidence_all(List<?> frontimage_confidence_all) {
        this.frontimage_confidence_all = frontimage_confidence_all;
    }

    public List<?> getWatermask_confidence_all() {
        return watermask_confidence_all;
    }

    public void setWatermask_confidence_all(List<?> watermask_confidence_all) {
        this.watermask_confidence_all = watermask_confidence_all;
    }

    public List<Integer> getValid_date_confidence_all() {
        return valid_date_confidence_all;
    }

    public void setValid_date_confidence_all(List<Integer> valid_date_confidence_all) {
        this.valid_date_confidence_all = valid_date_confidence_all;
    }

    public List<Integer> getAuthority_confidence_all() {
        return authority_confidence_all;
    }

    public void setAuthority_confidence_all(List<Integer> authority_confidence_all) {
        this.authority_confidence_all = authority_confidence_all;
    }

    public List<?> getDetail_errorcode() {
        return detail_errorcode;
    }

    public void setDetail_errorcode(List<?> detail_errorcode) {
        this.detail_errorcode = detail_errorcode;
    }

    public List<?> getDetail_errormsg() {
        return detail_errormsg;
    }

    public void setDetail_errormsg(List<?> detail_errormsg) {
        this.detail_errormsg = detail_errormsg;
    }
}
