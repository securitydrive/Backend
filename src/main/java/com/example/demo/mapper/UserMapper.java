package com.example.demo.mapper;

import com.example.demo.enity.User;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
public interface UserMapper {

    /**
     *
     * @param userName
     * @return
     */
    User login(@Param(value = "userName") String userName);

    Boolean register(@Param(value = "user") User user);

    User getUserInfo(@Param(value = "user") User user);

}
