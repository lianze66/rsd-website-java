package org.rsd.service;

import org.rsd.bean.Student;

import java.util.List;

public interface IStudentService {

    List<Student> queryList();

    Student getById(Integer id);

    void insert(Student student);

    void update(Student student);

    void delete(Integer id);
}
