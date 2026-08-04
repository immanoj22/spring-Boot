package com.jobapp.repository;

import com.jobapp.entity.JobApplicationEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JobApplicationRepository {

    List<JobApplicationEntity>allJobsEntity=new ArrayList<>();


    public List<JobApplicationEntity> findall(){

//        List<JobApplicationEntity>alljob=new ArrayList<>();
        //write procedure for all finding
        return allJobsEntity;
    }

    public JobApplicationEntity find(int jobApplicationNumer){

        JobApplicationEntity jobApplicationEntity=allJobsEntity.stream().filter(entity->entity.getJobApplicationNumer()==jobApplicationNumer).findFirst().orElse(null);
        return jobApplicationEntity;
    }

    public boolean save(JobApplicationEntity jobApplicationEntity){

        if(allJobsEntity.contains(jobApplicationEntity)){
            return false;
        }
        allJobsEntity.add(jobApplicationEntity);
        return true;
    }

    public List<JobApplicationEntity> searchedValue(String searchValue){
        return allJobsEntity.stream().filter(entity->entity.getJobSkills().contains(searchValue)|| entity.getJobDiscription().contains(searchValue)).toList();
    }
}
