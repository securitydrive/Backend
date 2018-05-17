package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class UserCar {

    private int id;
    private String user_id;
    private String car_id;
    private String car_type;
    private String car_number;
    private String note;
    private String car_img;
    private String obd_number;
    private String usual_site;
    private String usual_des;
    private Date create_at;
    private Date update_at;

}
