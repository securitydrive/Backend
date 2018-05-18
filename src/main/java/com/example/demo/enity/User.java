package com.example.demo.enity;

import lombok.Data;

import java.util.Date;

/**
 * @author tensor
 */
@Data
public class User {

    private int id;
    private String userId;
    private String salt;
    private String userName;
    private String userPwd;
    private String userHeadimg;
    private String userPhone;
    private String userEmail;
    private Date createAt;
    private Date updateAt;

}
