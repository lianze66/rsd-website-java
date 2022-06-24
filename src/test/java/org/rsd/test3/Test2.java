package org.rsd.test3;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.rsd.bean.SysFunction;
import org.rsd.service.ISysFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test2 {

    @Autowired
    private ISysFunctionService sysFunctionService;

    @Test
    public void test1() throws JsonProcessingException {
        List<SysFunction> list = sysFunctionService.treeList();

        JsonMapper jsonMapper = new JsonMapper();
        String json = jsonMapper.writeValueAsString(list);

        System.out.println(json);
    }

    @Test
    public void test2() throws JsonProcessingException {
        List<SysFunction> list = sysFunctionService.treeList2();

        JsonMapper jsonMapper = new JsonMapper();
        String json = jsonMapper.writeValueAsString(list);

        System.out.println(json);
    }

}
