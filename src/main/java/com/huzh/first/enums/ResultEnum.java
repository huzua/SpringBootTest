package com.huzh.first.enums;

import org.springframework.context.annotation.Primary;

public enum ResultEnum{
    UNKNOW_ERROR(1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(2,"小学生"),
    MIDDLE_SCHOOL(3,"初中生");

    private int code;

    private String message;

    ResultEnum(int code,String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
