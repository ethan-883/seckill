package com.lee.seckill.exception;

import com.lee.seckill.vo.RespBeanEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 自定义异常
 */
@Getter
@Setter
@AllArgsConstructor
public class GlobalException extends RuntimeException{

    private RespBeanEnum respBeanEnum;

}
