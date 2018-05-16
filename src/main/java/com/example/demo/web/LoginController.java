package com.example.demo.web;

import com.example.demo.enity.RegisterUser;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@Slf4j
@RestController
public class LoginController {

    @Qualifier(value = "UserService")
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    public ResultData register(@ModelAttribute RegisterUser user) {
        log.info("RegisterUser : {}", user);
        return userService.register(new ResultData<>(user));
    }

    @PostMapping(value = "/findPwd")
    public ResultData findPwd(@RequestBody RegisterUser user) {
        return userService.findPwd(new ResultData<>(user));
    }

}
