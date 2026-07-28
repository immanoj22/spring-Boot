package com.springIntro.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {

    @Value("manoj")
    private String name;
    @Value("21")
    private int age;
    private Computer systemType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Computer getSystemType() {
        return systemType;
    }

    @Autowired
    @Qualifier("desktop")
    public void setSystemType(Computer systemType) {
        this.systemType = systemType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void compile(){
        systemType.compile();
    }
}
