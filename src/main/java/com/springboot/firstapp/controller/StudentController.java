package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "Jesther",
                "Costinar"
        );

        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jesther", "Costinar"));
        students.add(new Student(2, "Coolene", "Villones"));
        students.add(new Student(3, "Dhen", "Test"));

        return students;
    }

    // Spring BOOT REST API with Path Variable
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId) {
        return new Student(studentId, "Jes", "Costinar");
    }
}
