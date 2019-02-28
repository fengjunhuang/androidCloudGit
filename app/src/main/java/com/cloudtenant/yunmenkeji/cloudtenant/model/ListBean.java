package com.cloudtenant.yunmenkeji.cloudtenant.model;

/**
 * Created by 72984 on 2018/7/23.
 */

public class ListBean {
    private String page;
    private String row;
    private String longitdue;
    private String latitude;
    private String landingPhone;
    private String isLogin;
    private String areNames;
    private String omit;
    private String city;
    private String town;
    private String minPrice;
    private String maxPrice;
    private String houseConfigNote;
    private String depositType;
    private String score;

    public ListBean(String page, String row, String longitdue, String latitude, String landingPhone, String areNames, String omit, String city, String town, String minPrice, String maxPrice, String houseConfigNote, String depositType, String score, String isLogin) {
        this.page = page;
        this.row = row;
        this.longitdue = longitdue;
        this.latitude = latitude;
        this.landingPhone = landingPhone;
        this.areNames = areNames;
        this.omit = omit;
        this.city = city;
        this.town = town;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.houseConfigNote = houseConfigNote;
        this.depositType = depositType;
        this.score = score;
        this.isLogin = isLogin;
    }

    public String getPage() {

        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getLongitdue() {
        return longitdue;
    }

    public void setLongitdue(String longitdue) {
        this.longitdue = longitdue;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLandingPhone() {
        return landingPhone;
    }

    public void setLandingPhone(String landingPhone) {
        this.landingPhone = landingPhone;
    }

    public String getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(String isLogin) {
        this.isLogin = isLogin;
    }

    public String getAreNames() {
        return areNames;
    }

    public void setAreNames(String areNames) {
        this.areNames = areNames;
    }

    public String getOmit() {
        return omit;
    }

    public void setOmit(String omit) {
        this.omit = omit;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getHouseConfigNote() {
        return houseConfigNote;
    }

    public void setHouseConfigNote(String houseConfigNote) {
        this.houseConfigNote = houseConfigNote;
    }

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
