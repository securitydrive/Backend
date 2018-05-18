package com.example.demo.service.car.impl;

import com.example.demo.enity.UserCar;
import com.example.demo.service.car.CarService;
import com.example.demo.utils.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * UserCar 服务类yaopai1
 * @author tensor
 */
@Component
@Service("CarService")
public class CarServiceImpl implements CarService {

    /**
     * @param resultData
     * @return
     */
    @Override
    public <V, T> ResultData<V, T> addCarInfo(ResultData<V, ? extends UserCar> resultData) {
        return null;
    }

    /**
     * @param resultData
     * @return
     */
    @Override
    public <V, T> ResultData<V, T> updateCarInfo(ResultData<V, ? extends UserCar> resultData) {
        return null;
    }

    /**
     * @param resultData
     * @return
     */
    @Override
    public <V, T> ResultData<V, T> deleteCarInfo(ResultData<V, ? extends UserCar> resultData) {
        return null;
    }
}
