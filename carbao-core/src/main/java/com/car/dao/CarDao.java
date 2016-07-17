package com.car.dao;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.entity.Car;
import org.springframework.stereotype.Repository;

/**
 * CarDao
 *
 * @author Bruce01.fan
 * @date 16/7/13
 */
@Repository
public interface CarDao extends BaseDao {

    public Car selectCarByParams(Car params);
}
