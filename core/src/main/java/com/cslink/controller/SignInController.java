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
    public AjaxResult getToken(@RequestBody Map<String,String> tokenMap){
        String freshToken = signInService.refreshToken(tokenMap.get("token"));
        Map res = new HashMap();
        res.put("token",freshToken);
        return AjaxResult.success(res);
    }
}
