package com.codecompass.restapi.controllers;

import com.codecompass.restapi.models.Student;
import com.codecompass.restapi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("student")
public class controller {

    @Autowired()
    StudentService ss = new StudentService();

    @GetMapping("/")
    public String index(){
       ss.addStudent(new Student(10,"Khan","Mohsin","CE"));
        ss.addStudent(new Student(10,"Shabbir","HASSAN","IT"));
        ss.addStudent(new Student(20,"WAZIR","HASSAN","CS"));
        ss.addStudent(new Student(30,"TANWIR","HASSAN","CS"));
        ss.addStudent(new Student(40,"HSSAN","HASSAN","CS"));
        ss.addStudent(new Student(50,"AFREEN","HASSAN","CS"));
        ss.addStudent(new Student(60,"SHAHNAAZ","HASSAN","CE"));
        ss.addStudent(new Student(70,"NAAZ","HASSAN","CE"));
        ss.addStudent(new Student(80,"SHABN","HASSAN","CE"));
        return "<html><h1>This is RESP API OF STUDENT MANAGEMENT<br></h1><p>To add Student : localhost:8080/addStudent</p>" +
                "<p>To list all Student : localhost:8080/listStudent</p></html>" ;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student std=ss.addStudent(student);

        return new ResponseEntity<Student>(std, HttpStatus.OK);
    }

    @GetMapping("/listStudent")
    public List<Student> getAllStudent(){
        return ss.getAllStudent();
    }

    @GetMapping("/listStudent/{dept}")
    public List<Student> getAllByDepartment(@PathVariable  String dept){
        List<Student> studentList = ss.getAllStudent();
        List<Student> studentListByDept = studentList.stream().filter(student->dept.toLowerCase()
                        .contains(student.getDept().toLowerCase())).collect(Collectors.toList());
        System.out.println("Department from client side : " + dept);
        return studentListByDept;
        }

}


