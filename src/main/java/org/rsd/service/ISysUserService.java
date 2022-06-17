package org.rsd.service;

import org.rsd.bean.SysUser;

import java.util.List;

public interface ISysUserService {

    List<SysUser> queryList();

    SysUser getById(Integer id);

    void insert(SysUser sysUser);

    void update(SysUser sysUser);

    void delete(Integer id);

}
