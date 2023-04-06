package com.cslink.service.impl;

import com.cslink.constants.RedisPrefix;
import com.cslink.constants.SignInError;
import com.cslink.domain.SysUser;
import com.cslink.domain.vo.LoginUserVO;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISignInService;
import com.cslink.utils.JWTUtil;
import com.cslink.utils.RedisCache;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Service
public class SignInService implements ISignInService {

    @Resource
    RedisCache redisCache;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public String signin(LoginUserVO user) {
        SysUser passed = null;
        String email = user.getEmail();
        if(user.getUsername() != null) {
            email = sysUserMapper.queryEmailByUsername(user.getUsername()).getEmail();
            passed = sysUserMapper.queryUserNameAndPassword(user.getUsername(), user.getPassword());
        }
        if(user.getEmail() != null) {
            passed = sysUserMapper.queryEmailAndPassword(email, user.getPassword());
        }
        if(passed != null){
            Map claim = new HashMap<>();
            claim.put("email",email);
            String token = JWTUtil.createToken(claim);
            redisCache.setCacheObject(RedisPrefix.SIGNED_TOKEN+ email,token,2,TimeUnit.HOURS);
            return token;
        }
        return SignInError.SIGNIN_ERROE;
    }

    @Override
    public String refreshToken(String oldToken){
        String freshToken = null;
        String email = JWTUtil.getEmailFromToken(oldToken);
        // verifyToken
        if(email == null) {

        }
        Map claim = new HashMap<>();
        claim.put("email",email);
        if(email != null) {
            freshToken = JWTUtil.createToken(claim);
            redisCache.setCacheObject(RedisPrefix.SIGNED_TOKEN + email,freshToken);
        }
        return freshToken;
    }
}
