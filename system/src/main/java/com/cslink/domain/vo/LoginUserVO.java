package com.cslink.domain.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserVO {
    private String userId;
    private String username;
    private String password;
    private String email;
    private String login_ip;
}
