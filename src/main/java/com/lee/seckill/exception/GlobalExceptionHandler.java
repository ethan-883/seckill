package com.lee.seckill.exception;

import com.lee.seckill.vo.RespBean;
import com.lee.seckill.vo.RespBeanEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public RespBean globalExceptionHandle(Exception ex) {
        if (ex instanceof GlobalException){
            System.out.println("runtime exception:" + ex);
            log.error("runtime exception:{}", ex.toString());
            return RespBean.error(((GlobalException) ex).getRespBeanEnum());

        } else if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            log.info("param error:{}", bindException.getFieldError().getDefaultMessage());
            return RespBean.error(RespBeanEnum.MOBILE_ERROR);

        } else {
            log.error("exception:{}", ex.toString());
            return RespBean.error(RespBeanEnum.ERROR);
        }
    }

}
