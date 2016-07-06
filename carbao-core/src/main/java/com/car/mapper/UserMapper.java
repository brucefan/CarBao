package com.car.mapper;

import com.car.entity.User;

import java.util.List;

public interface UserMapper extends BaseMapper<User, Integer> {

    public User selectByParams(User params);

    public List<User> selectUserByPage(User params);

    public List<User> selectUserByType(String userType);

    List<User> selectFriendsByPage(User record);
}