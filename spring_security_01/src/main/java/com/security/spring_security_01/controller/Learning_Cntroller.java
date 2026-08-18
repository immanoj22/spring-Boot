package com.security.spring_security_01.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/security/v1")
public class Learning_Cntroller {

    List<Student>allstudent=new ArrayList<>(List.of(
            new Student(2,"kanna",33),
            new Student(4,"sur",45),
            new Student(1,"manoj",23)
    ));

    @GetMapping("/hello")
    public String helloFrmSprnig(HttpServletRequest httpServletRequest){
        return "hello "+httpServletRequest.getSession().getId();
    }

    @GetMapping("/csrf-token")
    public CsrfToken getcsrf(HttpServletRequest httpServletRequest){
        CsrfToken csrfToken= (CsrfToken) httpServletRequest.getAttribute(CsrfToken.class.getName());
        System.out.println(csrfToken);
        return csrfToken ;
    }

    @GetMapping("/getallstudent")
    public List<Student> getallStudent(){
        return allstudent;
    }

    @PostMapping("/addStudent")
    public List<Student> addstudent(@RequestBody Student newStudent){
        allstudent.add(newStudent);
        return allstudent;
    }


}
