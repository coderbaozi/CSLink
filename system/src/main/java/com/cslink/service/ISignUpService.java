package com.cslink.service;

import com.cslink.domain.vo.SignupVO;

import java.security.NoSuchAlgorithmException;

public interface ISignUpService {

    public boolean existUserName(String username);

    public boolean existEmail(String email);

    public String getCode(SignupVO user);

    public String verifyCode(SignupVO user) throws NoSuchAlgorithmException;
}
