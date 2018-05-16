package com.example.demo.utils;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@Data
public class ResultData<T> {

    private Boolean result;
    private String response;
    private T data;

    public ResultData() {

    }

    public ResultData(T data) {
        this.data = data;
    }

    public ResultData(Boolean result, String response, T data) {
        this.result = result;
        this.response = response;
        this.data = data;
    }
}
