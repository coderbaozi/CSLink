package com.cslink.service.impl;

import com.cslink.domain.vo.SignupVO;
import com.cslink.mapper.SysUserMapper;
import com.cslink.service.ISignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements ISignUpService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Override
    public boolean getCaptcha() {
        return false;
    }
    @Override
    public boolean existUserName(String username) {
        SignupVO user = sysUserMapper.existUserName(username);
        return user != null;
    }

    @Override
    public boolean existEmail(String email) {
        SignupVO user = sysUserMapper.existUserName(email);
        return user != null;
    }
}
