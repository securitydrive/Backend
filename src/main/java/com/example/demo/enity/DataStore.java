package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class DataStore {

    private int id;
    private String data_id;
    private String longitude;
    private String lat;
    private String car_id;
    private float car_speed;
    private float car_acc;
    private float gas_use;
    private Date create_at;
    private Date update_at;

}
