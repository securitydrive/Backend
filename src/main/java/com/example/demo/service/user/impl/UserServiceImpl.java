package com.example.demo.service.user.impl;

import com.example.demo.enity.User;
import com.example.demo.enity.mapper.UserMapper;
import com.example.demo.service.exception.UserExistsException;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.UUID;

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

    @Resource
    private UserMapper userMapper;

    /**
     * @return
     */
    @Override
    public ResultData<Object, User> login(String username) {
        return new ResultData<Object, User>(userMapper.login(username));
    }

    /**
     * @param userResultData
     * @return
     */
    @Override
    public ResultData register(ResultData<String, User> userResultData) {
        ResultData result = new ResultData();
        User user = userResultData.getData();
        if (userMapper.getUserInfo(user) == null) {
            user.setUserId(UUID.nameUUIDFromBytes(user.getUserName().getBytes()).toString());
            user.setSalt(String.valueOf(user.hashCode()));
            userMapper.register(user);
            result.setResult(user.getUserId());
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
    public ResultData findPwd(ResultData<Object, User> userResultData) {
        return null;
    }

}
