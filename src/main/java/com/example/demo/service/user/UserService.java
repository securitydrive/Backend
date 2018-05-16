package com.example.demo.service.user;

import com.example.demo.enity.User;
import com.example.demo.utils.ResultData;

/**
 * @author tensor
 */
public interface UserService {

    /**
     *
     * @return
     */
    ResultData<User> login(String userName);

    /**
     *
     * @return
     */
    ResultData register(ResultData<User> userResultData);

    /**
     *
     * @return
     */
    ResultData findPwd(ResultData<User> userResultData);

}
