package com.car.entity;

import com.car.interceptor.Page;
import com.car.interceptor.PageModel;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class User extends PageModel implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3078192062854906539L;
    // Fields

    private long userId;

    private String userName;

    private String nickName;

    private String password;

    private String faceUrl;

    /** 1-车主 2-驾驶员 */
    private int userType;

    private long carOwner;

    private String driveNumber;

    private String mobile;

    private String openId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFaceUrl() {
        return faceUrl;
    }

    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public long getCarOwner() {
        return carOwner;
    }

    public void setCarOwner(long carOwner) {
        this.carOwner = carOwner;
    }

    public String getDriveNumber() {
        return driveNumber;
    }

    public void setDriveNumber(String driveNumber) {
        this.driveNumber = driveNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}