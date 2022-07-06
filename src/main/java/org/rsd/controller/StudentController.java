package org.rsd.controller;

import org.rsd.bean.Student;
import org.rsd.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping("list")
    public List<Student> list() {
        return studentService.queryList();
    }

    @GetMapping("detail/{id}")
    public Student detail(@PathVariable Integer id) {
        return studentService.getById(id);
    }

    @PostMapping("insert")
    public void insert(Student student) {
        studentService.insert(student);
    }

    @PostMapping("update")
    public void update(Student student) {
        studentService.update(student);
    }
}
