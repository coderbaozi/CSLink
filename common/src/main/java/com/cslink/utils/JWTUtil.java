package com.cslink.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.cslink.domain.RSA256Key;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class JWTUtil {
    public static String createToken(Object data) throws NoSuchAlgorithmException {
        RSA256Key rsa256Key = RsaKeyUtil.generateRSA256Key();

        Algorithm algorithm = Algorithm.RSA256(rsa256Key.getPrivateKey());

        // TODO token过期时间
        return JWT.create()
                .withIssuer("cslink")
                .withIssuedAt(new Date())
                .withClaim("data", JSONUtil.toJsonString(data))
                .sign(algorithm);
    }

    public static boolean verifierToken(String token) throws NoSuchAlgorithmException {

        //获取公钥/私钥
        RSA256Key rsa256Key = RsaKeyUtil.generateRSA256Key();

        //根据密钥对生成RS256算法对象
        Algorithm algorithm = Algorithm.RSA256(rsa256Key.getPublicKey());

        //解密时，使用公钥生成算法对象
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("cslink")
                .build();

        try {
            //验证Token，verifier自动验证
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }
}
