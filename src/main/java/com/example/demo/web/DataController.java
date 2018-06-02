package com.example.demo.web;

import com.example.demo.enity.Device;
import com.example.demo.service.car.CarService;
import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author tensor
 */
@Slf4j
@Controller
public class DataController {

    @Qualifier(value = "CarService")
    @Autowired
    private CarService carService;

    /**
     * 根据 user_id 获取对应的设备信息
     * @param userId
     * @return
     */
    @GetMapping(value = "/{user_id}/get/device/info")
    public ResultData getDeviceData(@PathVariable("user_id") String userId) {
        return null;
    }

    /**
     * 根据 user_id 以及 Device 对象更新对应 user_id 的 Device 信息
     * @param userId
     * @param Device
     * @return
     */
    @PostMapping(value = "/{user_id}/update/device/info")
    public ResultData updateDeviceData(@PathVariable("user_id") String userId, @ModelAttribute Device Device) {
        return null;
    }

    /**
     * 根据 user_id 与 car_id 删除对应的 Device
     * @param userId
     * @param carId
     * @return
     */
    @DeleteMapping(value = "/{user_id}/delete/{car_id}")
    public ResultData deleteDeviceData(@PathVariable("user_id") String userId, @PathVariable("car_id") String carId) {
        return null;
    }

    /**
     * 根据 user_id 为用户增加一个 Device
     * @param userId
     * @param Device
     * @return
     */
    @PutMapping(value = "/{user_id}/add/device/info")
    public ResultData addDeviceData(@PathVariable("user_id") String userId, @ModelAttribute Device Device) {
        return null;
    }

}
