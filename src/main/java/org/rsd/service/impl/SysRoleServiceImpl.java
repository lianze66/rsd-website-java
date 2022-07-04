package org.rsd.service.impl;

import org.rsd.bean.SysRole;
import org.rsd.mapper.ISysRoleMapper;
import org.rsd.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private ISysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> querList() {
        return sysRoleMapper.querList();
    }

    @Override
    public SysRole getById(Integer id) {
        return sysRoleMapper.getById(id);
    }

    @Override
    public void insert(SysRole sysRole) {
        sysRole.setCreateTime(new Date());
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public void update(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }

    @Override
    public void delete(Integer id) {
        sysRoleMapper.delete(id);
    }
}
