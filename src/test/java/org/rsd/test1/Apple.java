package org.rsd.test1;

import org.junit.jupiter.api.*;
import org.rsd.controller.SysUserController;
import org.rsd.mapper.ISysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Apple {

    @Autowired
    private SysUserController sysUserController;

    @Autowired
    private ISysUserMapper sysUserMapper;

    @Test
    public void test0() {
        sysUserController.toUpdatePage(1);
    }

    @Test
    public void test1() {
        sysUserMapper.queryList();
    }


}
