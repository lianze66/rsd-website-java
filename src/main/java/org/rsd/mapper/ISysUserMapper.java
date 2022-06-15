package org.rsd.mapper;

import org.apache.ibatis.annotations.Select;
import org.rsd.bean.SysUser;

import java.util.List;

public interface ISysUserMapper {

    @Select("select * from bu_sys_user")
    List<SysUser> queryList();

    SysUser getById(Integer id);
}
