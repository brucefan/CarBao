package com.car.controller;/**
 * Created by fanguiming on 16/7/9.
 */

import com.car.consts.UserType;
import com.car.entity.Car;
import com.car.entity.User;
import com.car.service.CarService;
import com.car.service.UserService;
import com.car.vo.RestResult;
import com.car.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;

/**
 * UserController
 *
 * @author Bruce01.fan
 * @date 16/7/9
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/enterRegister", method = RequestMethod.GET)
    public ModelAndView enterRegister() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        mav.addObject("userTypes", UserType.values());

        return mav;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(
            @RequestParam(value = "userName", required = true) String userName,
            @RequestParam(value = "userType", required = true) Integer userType,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "mobile", required = true) String mobile

    ) {

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setMobile(mobile);
        user.setUserType(userType);

        userService.add(user);

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "userName", required = true) String userName,
                              @RequestParam(value = "password", required = true) String password,
                              HttpServletRequest request) {

        ModelAndView mav = new ModelAndView();

        RestResult restResult = userService.login(userName, password);

        // 保存到session
        if (restResult.getCode() == RestResult.SUCCESS_CODE) {
            User user = (User) restResult.getData();
            // 根据userId查询车辆信息
            Car param = new Car();
            param.setOwnerId(user.getUserId());
            Car car = carService.queryCarByParams(param);

            request.getSession().setAttribute("user", user);
            mav.addObject("userId", user.getUserId());
            mav.addObject("userType", user.getUserType());
            if (car != null) {
                mav.addObject("carId", car.getCarId());
            }
        }

        mav.setViewName("home");

        return mav;
    }

    /**
     * 获取车主列表
     *
     * @param nickName
     * @return
     */
    @RequestMapping(value = "/carOwners/get", method = RequestMethod.POST)
    @ResponseBody
    public RestResult getUsers(@RequestParam(value = "nickName", required = true) String nickName) {

        return null;
    }

    @RequestMapping(value = "/userInfo/enter", method = RequestMethod.GET)
    public ModelAndView enterUserInfo(@RequestParam(value = "userId", required = true) Long userId) {
        ModelAndView mav = new ModelAndView();
        User user = userService.findById(userId);
        if (user != null) {
            mav.addObject("user", user);
        } else {
            mav.addObject("errMsg", "用户不存在");
        }

        mav.setViewName("/user/userinfo");
        return mav;
    }

    /**
     * 完善个人信息
     *
     * @return
     */
    @RequestMapping(value = "/userInfo/upgrade", method = RequestMethod.POST)
    public ModelAndView upgradeUserInfo(@RequestParam(value = "userId", required = true) Long userId,
                                        @RequestParam(value = "nickName", required = true) String nickName,
                                        @RequestParam(value = "driveNumber", required = true) String driveNumber,
                                        @RequestParam(value = "userType", required = true) Integer userType,
                                        @RequestParam(value = "carOwner", required = false) Long carOwner,
                                        @RequestParam(value = "mobile", required = true) String mobile) {

        ModelAndView mav = new ModelAndView();

        User updateUser = new User();
        updateUser.setUserId(userId);
        updateUser.setNickName(nickName);
        updateUser.setDriveNumber(driveNumber);

        if (userType == UserType.CAR_DRIVER.getType()) {
            updateUser.setCarOwner(carOwner);
        }
        updateUser.setMobile(mobile);

        userService.update(updateUser);

        mav.setViewName("home");
        mav.addObject("userId", userId);

        return mav;
    }



}
