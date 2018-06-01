package com.example.demo.web;

import com.example.demo.utils.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tensor
 */
@Slf4j
@RestController
public class TestController {

    @GetMapping(value = "/test/{api}")
    public ResultData test(@PathVariable String api) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("oauth : {}", authentication, api);
        return new ResultData("test ok?");
    }

}
