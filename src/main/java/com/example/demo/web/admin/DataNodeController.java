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
public class DataNodeController {

    /**
     * 节点分布
     * @return
     */
    @ResponseBody
    @GetMapping(value = "/node/all/distribute")
    public String nodeDistribute() {
        return null;
    }

}
