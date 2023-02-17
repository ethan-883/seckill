package com.lee.seckill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lee.seckill.exception.GlobalException;
import com.lee.seckill.mapper.UserMapper;
import com.lee.seckill.pojo.User;
import com.lee.seckill.request.LoginRequest;
import com.lee.seckill.service.UserService;
import com.lee.seckill.util.CookieUtil;
import com.lee.seckill.util.JsonUtil;
import com.lee.seckill.util.MD5Util;
import com.lee.seckill.util.UUIDUtil;
import com.lee.seckill.vo.RespBean;
import com.lee.seckill.vo.RespBeanEnum;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public RespBean doLogin(LoginRequest loginRequest, HttpServletRequest request,
                            HttpServletResponse response) {
        String mobile = loginRequest.getMobile();
        String password = loginRequest.getPassword();

        User user = userMapper.selectById(mobile);
        if (user == null) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }
        if (!MD5Util.getMD5(password, user.getSalt()).equals(user.getPassword())) {
            throw new GlobalException(RespBeanEnum.LOGIN_ERROR);
        }

        //ticket
        String ticket = UUIDUtil.getUUID();
        CookieUtil.setCookie(request, response, "ticket", ticket);
        redisTemplate.opsForValue().set("user:" + ticket, JsonUtil.object2JsonStr(user));
        return RespBean.success(ticket);
    }

    @Override
    public User getUserByTicket(String ticket) {
        if (StringUtils.hasLength(ticket)) {
            String userJSON = redisTemplate.opsForValue().get("user:" + ticket);
            if (StringUtils.hasLength(userJSON)) {
                return JsonUtil.jsonStr2Object(userJSON, User.class);
            }
        }
        return null;
    }
}




