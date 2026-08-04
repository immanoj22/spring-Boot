package com.jobapp.service;

import com.jobapp.entity.JobApplicationEntity;
import com.jobapp.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobApplicationRepository jobApplicationRepository;


    public List<JobApplicationEntity> getAllJobs(){
        List<JobApplicationEntity>findedAllJob=jobApplicationRepository.findall();
        return findedAllJob;
    }

    public JobApplicationEntity getSpecificApplication(int applicationNo){
        return jobApplicationRepository.find(applicationNo);
    }

    public boolean SaveNewJOb(JobApplicationEntity jobApplicationEntity){
        return jobApplicationRepository.save(jobApplicationEntity);
    }

    public List<JobApplicationEntity> getSerachedResult(String searchValue){
        return jobApplicationRepository.searchedValue(searchValue);
    }
}
