package com.example.demo.mapper.impl;

import com.example.demo.enity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * @author tensor
 */
@Repository
public class UserMapperImpl implements UserMapper {

    @Resource
    private UserMapper userMapper;


    /**
     * @param userName
     * @return
     */
    @Override
    public User login(String userName) {
        return this.userMapper.login(userName);
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public Boolean register(User user) {
        return this.userMapper.register(user);
    }

    /**
     *
     * @param user
     * @return
     */
    @Override
    public User getUserInfo(User user) {
        return this.userMapper.getUserInfo(user);
    }
}
