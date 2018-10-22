package com.huzh.first.handler;

import com.huzh.first.domain.Boy;
import com.huzh.first.domain.Result;
import com.huzh.first.exception.BoyException;
import com.huzh.first.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandle{
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof BoyException){
            BoyException boyException = (BoyException)e;
            return ResultUtil.error(boyException.getMessage(),boyException.getCode());
        }
        logger.error("[系统异常]{}", e);
        return ResultUtil.error("未知错误",-1);
    }


}
