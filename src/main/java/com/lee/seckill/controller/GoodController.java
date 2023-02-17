package com.lee.seckill.controller;

import com.lee.seckill.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/goods")
public class GoodController {

    @RequestMapping("/toList")
    public String toLogin(HttpSession session, Model model,
                          @CookieValue("ticket") String ticket) {
        if (StringUtils.hasLength(ticket)) {
            User user = (User) session.getAttribute(ticket);
            if (user == null) {
                return "login";
            } else {
                model.addAttribute("user", user);
                return "goodsList";
            }
        } else {
            return "login";
        }
    }

}
