package com.cslink.controller;

import com.cslink.service.ISignUpService;
import com.cslink.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @Autowired
    ISignUpService signUpService;

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

    // TODO 增加单元测试
    // TODO 增加动态读取数据，避免硬编码
}
