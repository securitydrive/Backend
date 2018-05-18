package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {

    private int id;
    private String adminId;
    private String adminPwd;
    private String salt;
    private String adminName;
    private String adminHeadimg;
    private String adminEemail;
    private String admiPphone;
    private int status;
    private Date createAt;
    private Date updateAt;

}
