package com.lee.seckill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lee.seckill.pojo.User;
import com.lee.seckill.request.LoginRequest;
import com.lee.seckill.vo.RespBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author ethan
* @description 针对表【t_user(用户表)】的数据库操作Service
* @createDate 2023-02-16 22:06:31
*/
public interface UserService extends IService<User> {

    /**
     * 登录
     * @param loginRequest 入参
     * @return respBean
     */
    RespBean doLogin(LoginRequest loginRequest);

    /**
     * 拿cookie中ticket取得用户
     * @return 用户
     */
    User getUserByTicket(String ticket, HttpServletRequest request,
                         HttpServletResponse response);

}
