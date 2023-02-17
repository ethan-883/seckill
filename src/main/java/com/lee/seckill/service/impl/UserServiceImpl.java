package com.lee.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.seckill.mapper.UserMapper;
import com.lee.seckill.pojo.User;
import com.lee.seckill.request.LoginRequest;
import com.lee.seckill.service.UserService;
import com.lee.seckill.util.MD5Util;
import com.lee.seckill.vo.RespBean;
import com.lee.seckill.vo.RespBeanEnum;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author ethan
* @description 针对表【t_user(用户表)】的数据库操作Service实现
* @createDate 2023-02-16 22:06:31
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public RespBean doLogin(LoginRequest loginRequest) {
        String mobile = loginRequest.getMobile();
        String password = loginRequest.getPassword();

        User user = userMapper.selectById(mobile);
        if (user == null) {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        } else if (MD5Util.getMD5(password, user.getSalt()).equals(user.getPassword())){
            return RespBean.success();
        } else {
            return RespBean.error(RespBeanEnum.LOGIN_ERROR);
        }
    }

    @Override
    public User getUserByTicket(String ticket, HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}




