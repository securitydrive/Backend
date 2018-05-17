package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

/**
 * @author tensor
 */
@Data
public class User {

    private int id;
    private String user_id;
    private String salt;
    private String username;
    private String password;
    private String user_headimg;
    private String phone;
    private String email;
    private Date create_at;
    private Date update_at;

}
