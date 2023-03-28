package com.cslink.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.SysUser;
import com.cslink.domain.vo.LoginUserVO;
import com.cslink.domain.vo.SignupVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> getUserInfoByID(Integer userID);


    SignupVO existUserName(String username);

    SignupVO existEmail(String email);

    Integer saveUser(SignupVO user);

    LoginUserVO queryEmailByUsername(String username);

    Integer queryUserNameAndPassword(@Param("username") String username,@Param("password") String password);

    Integer queryEmailAndPassword(@Param("email") String email,@Param("password") String password);
}
