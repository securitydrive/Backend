package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class DataDeal {

    private int id;
    private String dataId;
    private String longitude;
    private String lat;
    private String carId;
    private float carSpeed;
    private float carAcc;
    private float gasUse;
    private Date createAt;
    private Date updateAt;

}
