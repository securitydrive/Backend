package com.example.demo.service.record;

import com.example.demo.utils.ResultData;

import java.util.List;
import java.util.Map;

/**
 * @author tensor
 */
public interface RecordService {

    ResultData getLastDevLoc();
    ResultData getAllDevDistribute();
    List<Map<String, String>> getDeviceInfo();

}
