package com.springboot.firstapp.controller;

import com.springboot.firstapp.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Jesther",
                "Costinar"
        );

        return ResponseEntity.ok(student);
    }

    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Jesther", "Costinar"));
        students.add(new Student(2, "Coolene", "Villones"));
        students.add(new Student(3, "Dhen", "Test"));

        return students;
    }

    // Spring BOOT REST API with Path Variable
    @GetMapping("/{id}/{first-name}/{last-name}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("first-name") String firstName,
                                       @PathVariable("last-name") String lastName) {
        return new Student(studentId, firstName, lastName);
    }

    // Use Request Mapping
    @GetMapping("/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    // Spring boot REST API that handles HTTP POST request
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }


    // Spring boot REST API that handles HTTP PUT request
    @PutMapping("/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int id,
                                @RequestBody Student student) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteMapping(@PathVariable("studentId") int id) {
        return ResponseEntity.ok("Student deleted successfully");
    }
}
