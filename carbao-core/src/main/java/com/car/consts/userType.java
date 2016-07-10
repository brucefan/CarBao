package com.car.consts;/**
 * Created by fanguiming on 16/7/10.
 */

/**
 * userType
 *
 * @author Bruce01.fan
 * @date 16/7/10
 */
public enum UserType {

    CAR_OWNER(1, "车主"),
    CAR_DRIVER(2, "驾驶员");

    private int type;

    private String name;

    private UserType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
