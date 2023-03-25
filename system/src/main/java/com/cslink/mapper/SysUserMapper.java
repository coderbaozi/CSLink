package com.cslink.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cslink.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    List<SysUser> getUserInfoByID(Integer userID);
}
