package com.cslink.controller;

import com.cslink.domain.SysUser;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISysUserService;
import com.cslink.utils.AjaxResult;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SysController {
    @Autowired
    private ISysUserService sysUserServive;

    @GetMapping("/{userID}")
    public String getUserInfo(@PathVariable("userID") Integer userID) {
        return AjaxResult.success(sysUserServive.getUserInfoByID(userID)).toString();
    }

    @GetMapping("/getUserName")
    public AjaxResult getUserName(@RequestParam("userId")Integer userId) {
        String username = sysUserServive.getUserNameById(userId);
        return AjaxResult.success("请求成功！",username);
    }
}
