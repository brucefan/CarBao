package com.car.entity;/**
 * Created by fanguiming on 16/7/10.
 */

import com.car.interceptor.PageModel;

/**
 * Car
 *
 * @author Bruce01.fan
 * @date 16/7/10
 */
public class Car extends PageModel implements java.io.Serializable {

    private long carId;

    /**
     * 车主id
     */
    private long ownerId;

    /**
     * 牌照省份
     */
    private String licenseProvince;

    /**
     * 车牌号
     */
    private String plateNumber;

    /**
     * 车系
     */
    private String carSeries;

    /**
     * 发动机号
     */
    private String engineNumber;

    /**
     * 车架号
     */
    private String carVin;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getLicenseProvince() {
        return licenseProvince;
    }

    public void setLicenseProvince(String licenseProvince) {
        this.licenseProvince = licenseProvince;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getCarSeries() {
        return carSeries;
    }

    public void setCarSeries(String carSeries) {
        this.carSeries = carSeries;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getCarVin() {
        return carVin;
    }

    public void setCarVin(String carVin) {
        this.carVin = carVin;
    }
}
