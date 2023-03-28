package com.cslink.controller;

import com.cslink.domain.vo.LoginUserVO;
import com.cslink.service.ISignInService;
import com.cslink.utils.AjaxResult;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
public class SignInController {
    @Resource
    private ISignInService signInService;

    @PostMapping("/signin")
    public AjaxResult signIn(@RequestBody LoginUserVO user){
        String signInRes = signInService.signin(user);
        Map res = new HashMap<>();
        res.put("token",signInRes);
        return AjaxResult.success(res);
    }
    @PostMapping("/getToken")
    public AjaxResult getToken(@RequestBody String token){
        signInService.refreshToken(token);
        return null;
    }
}
