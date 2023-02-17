package com.lee.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RespBean {
    private Integer code;
    private String message;
    /**
     * 返回对象
     */
    private Object data;

    public static RespBean success() {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),
                RespBeanEnum.SUCCESS.getMessage(),
                null);
    }

    public static RespBean success(Object obj) {
        return new RespBean(RespBeanEnum.SUCCESS.getCode(),
                RespBeanEnum.SUCCESS.getMessage(),
                obj);
    }

    public static RespBean error(RespBeanEnum respBeanEnum) {
        return new RespBean(respBeanEnum.getCode(),
                respBeanEnum.getMessage(),
                null);
    }

}
