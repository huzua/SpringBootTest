package com.huzh.first.exception;

import com.huzh.first.enums.ResultEnum;

public class BoyException extends RuntimeException{
    private int code;

    public BoyException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
