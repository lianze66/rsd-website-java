package org.rsd.test3;

import org.junit.jupiter.api.Test;
import org.rsd.bean.SysUser;
import org.rsd.mapper.ISysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:test.xml")
public class Test3 {

    @Autowired
    private ISysUserMapper sysUserMapper;

    @Test
    public void test1() {
        sysUserMapper.getClass();
    }

    @Test
    public void test2() {
        List<SysUser> sysUsers = sysUserMapper.queryList();
    }
}
