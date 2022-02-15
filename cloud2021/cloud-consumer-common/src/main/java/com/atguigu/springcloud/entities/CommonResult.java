package com.atguigu.springcloud.entities;

import com.atguigu.springcloud.Constant;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import static com.atguigu.springcloud.Constant.HTTP_SUCCESS;

@Data
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;

    private String message;

    private T data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }


    public CommonResult(String message) {
        this(Constant.HTTP_OK, message, null);
    }

    public CommonResult(Integer code) {
        this(code, Strings.EMPTY, null);
    }

    public CommonResult(T data) {
        this(Constant.HTTP_OK, HTTP_SUCCESS, data);
    }

    public CommonResult(T data, String message) {
        this(Constant.HTTP_OK, message, data);
    }

    public CommonResult() {
        this(Constant.HTTP_OK, HTTP_SUCCESS, null);
    }
}
