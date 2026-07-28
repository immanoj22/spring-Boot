package com.springIntro.Controller;

import com.springIntro.Model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringIntroApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringIntroApplication.class, args);
//		Laptop lap= (Laptop) context.getBean(Computer.class);
//		lap.compile();

		Employee employee=context.getBean(Employee.class);
		employee.compile();
	}

}
