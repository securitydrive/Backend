package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {

    private int id;
    private String admin_id;
    private String admin_pwd;
    private String salt;
    private String admin_name;
    private String admin_headimg;
    private String admin_email;
    private String admin_phone;
    private int status;
    private Date create_at;
    private Date update_at;

}
