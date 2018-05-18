package com.example.demo.service.car;

import com.example.demo.enity.UserCar;
import com.example.demo.utils.ResultData;

/**
 * @author tensor
 */
public interface CarService {

    /**
     *
     * @param resultData
     * @return
     */
    <V, T>ResultData<V, T> addCarInfo(ResultData<V, ? extends UserCar> resultData);

    /**
     *
     * @param resultData
     * @return
     */
    <V, T>ResultData<V, T> updateCarInfo(ResultData<V, ? extends UserCar> resultData);

    /**
     *
     * @param resultData
     * @return
     */
    <V, T>ResultData<V, T> deleteCarInfo(ResultData<V, ? extends UserCar> resultData);

}
