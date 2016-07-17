package com.car.service;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.entity.Car;
import com.car.entity.User;
import com.car.vo.RestResult;

/**
 * CarService
 *
 * @author Bruce01.fan
 * @date 16/7/13
 */
public interface CarService extends BaseService<Car, Long> {

    public RestResult saveCarInfo(User user, Car car);

    public Car queryCarByParams(Car params);

}
