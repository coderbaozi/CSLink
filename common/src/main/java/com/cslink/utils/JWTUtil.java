package com.cslink.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Map;
public class JWTUtil {
    @Value("${token.secret}")
    private static String secret = "asdaslhjkdgaskljdhgakjsyhdgvajlshadsasdasdasdawdwaddhi";

    public static String createToken(Map<String,Object> claims){
        return Jwts.builder().addClaims(claims).signWith(SignatureAlgorithm.HS256,secret).compact();
    }

    public static Claims praseToken(String token) {
        return Jwts.parserBuilder().setSigningKey(secret).build().parseClaimsJws(token).getBody();
    }

    public static String getEmailFromToken(String token) {
        Claims claims = praseToken(token);
        return claims.get("email",String.class);
    }
}
