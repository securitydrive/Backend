package com.example.demo.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * @author tensor
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DevRecord {

    private String recordId;
    private Date recordTime;
    private Double recordLongitude;
    private Double recordDimensionality;
    private Integer recordAltitude;
    private Double recordSpeed;
    private Double recordAcc;
    private String recordImei;

}
