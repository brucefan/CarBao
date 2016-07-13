package com.car.controller;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * CarController
 *
 * @author Bruce01.fan
 * @date 16/7/13
 */
@Controller
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 进入车辆信息中心
     *
     * @param userId
     * @param carId
     * @return
     */
    @RequestMapping(value = "/enterCarInfo")
    public ModelAndView enterCarInfo(
            @RequestParam(value = "userId", required = true) Long userId,
            @RequestParam(value = "carId", required = false) Long carId
    ) {

        return null;
    }

    /**
     * 保存车辆信息
     *
     * @param userId
     * @param carId
     * @return
     */
    @RequestMapping(value = "/saveCarInfo")
    public ModelAndView saveCarInfo(
            @RequestParam(value = "userId", required = true) Long userId,
            @RequestParam(value = "carId", required = false) Long carId
    ) {

        return null;
    }

}
