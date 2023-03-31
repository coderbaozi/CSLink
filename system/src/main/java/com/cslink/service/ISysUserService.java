package com.cslink.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cslink.domain.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2023-03-23 15:45:28
 */
public interface ISysUserService extends IService<SysUser> {
    public List<SysUser> getUserInfoByID(Integer userID);

    public Integer getUserIdByEmail(String email);
}
