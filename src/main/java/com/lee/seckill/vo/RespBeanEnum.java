package com.lee.seckill.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RespBeanEnum {
    SUCCESS(200,"success"),
    ERROR(500, "server error"),

    /**
     * 登录模块51*
     */
    SESSION_ERROR(501, "session invalid"),
    LOGIN_ERROR(502, "username or password error"),
    MOBILE_ERROR(503, "mobile format error");

    private final Integer code;
    private final String message;

}
