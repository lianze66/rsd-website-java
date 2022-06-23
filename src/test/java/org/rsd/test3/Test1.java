package org.rsd.test3;

import org.junit.jupiter.api.Test;
import org.rsd.mapper.ISysUserMapper;
import org.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private ISysUserService sysUserService;

}
