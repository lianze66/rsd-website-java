package org.rsd.test2;

import org.junit.jupiter.api.Test;
import org.rsd.controller.SysUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private SysUserController sysUserController;

    @Test
    public void test1() {
        sysUserController.toUpdatePage(1);
    }

    @Test
    public void test2() {
        sysUserController.list(1);
    }

    @Test
    public void test3() {
        sysUserController.delete(29);
    }
}
