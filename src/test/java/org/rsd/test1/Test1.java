package org.rsd.test1;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.rsd.bean.SysUser;
import org.rsd.controller.SysUserController;
import org.rsd.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
