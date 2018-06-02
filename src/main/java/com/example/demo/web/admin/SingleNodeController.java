package com.example.demo.web.admin;

import com.example.demo.service.record.RecordService;
import com.example.demo.utils.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tensor
 */
@Controller
//@RequestMapping(value = "/api")
public class SingleNodeController {

    @Autowired private RecordService recordService;

    @ResponseBody
    @GetMapping(value = "/node/single/path")
    public ResultData devicePath(String deviceImie) {
        return recordService.getLastDevLoc();
    }

}
