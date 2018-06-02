package com.example.demo.service.car;

import com.example.demo.enity.Device;
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
    <V, T>ResultData<V, T> addCarInfo(ResultData<V, ? extends Device> resultData);

    /**
     *
     * @param resultData
     * @return
     */
    <V, T>ResultData<V, T> updateCarInfo(ResultData<V, ? extends Device> resultData);

    /**
     *
     * @param resultData
     * @return
     */
    <V, T>ResultData<V, T> deleteCarInfo(ResultData<V, ? extends Device> resultData);

}
