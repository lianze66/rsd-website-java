package org.rsd.test1;

import org.junit.jupiter.api.Test;
import org.rsd.controller.SysUserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration(locations = "classpath:spring.xml")
public class Test1 {

    @Autowired
    private SysUserController sysUserController;

    @Test
    public void test01() {
        sysUserController.toUpdatePage(1);
    }
}
