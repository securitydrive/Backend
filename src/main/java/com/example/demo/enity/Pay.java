package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Pay {

    private int id;
    private String user_id;
    private String trade_id;
    private int price;
    private String car_number;
    private String info;
    private Date created_at;
    private Date updated_at;

}
