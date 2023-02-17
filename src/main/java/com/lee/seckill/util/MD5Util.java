package com.lee.seckill.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * md5工具
 */
public class MD5Util {

    private MD5Util(){}

    private static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    private static final String salt = "3a4b5c6d";

    public static String getMD5(String str, String salt) {
        StringBuilder sb = new StringBuilder();
        sb.append(salt.charAt(0)).append(salt.charAt(2))
                .append(str).append(salt.charAt(5))
                .append(salt.charAt(4));
        return md5(sb.toString());
    }

    public static String getDBPassword(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(salt.charAt(0)).append(salt.charAt(2))
                .append(str).append(salt.charAt(5))
                .append(salt.charAt(4));
        return md5(sb.toString());
    }

}
