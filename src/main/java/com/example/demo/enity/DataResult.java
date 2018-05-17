package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class DataResult {

    private int id;
    private String result_id;
    private String data_id;
    private String deal_id;
    private String result_img;
    private String longitude;
    private String lat;
    private String car_id;
    private float car_speed;
    private float car_acc;
    private float gas_use;
    private Date create_at;
    private Date update_at;

}
