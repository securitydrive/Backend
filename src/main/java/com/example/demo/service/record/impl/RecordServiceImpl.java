package com.example.demo.service.record.impl;

import com.example.demo.enity.DevRecord;
import com.example.demo.enity.mapper.DevRecordMapper;
import com.example.demo.service.record.RecordService;
import com.example.demo.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

/**
 * @author tensor
 */
@Service
public class RecordServiceImpl implements RecordService {

    @Resource private DevRecordMapper recordMapper;

    @Override
    public ResultData getLastDevLoc() {
        DevRecord record = recordMapper.getLastDevLoc();
        List list = new ArrayList();
        List list1 = new ArrayList();
        list1.add(record.getRecordLongitude());
        list1.add(record.getRecordDimensionality());
        list.add(list1);
        return new ResultData(list);
    }

    @Override
    public ResultData getAllDevDistribute() {
        List<DevRecord> devRecords = recordMapper.getAllDevDistribute();
        return new ResultData(devRecords.stream().map(devRecord -> {
            List list = new ArrayList();
            list.add(devRecord.getRecordDimensionality());
            list.add(devRecord.getRecordLongitude());
            return list;
        }).collect(toList()));
    }

    @Override
    public List<Map<String, String>> getDeviceInfo() {
        List<DevRecord> devRecords = recordMapper.getDeviceInfo();
        return null;
    }
}
