package com.cslink.service.impl;

import com.cslink.constants.RedisPrefix;
import com.cslink.constants.SignInError;
import com.cslink.domain.vo.LoginUserVO;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISignInService;
import com.cslink.utils.JWTUtil;
import com.cslink.utils.RedisCache;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;
@Service
public class SignInService implements ISignInService {

    @Resource
    RedisCache redisCache;
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public String signin(LoginUserVO user) {
        Integer passed = null;
        String email = user.getEmail();
        if(user.getUsername() != null) {
            email = sysUserMapper.queryEmailByUsername(user.getUsername()).getEmail();
            passed = sysUserMapper.queryUserNameAndPassword(user.getUsername(), user.getPassword());
        }
        if(user.getEmail() != null) {
            passed = sysUserMapper.queryEmailAndPassword(email, user.getPassword());
        }
        if(passed > 0){
            try {
                String token = JWTUtil.createToken(email);
                redisCache.setCacheObject(RedisPrefix.SIGNED_TOKEN+ email,token,2,TimeUnit.HOURS);
                return token;
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        return SignInError.SIGNIN_ERROE;
    }

    @Override
    public String refreshToken(String oldToken){
        String freshToken = null;
        boolean access = false;
        try {
            access = JWTUtil.verifierToken(oldToken);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        if(access == false) {
            return SignInError.OLD_TOKNE_ERROE;
        }
        // TODO parse token get email
        return freshToken;
    }
}
