package com.car.service.impl;

import com.car.dao.UserDao;
import com.car.entity.User;
import com.car.interceptor.Pagination;
import com.car.mapper.UserMapper;
import com.car.service.UserService;
import com.car.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaserServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void setBaseDao() {
        this.setBaseDao(userDao);
    }

    @Override
    public UserVO login(String userName, String password) {

        return null;
    }
}
