package com.lee.seckill.util;


import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

/**
 * 校验工具类
 */
public class ValidationUtil {

    private static final Pattern MOBILE_PATTER = Pattern.compile("^[1]([3-9])[0-9]{9}$");

    private ValidationUtil(){}

    /**
     * 手机号格式校验
     * @param str 手机号
     * @return boolean
     */
    public static boolean isMobile(String str) {
        if (StringUtils.hasLength(str)) {
            return MOBILE_PATTER.matcher(str).matches();
        } else {
            return false;
        }
    }


}
