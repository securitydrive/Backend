package com.example.demo.service.user.impl;

import com.example.demo.enity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.exception.UserExistsException;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.example.demo.utils.RegisterGetToken.getToken;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@Slf4j
@Component
@Service(value = "UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @return
     */
    @Override
    public ResultData<User> login(String userName) {
        log.info("userName : {}",userName);
        return new ResultData<User>(userMapper.login(userName));
    }

    /**
     * @param userResultData
     * @return
     */
    @Override
    public ResultData register(ResultData<User> userResultData) {
        ResultData result = new ResultData();
        log.info("User : {}", userResultData.getData());
        User user = userResultData.getData();
        if (userMapper.getUserInfo(user) == null) {
            userMapper.register(user);
            result.setResult(true);
            result.setResponse(HttpStatus.OK.toString());
            result.setData(getToken(user));
            return result;
        }
        throw new UserExistsException("用户名以存在");
    }

    /**
     * @param userResultData
     * @return
     */
    @Override
    public ResultData findPwd(ResultData<User> userResultData) {
        return null;
    }

}
