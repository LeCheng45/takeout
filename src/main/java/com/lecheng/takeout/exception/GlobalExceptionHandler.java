package com.lecheng.takeout.exception;

import com.lecheng.takeout.common.CustomException;
import com.lecheng.takeout.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//RestControllerAdvice+ResponseBody
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public R ex1(RuntimeException ex){
        log.info("出现了RuntimeException.....");
        ex.printStackTrace();

        return R.error("系统繁忙,请稍后重试");
    }


    @ExceptionHandler(CustomException.class)
    public R<String> exceptionHandler(CustomException ex){
        log.error(ex.getMessage());
        return R.error(ex.getMessage());
    }

}
