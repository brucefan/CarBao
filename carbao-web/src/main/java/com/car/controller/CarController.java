package com.car.controller;/**
 * Created by fanguiming on 16/7/13.
 */

import com.car.consts.CarSeries;
import com.car.consts.Province;
import com.car.entity.Car;
import com.car.entity.User;
import com.car.service.CarService;
import com.car.service.UserService;
import com.car.vo.RestResult;
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
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    /**
     * 进入车辆信息中心
     *
     * @param userId
     * @param carId
     * @return
     */
    @RequestMapping(value = "/carInfo/enter")
    public ModelAndView enterCarInfo(
            @RequestParam(value = "userId", required = true) Long userId,
            @RequestParam(value = "carId", required = false) Long carId
    ) {
        ModelAndView mav = new ModelAndView("car/carInfo");

        User user = userService.findById(userId);

        mav.addObject("userId", userId);
        mav.addObject("userType", user.getUserType());
        mav.addObject("provinces", Province.values());
        mav.addObject("carSeries", CarSeries.values());

        if (carId != null) {
            Car car = carService.findById(carId);
            if (car == null) {
                mav.addObject("error", "车量信息查询失败");
            } else {
                mav.addObject("car", car);
            }
        }

        return mav;
    }

    /**
     * 保存车辆信息
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "/carInfo/save")
    public ModelAndView saveCarInfo(
            @RequestParam(value = "userId", required = true) Long userId,
            @RequestParam(value = "userType", required = true) int userType,
            Car car
    ) {
        User user = new User();
        user.setUserId(userId);
        user.setUserType(userType);

        RestResult restResult = carService.saveCarInfo(user, car);
        ModelAndView mav = new ModelAndView("home");

        return mav;
    }

}
