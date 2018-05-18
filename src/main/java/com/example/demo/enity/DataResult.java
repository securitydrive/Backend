package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class DataResult {

    private int id;
    private String resultId;
    private String dataId;
    private String dealId;
    private String resultImg;
    private String longitude;
    private String lat;
    private String carId;
    private float carSpeed;
    private float carAcc;
    private float gasUse;
    private Date createAt;
    private Date updateAt;

}
