package com.cslink.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cslink.domain.SysUser;
import com.cslink.domain.vo.SignupVO;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISysUserService;
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
    public List<SysUser> getUserInfoByID(Integer userID) {
        return sysUserMapper.getUserInfoByID(userID);
    }

}
