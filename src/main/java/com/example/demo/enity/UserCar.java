package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class UserCar {

    private int id;
    private String userId;
    private String carId;
    private String carType;
    private String carNumber;
    private String note;
    private String carImg;
    private String obdNumber;
    private String usualSite;
    private String usualDes;
    private Date createAt;
    private Date updateAt;

}
