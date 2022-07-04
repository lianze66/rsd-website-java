package org.rsd.service;

import org.rsd.bean.SysRole;

import java.util.List;

public interface ISysRoleService {

    List<SysRole> querList();

    SysRole getById(Integer id);

    void insert(SysRole sysRole);

    void update(SysRole sysRole);

    void delete(Integer id);
}
