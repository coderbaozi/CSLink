package com.cslink.service.impl;

import com.cslink.constants.RedisPrefix;
import com.cslink.constants.SignUpError;
import com.cslink.domain.vo.SignupVO;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.IMailService;
import com.cslink.service.ISignUpService;
import com.cslink.utils.*;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class SignUpServiceImpl implements ISignUpService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Resource
    private RedisCache redisCache;

    @Autowired
    private IMailService mailService;

    @Override
    public boolean existUserName(String username) {
        SignupVO user = sysUserMapper.existUserName(username);
        return user != null;
    }

    @Override
    public boolean existEmail(String email) {
        SignupVO user = sysUserMapper.existEmail(email);
        return user != null;
    }

    @Override
    public String getCode(SignupVO user) {
        // TODO REGEX Verification
        if(existUserName(user.getUsername()) || existEmail(user.getEmail())){
            return SignUpError.ERROR_EXISTED;
        }
        Integer count = redisCache.getCacheObject(RedisPrefix.SIGN_UP+user.toString());
        if(count != null) { return SignUpError.ERROR_REPEATED; }
        String code = GenerateCaptcha.getCode();
        String codeUUid = UUIDUtils.getUUID();
        redisCache.setCacheObject(RedisPrefix.SIGN_UP + user.toString(),1,90,TimeUnit.SECONDS);
        redisCache.setCacheObject(RedisPrefix.SIGN_UP + codeUUid, code,5, TimeUnit.MINUTES);
        mailService.sendMail(user.getEmail(), "Captcha",code);
        return codeUUid;
    }

    @Override
    public String verifyCode(SignupVO user) throws NoSuchAlgorithmException {
        if(user.getUuid() == null) {
            return SignUpError.ERROE_UUID_LACK;
        }
        String code = redisCache.getCacheObject(RedisPrefix.SIGN_UP + user.getUuid());
        if(code == null) {
            return SignUpError.ERROR_CAPTCHA_EXPIRATION;
        }
        if(user.getCode() != null && !code.equals(user.getCode())){
            return  SignUpError.ERROR_CAPTCHA_FALSE;
        }
        sysUserMapper.saveUser(user);
        redisCache.deleteObject(RedisPrefix.SIGN_UP+user.getUuid());
        Map claims = new HashMap<>();
        claims.put("email",user.getEmail());
        String token = JWTUtil.createToken(claims);
        redisCache.setCacheObject(RedisPrefix.SIGNED_TOKEN + user.getEmail(),token,2,TimeUnit.HOURS);
        return token;
    }
}
