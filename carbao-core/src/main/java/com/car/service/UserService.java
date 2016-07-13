package com.car.service;

import com.car.entity.User;
import com.car.interceptor.Pagination;
import com.car.vo.UserVO;

import java.util.List;

public interface UserService extends BaseService<User, Long> {

    public UserVO login(String userName, String password);

}
