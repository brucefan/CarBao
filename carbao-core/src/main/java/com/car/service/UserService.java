package com.car.service;

import com.car.entity.User;
import com.car.interceptor.Pagination;

import java.util.List;

public interface UserService extends BaseService<User, Integer> {
    public User phoneLogin(String phone, String userPwd);

    public User mailLogin(String mail, String userPwd);

    public User userByName(String userName);

    public User userByIsUserName(String userName);

    public User isUserName(String userName, String userId);

    /**
     * 修改除id 外其它的地址为0
     *
     * @param userId
     * @param id
     */
    public void setDefaultAddress(String userId, Integer id);

    /**
     * 设置默认收货地址
     *
     * @param userId
     * @param id
     */
    public void defaultAddress(String userId, Integer id);


    public List<User> loadAll();

    /**
     * 获取邀请好友列表
     *
     * @param userId
     * @return
     */
    public List<User> getInvitedList(String userId, int pageNo, int pageSize);

    /**
     * 获取邀请好友列表统计数据
     *
     * @param userId
     * @return
     */
    public List<User> getInvitedListByData(String userId);

    /**
     * 获取邀请好友列表By Count
     *
     * @param userId
     * @return
     */
    public Integer getInvitedListByCount(String userId);

    /**
     * 会员列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Pagination adminUserList(String typeId, String keyword, String orderName, int pageNo, int pageSize);

    /**
     * 会员总数
     *
     * @return
     */
    public Integer getCountUser();

    /**
     * 判断是否已经存在OpenId
     *
     * @param openId
     * @return
     */
    public User isNotOpenId(String openId);

    public List<User> getUserByType(String userType);


}
