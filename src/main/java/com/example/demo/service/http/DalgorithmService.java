package com.example.demo.service.http;

import com.example.demo.utils.ResultData;

/**
 * @author tensor
 */
public interface DalgorithmService {

    <V, T>ResultData<V, T> post(String userId);

    <V, T>ResultData<V, T> getResponseData(String userId);

}
