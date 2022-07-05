package org.rsd.service.impl;

import org.rsd.bean.Student;
import org.rsd.dao.IStudentDAO;
import org.rsd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDAO studentDAO;

    @Override
    public List<Student> queryList() {
        return studentDAO.queryList();
    }
}
