package com.spring.Boot.springBoot;

import com.spring.Boot.springBoot.Model.Student;
import com.spring.Boot.springBoot.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);

		Student student=context.getBean(Student.class);
		student.setStudent_id(33);
		student.setName("manfoj");
		student.setCollege_name("npr college");

		StudentService s=context.getBean(StudentService.class);
//		s.addNewStudent(student);

		System.out.println(s.getAllStudent().toString());
		for(Student stu:s.getAllStudent()){
			System.out.println("StudentId : "+stu.getStudent_id());
		}
	}

}
