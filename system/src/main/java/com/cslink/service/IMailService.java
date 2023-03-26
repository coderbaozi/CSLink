package com.cslink.service;

public interface IMailService {
    boolean sendMail(String to,String subject,String content);
}
