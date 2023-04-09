package com.students.rest.service;


import com.students.rest.entity.Student;
import com.students.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


private StudentRepository studentRepository;

@Autowired
public StudentServiceImpl(StudentRepository studentRepository){
    this.studentRepository=studentRepository;
}


    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(int id) {

        Optional optionalStudent = studentRepository.findById(id);
        Student tempStudent  = (Student)optionalStudent.get();

        return tempStudent;
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {

    }
}
