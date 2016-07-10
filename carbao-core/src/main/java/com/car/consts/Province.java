package com.car.consts;/**
 * Created by fanguiming on 16/7/10.
 */

/**
 * Province
 *
 * @author Bruce01.fan
 * @date 16/7/10
 */
public enum Province {

    JING("京"),
    HU("沪"),
    ZHE("浙"),
    SU("苏"),
    YUE("粤");

    private String name;

    private Province(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
