package com.example.demo.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tensor
 */
@Controller
@RequestMapping(value = "/api")
public class SingleNodeController {

    @ResponseBody
    @GetMapping(value = "/node/single/path")
    public String devicePath(String deviceImie) {
        return null;
    }

}
