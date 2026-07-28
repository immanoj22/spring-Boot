package com.spring.Boot.springBoot.Model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private long Student_id;
    private String name;
    private String college_name;
}
