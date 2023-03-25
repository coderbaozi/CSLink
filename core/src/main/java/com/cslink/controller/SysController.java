package com.cslink.controller;

import com.cslink.domain.SysUser;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISysUserService;
import com.cslink.utils.AjaxResult;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class SysController {

    @Autowired
    private ISysUserService sysUserServive;

    @GetMapping("/{userID}")
    public String getUserInfo(@PathVariable("userID") Integer userID) {
        return AjaxResult.success(sysUserServive.getUserInfoByID(userID)).toString();
    }
}
