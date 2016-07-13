package com.car.service.impl;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.dao.CarDao;
import com.car.entity.Car;
import com.car.entity.User;
import com.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * CarServiceImpl
 *
 * @author Bruce01.fan
 * @date 16/7/13
 */
@Service
public class CarServiceImpl extends BaserServiceImpl<Car, Long> implements CarService {

    @Autowired
    private CarDao carDao;

    @PostConstruct
    public void setBaseDao() {
        this.setBaseDao(carDao);
    }


    @Override
    public boolean saveCarInfo(User user, Car car) {
        return false;
    }
}
