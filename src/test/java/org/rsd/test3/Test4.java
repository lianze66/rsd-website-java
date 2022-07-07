package org.rsd.test3;

import org.junit.jupiter.api.Test;
import org.rsd.bean.NewsInfo;
import org.rsd.service.INewsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test4 {

    @Autowired
    private INewsInfoService newsInfoService;

    @Test
    public void test1() {
        List<NewsInfo> list = newsInfoService.queryList();
        System.out.println(list);
    }
}
