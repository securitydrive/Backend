package com.example.demo.web.exception;

import com.example.demo.service.exception.UserExistsException;
import com.example.demo.utils.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author tensor
 */
@ControllerAdvice(annotations = Service.class)
public class RestExceptionHandler {

    /**
     *
     * @param e
     * @return
     */
    private ResultData UserExists(UserExistsException e) {
        return new ResultData(false, e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
