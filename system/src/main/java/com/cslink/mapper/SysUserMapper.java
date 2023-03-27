package com.cslink.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.SysUser;
import com.cslink.domain.vo.SignupVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> getUserInfoByID(Integer userID);


    SignupVO existUserName(String username);

    SignupVO existEmail(String email);

    Integer saveUser(SignupVO user);
}
