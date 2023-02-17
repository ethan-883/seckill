package com.lee.seckill.request;

import com.lee.seckill.annotation.MobileCheck;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    /**
     * 手机号
     */
    @MobileCheck
    private String mobile;

    /**
     * 前端md5后密码
     */
    @NotNull
    private String password;

}
