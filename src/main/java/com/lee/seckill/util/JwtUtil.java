package com.lee.seckill.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

/**
 * JWT工具包
 */
public class JwtUtil {
    //失效时间
    private static final long EXPIRATION_TIME = 34;

    //哈希算法，不是加密算法，密钥,不分公钥私钥
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String getToken(String username) {
        Date now = new Date();
        Date expireTime = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder().setAudience(username)
                .setIssuedAt(now)
                .setExpiration(expireTime)
                .signWith(key)
                .compact();
    }

    public boolean verifyToken(String token, String username) {
        return Jwts.parserBuilder().setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getAudience()
                .equals(username);
    }

}
