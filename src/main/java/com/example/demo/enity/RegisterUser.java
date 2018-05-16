package com.example.demo.enity;

import lombok.Data;

/**
 * @author tensor
 */
@Data
public class RegisterUser extends User {

    private String userName;
    private String userPassword;
    private String userPhone;

}
