package com.jobapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobApplicationEntity {
    private int jobApplicationNumer;
    private String jobSpecification;
    private String jobDiscription;
    private LocalDate jobOpenFrom;
    private LocalDate jobCloseAt;
    private List<String> jobSkills;
    private int expirence;
}
