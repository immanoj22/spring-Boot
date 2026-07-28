package com.spring.Boot.springBoot.Repository;

import com.spring.Boot.springBoot.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {

    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc){
        this.jdbc=jdbc;
    }

    public JdbcTemplate getJdbc(){
        return jdbc;
    }

    public void save(Student stu){
        String sql="Insert into student values(?,?,?)";
        int rowsAffected=jdbc.update(sql,stu.getStudent_id(),stu.getName(),stu.getCollege_name());
        System.out.println("The new Student is saved");
    }

    public List<Student> findAll(){
        String sql="SELECT * From student";
//        List<Student> list=new ArrayList<>();

        RowMapper<Student> rowmapper=(rs,rownum)-> {
            System.out.println("rowNum : "+rownum);
            Student stu=new Student();
            stu.setCollege_name(rs.getString("college_name"));
            stu.setName(rs.getString("name"));
            stu.setStudent_id(rs.getInt("Student_id"));
            return stu;
        };
        return jdbc.query(sql,rowmapper);
//        return list;
    }
}
