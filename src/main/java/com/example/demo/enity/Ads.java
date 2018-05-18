package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Ads {

    private int id;
    private String adId;
    private String adInfo;
    private String adTitle;
    private String adContent;
    private Date createAt;
    private Date updateAt;

}
