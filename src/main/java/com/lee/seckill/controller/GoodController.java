package com.lee.seckill.controller;

import com.lee.seckill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodController {

    /**
     * 商品列表页面
     * User对象UserArgumentResolver会创建
     * 无需从Redis拿
     * @param model
     * @param user
     * @return
     */
    @RequestMapping("/toList")
    public String toLogin(Model model, User user) {
        if (user == null) {
            return "login";
        } else {
            model.addAttribute("user", user);
            return "goodsList";
        }
    }

}
