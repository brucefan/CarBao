package com.car.service.impl;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.consts.UserType;
import com.car.dao.CarDao;
import com.car.entity.Car;
import com.car.entity.User;
import com.car.service.CarService;
import com.car.vo.RestResult;
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
    public RestResult saveCarInfo(User user, Car car) {

        Car param = new Car();
        param.setPlateNumber(car.getPlateNumber());
        param.setEngineNumber(car.getEngineNumber());

        Car carFromDb = carDao.selectCarByParams(param);

        RestResult restResult = null;
        if (car.getCarId() == null) {
            // 新增
            // 判断该车是不是已经被注册了
            if (carFromDb != null) {
                //  该车已经被人注册过
                restResult = new RestResult(RestResult.FAILED_CODE, "该车车架号或发动机号已被注册过");
                return restResult;
            }

            if (user.getUserType() == UserType.CAR_OWNER.getType()) {
                // 车主
                car.setOwnerId(user.getUserId());
                carDao.insert(car);
            }

        } else {

            // 更新
            if (carFromDb.getOwnerId() == user.getUserId()) {
                // 只有车主本身才能更新
                carDao.updateByPrimaryKey(car);
            }

        }

        restResult = new RestResult();
        return restResult;
    }

    @Override
    public Car queryCarByParams(Car params) {
        return carDao.selectCarByParams(params);
    }
}
