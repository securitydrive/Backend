package com.example.demo.service.code;

import com.example.demo.enity.User;
import com.example.demo.utils.ResultData;

import javax.servlet.http.HttpSession;

/**
 * @author tensor
 */
public interface SendAuthCodeService {

    /**
     *
     * @param user
     * @param session
     * @param <T>
     * @return
     */
    <T> ResultData<T> sendCode(User user, HttpSession session);

}
