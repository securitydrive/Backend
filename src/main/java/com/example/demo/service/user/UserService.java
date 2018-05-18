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
    ResultData<Object, User> login(String userName);

    /**
     *
     * @return
     */
    ResultData register(ResultData<String, User> userResultData);

    /**
     *
     * @return
     */
    ResultData findPwd(ResultData<Object, User> userResultData);

}
