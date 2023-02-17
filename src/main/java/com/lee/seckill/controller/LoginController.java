package com.lee.seckill.controller;

import com.lee.seckill.request.LoginRequest;
import com.lee.seckill.service.UserService;
import com.lee.seckill.vo.RespBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/doLogin")
    @ResponseBody
    public RespBean doLogin(@Valid LoginRequest request,
                            HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        log.info("login request:{}", request);
        return userService.doLogin(request, httpServletRequest, httpServletResponse);
    }

}
