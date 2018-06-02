package com.example.demo.enity.mapper;

import com.example.demo.enity.DevRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DevRecordMapper {

    DevRecord getLastDevLoc();

}
