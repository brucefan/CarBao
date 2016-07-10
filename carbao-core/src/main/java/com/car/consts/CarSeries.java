package com.car.consts;/**
 * Created by fanguiming on 16/7/10.
 */

/**
 * CarSeries
 *
 * @author Bruce01.fan
 * @date 16/7/10
 */
public enum CarSeries {

    A1_AODI("A1", "奥迪"),
    B1_BENTIAN("B1", "本田"),
    F1_FENGTIAN("F1", "丰田");

    private String seriesNo;

    private String seriesName;

    private CarSeries(String seriesNo, String seriesName) {
        this.seriesNo = seriesNo;
        this.seriesName = seriesName;
    }

    public String getSeriesNo() {
        return seriesNo;
    }

    public void setSeriesNo(String seriesNo) {
        this.seriesNo = seriesNo;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }
}
