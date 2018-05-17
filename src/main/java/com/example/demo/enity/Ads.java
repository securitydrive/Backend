package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

@Data
public class Ads {

    private int id;
    private String ad_id;
    private String ad_info;
    private String ad_title;
    private String ad_content;
    private Date create_at;
    private Date update_at;

}
