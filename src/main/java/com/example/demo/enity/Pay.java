package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Pay {

    private int id;
    private String userId;
    private String tradeId;
    private int price;
    private String carNumber;
    private String info;
    private Date createdAt;
    private Date updatedAt;

}
