package org.rsd.test3;

import org.junit.jupiter.api.Test;
import org.rsd.bean.SysFunction;
import org.rsd.mapper.ISysFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test1 {

    @Autowired
    private ISysFunctionMapper sysFunctionMapper;

    void ss(List<SysFunction> rootList) {
        rootList.forEach(sysFunction -> {
            List<SysFunction> childList = sysFunctionMapper.getListByParentId(sysFunction.getId());
            if (childList != null && !childList.isEmpty()) {
                sysFunction.setChildList(childList);
                ss(childList);
            }
        });
    }

    @Test
    void tt() {
        List<SysFunction> rootList = sysFunctionMapper.getListByParentId(0);
        ss(rootList);
        System.out.println(rootList);
    }

}
