package com.cslink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cslink.domain.SysUser;
import com.cslink.domain.vo.SignupVO;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISysUserService;
import com.cslink.utils.JWTUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2023-03-23 15:48:01
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper,SysUser> implements ISysUserService {
    @Resource
    private SysUserMapper sysUserMapper;
    @Override
    public SysUser getUserInfoByID(Integer userID) {
        return sysUserMapper.getUserInfoByID(userID);
    }

    @Override
    public Integer getUserIdByEmail(String email) {
        Integer userId = sysUserMapper.queryUserIdByEmail(email).getUserId();
        return userId;
    }

    @Override
    public String getUserNameById(Integer userId) {
        String username = sysUserMapper.queryUserNameById(userId).getUsername();
        return username;
    }

    @Override
    public SysUser getUserInfoByToken(String token) {
        String email = JWTUtil.getEmailFromToken(token);
        Integer userId = sysUserMapper.queryUserIdByEmail(email).getUserId();
        return  sysUserMapper.getUserInfoByID(userId);
    }

}
