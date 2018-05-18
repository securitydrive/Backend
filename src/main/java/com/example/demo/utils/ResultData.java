package com.example.demo.utils;

import lombok.Data;

/**
 * <pre>
 *
 * </pre>
 * @author tensor
 */
@Data
public class ResultData<V, T> {

    private V result;
    private String response;
    private T data;

    public ResultData() {

    }

    public ResultData(T data) {
        this.data = data;
    }

    public ResultData(V result, String response, T data) {
        this.result = result;
        this.response = response;
        this.data = data;
    }
}
