package com.spring.Boot.springBoot.Service;

import com.spring.Boot.springBoot.Model.Student;
import com.spring.Boot.springBoot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public void setStudentRepository(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public StudentRepository getStudentRepository(){
        return studentRepository;
    }
    public void addNewStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }


}
