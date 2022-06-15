package org.rsd.service.impl;

import org.rsd.bean.SysUser;
import org.rsd.mapper.ISysUserMapper;
import org.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private ISysUserMapper sysUserMapper;

    @Override
    public List<SysUser> queryList() {
        return sysUserMapper.queryList();
    }

    @Override
    public SysUser getById(Integer id) {
        return sysUserMapper.getById(id);
    }
}
