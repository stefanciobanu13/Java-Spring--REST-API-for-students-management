package com.students.rest.service;

import com.students.rest.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentService {

    public List<Student> getStudents();
    public Student getStudent(int id);
    public void saveStudent(Student student);
    public void deleteStudent(int id);






}



