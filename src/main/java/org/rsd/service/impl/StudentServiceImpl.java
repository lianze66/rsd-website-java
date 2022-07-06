package org.rsd.service.impl;

import org.rsd.bean.Student;
import org.rsd.dao.IStudentDAO;
import org.rsd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> queryList() {
        return studentDAO.queryList();
    }

    @Override
    public Student getById(Integer id) {
        return studentDAO.getById(id);
    }

    @Override
    public void insert(Student student) {
        student.setCreateTime(new Date());
        studentDAO.insert(student);
    }

    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }
}
