# spring-Boot

This is my learning repo for Spring Boot. Each folder is a separate Maven project where I tried out one topic. They are practice code, not finished products, and some are only a starter skeleton.

## Folders
- `springIntro`: Spring Boot starter with a few model classes (Computer, Laptop, Desktop, Employee) for trying dependency injection
- `springBoot_01`: Spring JDBC with PostgreSQL, using model, repository and service classes
- `spring_boot_web_02`: a plain servlet project (HelloServlet) on embedded Tomcat, no Spring Boot
- `srpingBoot_web_03`: first Spring MVC web app with a greeting controller and a JSP page
- `springDataJpa_01`: Spring Data JPA with PostgreSQL. A job application entity with REST endpoints to add, update, delete, get one, search, and list with paging
- `JopApp_01`: job listing app with JSP views (home, form, all jobs, job page) and a JPA repository
- `spring_security_01`: Spring Security with JWT. Register (`/security/v1/authentication/newUser`) and login endpoints, a JWT filter, a custom user details service, DTO mapper and a global exception handler. There is also a zip copy of this project in the root
- `projects_Spring_boot_01/ecoomerce_Sring_boot_P1`: an e-commerce project I started. So far it has the Cart classes, response helpers and an empty application class

## Tech
Java 17, Spring Boot 4.1, Maven, Spring MVC, JDBC, Spring Data JPA, Spring Security, JWT (jjwt), PostgreSQL, JSP, Lombok.

## Running a project
You need JDK 17 and, for the database ones, PostgreSQL. The datasource settings are in each `application.properties` (database `Manoj`, user `postgres`). Set `spring.datasource.password` to your own value, and for `spring_security_01` also set your own `jwt.secret` (a Base64 string).

```
cd springDataJpa_01
./mvnw spring-boot:run
```

## Notes
The folder names have some typos from when I created them and I have not renamed them. The more complete examples are `springDataJpa_01`, `JopApp_01` and `spring_security_01`; for a larger project see my other repos.

Database and token settings come from the environment: `DB_PASSWORD` and `JWT_SECRET`.
