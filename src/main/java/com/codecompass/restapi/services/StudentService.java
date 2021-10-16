package com.codecompass.restapi.services;

import com.codecompass.restapi.models.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private Student student;
    private List<Student> studentList = new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

//    Student generateStudentData(){
//        Student std = new Student(10,"Shabbir","Hassan","CS");
//        studentList.add(std);
//        return studentList;
//    }

    public Student addStudent(Student student){
        studentList.add(student);
        return student;
    }

    public List<Student> getAllStudent(){
        return this.studentList;
    }



}
