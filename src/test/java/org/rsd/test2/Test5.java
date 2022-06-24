package org.rsd.test2;

import org.junit.jupiter.api.Test;
import org.rsd.bean.SysFunction;
import org.rsd.mapper.ISysFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:test.xml")
public class Test5 {

    @Autowired
    private ISysFunctionMapper functionMapper;

    List<SysFunction> list = null;
    void tt(Integer parentId) {
        list = functionMapper.getListByParentId(parentId);
        for (SysFunction sysFunction : list) {
            List<SysFunction> childList = functionMapper.getListByParentId(sysFunction.getId());
            sysFunction.setChildList(childList);
            if (childList != null && !childList.isEmpty()) {
                for (SysFunction function : childList) {
                    tt(function.getId());
                }
            }
        }
    }

    @Test
    public void test() {
        tt(0);
        System.out.println(list);
    }
}
