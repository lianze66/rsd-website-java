package org.rsd.controller;

import org.rsd.bean.Student;
import org.rsd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("student")
@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @ResponseBody
    @GetMapping("list")
    public List<Student> list() {
        return studentService.queryList();
    }

    @ResponseBody
    @PostMapping("insert")
    public void insert(Student student) {
        studentService.insert(student);
    }
}
