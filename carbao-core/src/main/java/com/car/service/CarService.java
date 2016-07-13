package com.car.service;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.entity.Car;
import com.car.entity.User;

/**
 * CarService
 *
 * @author Bruce01.fan
 * @date 16/7/13
 */
public interface CarService extends BaseService<Car, Long> {

    public boolean saveCarInfo(User user, Car car);
}
