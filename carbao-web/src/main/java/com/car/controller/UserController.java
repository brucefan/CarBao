package com.car.controller;/**
 * Created by fanguiming on 16/7/9.
 */

import com.car.consts.UserType;
import com.car.entity.User;
import com.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import sun.security.provider.MD5;

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
                              @RequestParam(value = "password", required = true) String password) {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }
}
