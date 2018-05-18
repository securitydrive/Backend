package com.example.demo.service.user;

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
     * @param <V>
     * @param <T>
     * @return
     */
    <V, T> ResultData<V, T> sendCode(User user, HttpSession session);

}
