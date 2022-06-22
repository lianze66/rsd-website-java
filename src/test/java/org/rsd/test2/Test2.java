package org.rsd.test2;

import org.junit.jupiter.api.Test;
import org.rsd.bean.Student;
import org.rsd.dao.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

@SpringJUnitConfig
@ContextConfiguration("classpath:spring.xml")
public class Test2 {

    @Autowired
    private IStudentDAO studentDAO;

    @Test
    public void test1() {
        List<Student> list = studentDAO.queryList();
        System.out.println(list);
    }

    @Test
    public void test2() {
        Student student = studentDAO.getById(2);
        System.out.println(student);
    }

    @Test
    public void test3() {
        Student student = new Student();
        student.setName("小李");
        student.setAge(15);
        studentDAO.insert(student);
    }
}
