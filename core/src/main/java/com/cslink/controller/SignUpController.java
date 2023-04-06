package com.cslink.controller;
import com.cslink.constants.SignUpError;
import com.cslink.domain.vo.SignupVO;
import com.cslink.service.ISignUpService;
import com.cslink.utils.AjaxResult;
import com.cslink.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.*;

@RestController
public class SignUpController {
    @Autowired
    ISignUpService signUpService;

    @Autowired
    RedisCache redisCache;
    @GetMapping("/existUserName/{username}")
    public AjaxResult existUserName(@PathVariable("username") String username) {
        boolean exist = signUpService.existUserName(username);
        return AjaxResult.success(exist);
    }

    @GetMapping("/existEmail/{email}")
    public AjaxResult existEmail(@PathVariable("email") String email) {
        boolean exist = signUpService.existEmail(email);
        return AjaxResult.success(exist);
    }

    @PostMapping("/getcode")
    public AjaxResult getCode(@RequestBody SignupVO user) {
        String uuid = signUpService.getCode(user);
        Map data = new HashMap<String,Object>();
        data.put("uuid",uuid);
        if(uuid == SignUpError.ERROR_EXISTED){
            return AjaxResult.success(SignUpError.ERROR_REPEATED);
        } else if (uuid == SignUpError.ERROR_EXISTED) {
            return AjaxResult.success(SignUpError.ERROR_EXISTED);
        }
        // send code
        return AjaxResult.success("success",data);
    }

    @PostMapping("/signup")
    public AjaxResult signUp(@RequestBody SignupVO user) {
        String token = null;
        try {
            token = signUpService.verifyCode(user);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        Map res = new HashMap<>();
        res.put("token",token);
        return AjaxResult.success(res);
    }

    // TODO 增加单元测试
    // TODO 增加动态读取数据，避免硬编码
}
