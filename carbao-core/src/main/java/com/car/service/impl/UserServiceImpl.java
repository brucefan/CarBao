package com.car.service.impl;

import com.car.entity.User;
import com.car.interceptor.Pagination;
import com.car.mapper.UserMapper;
import com.car.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl extends BaserServiceImpl<User, Integer> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @PostConstruct
    public void setBaseMapper() {
        this.setBaseMapper(userMapper);
    }

    public User phoneLogin(String phone, String userPwd) {
        User params = new User();
        params.setPhone(phone);
        params.setUserPwd(userPwd);
        return userMapper.selectByParams(params);
    }

    public User mailLogin(String mail, String userPwd) {
        User params = new User();
        params.setUserPwd(userPwd);
        params.setMail(mail);
        return userMapper.selectByParams(params);
    }

    public User userByName(String userName) {
        User params = new User();
        params.setUserName(userName);
        params.setType("byName");
        return userMapper.selectByParams(params);
    }

    public void setDefaultAddress(String userId, Integer id) {
        StringBuffer hql = new StringBuffer("update Userbyaddress u set u.status = 0 where u.userId='" + userId + "' and u.id <> '" + id + "'");
    }

    public void defaultAddress(String userId, Integer id) {
        StringBuffer hql = new StringBuffer("update Userbyaddress u set u.status = 1 where u.userId='" + userId + "' and u.id = '" + id + "'");
    }

    public User isUserName(String userName, String userId) {
        User params = new User();
        params.setUserName(userName);
        params.setUserId(Integer.parseInt(userId));
        params.setType("isName");
        return userMapper.selectByParams(params);
    }

    public List<User> loadAll() {
        User params = new User();
        params.setUserPwd("1ypg.com");
        return userMapper.selectUserByPage(params);
    }

    public User userByIsUserName(String userName) {
        User params = new User();
        params.setUserName(userName);
        return userMapper.selectByParams(params);
    }

    public List<User> getInvitedList(String userId, int pageNo, int pageSize) {
        User params = new User();
        params.setInvite(Integer.parseInt(userId));
        params.getPage().setPageNo(pageNo);
        params.getPage().setPageSize(pageSize);

        return userMapper.selectUserByPage(params);
    }

    public Integer getInvitedListByCount(String userId) {
        return null;
    }

    public List<User> getInvitedListByData(String userId) {
        User params = new User();
        params.setInvite(Integer.parseInt(userId));

        return userMapper.selectUserByPage(params);
    }

    public Pagination adminUserList(String typeId, String keyword, String orderName, int pageNo, int pageSize) {
        StringBuffer hql = new StringBuffer("select * from user u where  1=1 and u.userType = 0 and u.userPwd <> '1ypg.com' ");
        if (StringUtils.isNotBlank(typeId) && StringUtils.isNotBlank(keyword)) {
            if (typeId.equals("userId")) {
                hql.append(" and u.userId='" + keyword + "'");
            }
            if (typeId.equals("userName")) {
                hql.append(" and u.userName='" + keyword + "'");
            }
            if (typeId.equals("mail")) {
                hql.append(" and u.mail='" + keyword + "'");
            }
            if (typeId.equals("phone")) {
                hql.append(" and u.phone='" + keyword + "'");
            }
        }
        if (StringUtils.isNotBlank(orderName)) {
            hql.append(" order by u." + orderName + " desc");
        } else {
            hql.append(" order by u.oldDate desc");
        }
        StringBuffer sql = new StringBuffer("select count(*) from user u where  1=1 and u.userType = 0 and u.userPwd <> '1ypg.com' ");
        if (StringUtils.isNotBlank(typeId) && StringUtils.isNotBlank(keyword)) {
            if (typeId.equals("userId")) {
                sql.append(" and u.userId='" + keyword + "'");
            }
            if (typeId.equals("userName")) {
                sql.append(" and u.userName='" + keyword + "'");
            }
            if (typeId.equals("mail")) {
                sql.append(" and u.mail='" + keyword + "'");
            }
            if (typeId.equals("phone")) {
                sql.append(" and u.phone='" + keyword + "'");
            }
        }
        Pagination page = new Pagination();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        Map<String, Class> entityMap = new HashMap<String, Class>();
        entityMap.put("u", User.class);
        return page;
    }

    public Integer getCountUser() {
        StringBuffer sql = new StringBuffer("select count(*) from user");
        return null;
    }

    public User isNotOpenId(String openId) {
        User params = new User();
        params.setUserPwd(openId);
        return userMapper.selectByParams(params);
    }

    public List<User> getUserByType(String userType) {
        return userMapper.selectUserByType(userType);
    }

}
