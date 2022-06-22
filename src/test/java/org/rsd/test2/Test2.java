package org.rsd.test2;

import org.junit.jupiter.api.Test;
import org.rsd.bean.Diary;
import org.rsd.dao.IDiaryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test2 {

    @Autowired
    private IDiaryDAO diaryDAO;

    @Test
    public void test1() {
        List<Diary> list = diaryDAO.queryList();
        System.out.println(list);
    }

    @Test
    public void test2() {
        Diary diary = diaryDAO.getById(1);
        System.out.println(diary);
    }

    @Test
    public void test3() {
        Diary diary = new Diary();
        diary.setTitle("AAAAAAA");
        diary.setContent("bbbbbbbbbbb");

        diaryDAO.insert(diary);
    }
}
