package com.car.controller;/**
 * Created by fanguiming on 16/7/9.
 */

import com.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
        return mav;
    }
}
