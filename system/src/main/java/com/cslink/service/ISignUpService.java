package com.cslink.service;

public interface ISignUpService {
    public boolean getCaptcha();

    public boolean existUserName(String username);

    public boolean existEmail(String email);


}
