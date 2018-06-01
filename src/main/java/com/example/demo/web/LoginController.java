package com.example.demo.web;

import com.example.demo.enity.Admin;
import com.example.demo.enity.User;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(value = "/oauth/error")
    public void error(HttpServletResponse response) throws IOException {
        log.error("here");
        response.sendRedirect("/");
    }

    @PostMapping(value = "/login")
    public ResultData login(HttpServletRequest request) {
        log.info(request.getParameter("account"));
        try {
            request.login(request.getParameter("account"), request.getParameter("account"));
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/register")
    public ResultData register(@ModelAttribute User user) {
        log.info("RegisterUser : {}", user);
        return userService.register(new ResultData<>(user));
    }

    /**
     *
     * @param user
     * @return
     */
    @PostMapping(value = "/findPwd")
    public ResultData findPwd(@RequestBody User user) {
        return userService.findPwd(new ResultData<>(user));
    }

}
