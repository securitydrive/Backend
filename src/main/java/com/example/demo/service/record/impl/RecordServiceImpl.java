package com.example.demo.service.record.impl;

import com.example.demo.enity.DevRecord;
import com.example.demo.enity.mapper.DevRecordMapper;
import com.example.demo.service.record.RecordService;
import com.example.demo.utils.ResultData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
}
