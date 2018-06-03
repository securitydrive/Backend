package com.example.demo.web;

import com.example.demo.enity.User;
import com.example.demo.service.user.UserService;
import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping(value = "/login")
//    public void login(HttpServletRequest request, HttpServletResponse response) {
//        log.info(request.getParameter("account"));
//        try {
//            request.login(request.getParameter("account"), request.getParameter("password"));
//            response.sendRedirect("/atta/index");
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
