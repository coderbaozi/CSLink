package com.cslink.service;

import com.cslink.domain.vo.LoginUserVO;

import java.security.NoSuchAlgorithmException;

public interface ISignInService {

    String signin(LoginUserVO user);
    String refreshToken(String oldToken);
}
