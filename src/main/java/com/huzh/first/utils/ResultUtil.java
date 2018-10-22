package com.huzh.first.utils;

import com.huzh.first.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result = new Result();
        result.setCode(500);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }
    public static Result success(){
       return success(null);
    }
    public static Result error(String message, int code){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
