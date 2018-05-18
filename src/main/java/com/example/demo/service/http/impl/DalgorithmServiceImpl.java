package com.example.demo.service.http.impl;

import com.example.demo.service.http.DalgorithmService;
import com.example.demo.utils.ResultData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author tensor
 */
@Component
@Service(value = "D-algorithmService")
public class DalgorithmServiceImpl implements DalgorithmService {

    @Override
    public <V, T> ResultData<V, T> post(String userId) {
        return null;
    }

    @Override
    public <V, T> ResultData<V, T> getResponseData(String userId) {
        return null;
    }
}
