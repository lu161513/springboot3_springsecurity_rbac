package com.yuantu.project.exception;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomException extends RuntimeException {


    private static final long serialVersionUID = 8953939175283120497L;

    private String msg;
    private int code = 500;

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }
}
