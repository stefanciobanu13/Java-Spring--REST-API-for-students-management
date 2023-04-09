package com.students.rest.controller;


import com.students.rest.entity.Student;
import com.students.rest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

        private StudentService studentService;

        @Autowired
        public RestController(StudentService studentService) {
            this.studentService = studentService;
        }

        // expose "/employees" and return list of employees
        @GetMapping("/students")
        public List<Student> findAll() {
            return studentService.getStudents();
        }

        // add mapping for GET /employees/{employeeId}

        @GetMapping("/students/{studentId}")
        public Student getStudent(@PathVariable int studentId) {

            Student theStudent = studentService.getStudent(studentId);

            if (theStudent == null) {
                throw new RuntimeException("Student id not found - " + studentId);
            }

            return theStudent;
        }

        // add mapping for POST /employees - add new employee

        @PostMapping("/students")
        public Student addEmployee(@RequestBody Student theStudent) {

            // also just in case they pass an id in JSON ... set id to 0
            // this is to force a save of new item ... instead of update

            theStudent.setId(0);

            studentService.saveStudent(theStudent);

            return theStudent;
        }

        // add mapping for PUT /employees - update existing employee

        @PutMapping("/students")
        public Student updateEmployee(@RequestBody Student theStudent) {

            studentService.saveStudent(theStudent);

            return theStudent;
        }

        // add mapping for DELETE /employees/{employeeId} - delete employee

        @DeleteMapping("/students/{studentId}")
        public String deleteStudent(@PathVariable int studentId) {

            Student tempStudent = studentService.getStudent(studentId);

            // throw exception if null

            if (tempStudent == null) {
                throw new RuntimeException("Employee id not found - " + studentId);
            }

            studentService.deleteStudent(studentId);

            return "Deleted Student id - " + studentId;
        }








}
