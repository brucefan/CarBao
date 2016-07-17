package com.car.dao;/**
 * Created by fanguiming on 16/7/9.
 */

import com.car.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * UserDao
 *
 * @author Bruce01.fan
 * @date 16/7/9
 */
@Repository
public interface UserDao extends BaseDao {

    public User queryUserByName(String name);
}
