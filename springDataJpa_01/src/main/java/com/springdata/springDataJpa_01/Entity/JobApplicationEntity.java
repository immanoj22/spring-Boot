package com.springdata.springDataJpa_01.Entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobId;

    private String companyName;

    private String url;

    private int minExp;

    private int maxExp;

    private Long ctc;

    private String category;
}
