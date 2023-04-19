package com.example.common;

import lombok.Data;

@Data
public class CommonResult<T> {

    private boolean success;

    private String message;

    private T data;


    public static <T> CommonResult<?> success(T data,String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setSuccess(true);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static <T> CommonResult<?> fail(T data,String message) {
        CommonResult<T> result = new CommonResult<>();
        result.setSuccess(false);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

}
