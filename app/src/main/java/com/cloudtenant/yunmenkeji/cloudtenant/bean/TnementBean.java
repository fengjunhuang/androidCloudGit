package com.cloudtenant.yunmenkeji.cloudtenant.bean;

import java.io.Serializable;
import java.util.List;

public class TnementBean implements Serializable {
    private String cellImage;
    private String cellName;
    private String cellRemain;
    private String cellCost;
    private String cellBuildID;
    private String cellAddress;
    private String cellBuildingSet;
    private String cellLatitude;
    private String cellLongitude;
    private String roomSquare;
    private String roomMoney;


    private String contract;

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    private String roomNumber;
    private int roomStatus;
    private boolean roomHave360;
    private String roomReviewTimes;
    private String roomSet;
    private String roomID;
    private String roomSimpleImage;
    private int roomMarginType;
    private String roomStyle;
    private String roomBuildingID;
    private String roomLat;
    private String roomLng;
    private List<RoomMoreImageArrBean> roomMoreImageArr;

    public TnementBean() {
    }

    public String getCellImage() {
        return cellImage;
    }

    public String getCellName() {
        return cellName;
    }

    public void setCellImage(String cellImage) {
        this.cellImage = cellImage;
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
}
