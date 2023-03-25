package com.cslink.domain;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2023-03-23 15:32:08
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {
    private static final long serialVersionUID = 582237504724074516L;

    @TableId
    private Integer userId;

    private String username;

    private String email;

    private String avater;

    private String createIp;

    private String lastLoginIp;

    private Integer lastLoginTime;

    private Integer followerCount;

    private Integer followeeCount;

    private Integer articleCount;

    private Integer notificationUnread;

    private Integer inboxUnread;

    private String bio;

    private Integer createTime;

    private Integer updateTime;

    private Integer disableTime;
}

