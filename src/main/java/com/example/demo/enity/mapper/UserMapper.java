package com.example.demo.enity.mapper;

import com.example.demo.enity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@Mapper
public interface UserMapper {

    /**
     *
     * @param username
     * @return
     */
    User login(@Param(value = "username") String username);

    /**
     *
     * @param user
     * @return
     */
    Boolean register(@Param(value = "user") User user);

    /**
     *
     * @param user
     * @return
     */
    User getUserInfo(@Param(value = "user") User user);

}
