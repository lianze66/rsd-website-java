package org.rsd.dao;

import org.rsd.bean.Student;

import java.util.List;

public interface IStudentDAO {

    List<Student> queryList();

    Student getById(Integer id);

    void insert(Student student);

    void update(Student student);

    void delete(Integer id);

}
