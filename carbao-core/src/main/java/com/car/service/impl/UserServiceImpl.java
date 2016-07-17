package com.car.service.impl;

import com.car.dao.UserDao;
import com.car.entity.User;
import com.car.interceptor.Pagination;
import com.car.mapper.UserMapper;
import com.car.service.UserService;
import com.car.vo.RestResult;
import com.car.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaserServiceImpl<User, Long> implements UserService {
    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void setBaseDao() {
        this.setBaseDao(userDao);
    }

    @Override
    public RestResult login(String userName, String password) {

        RestResult restResult = null;
        User user = userDao.queryUserByName(userName);

        if (user == null || !user.getPassword().equalsIgnoreCase(password)) {
            restResult = new RestResult(RestResult.FAILED_CODE, "用户账号名或密码不正确");
        } else {
            restResult = new RestResult(user);
        }

        return restResult;
    }
}
