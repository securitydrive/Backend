package com.example.demo.enity.mapper;

import com.example.demo.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author tensor
 */
@Mapper
public interface UserMapper {

    User login(@Param(value = "username") String username);
    Boolean register(@Param(value = "user") User user);
    User getUser(@Param(value = "user") User user);

}
