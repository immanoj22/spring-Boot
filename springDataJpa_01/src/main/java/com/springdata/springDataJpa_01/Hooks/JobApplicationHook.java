package com.springdata.springDataJpa_01.Hooks;


import com.springdata.springDataJpa_01.Entity.JobApplicationEntity;
import com.springdata.springDataJpa_01.Repository.JobAppllicationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JobApplicationHook  {

    @Autowired
    JobAppllicationRespository jobAppllicationRespository;

    public JobApplicationEntity addJob(JobApplicationEntity jobApplicationEntity){
        return jobAppllicationRespository.save(jobApplicationEntity);
    }

    public JobApplicationEntity updateJob(JobApplicationEntity jobApplicationEntity){
        Optional<JobApplicationEntity> jobApplicationEntity1=jobAppllicationRespository.findById(jobApplicationEntity.getJobId());

        JobApplicationEntity findedJobApplicationEntity=jobApplicationEntity1.orElse(new JobApplicationEntity());

        if(findedJobApplicationEntity.getJobId()!=null){
            findedJobApplicationEntity=jobAppllicationRespository.save(jobApplicationEntity);

        }
        return findedJobApplicationEntity;
    }


    public List<JobApplicationEntity> findAllJob(int limit,int offset) {
        return jobAppllicationRespository.findAllJobs(limit,offset);
    }

    public JobApplicationEntity findJob(long jobId) {
        return jobAppllicationRespository.findById(jobId).orElse(new JobApplicationEntity());
    }

    public boolean removeJob(long jobId){
        JobApplicationEntity jobApplicationEntity=findJob(jobId);
        if(jobApplicationEntity.getJobId()!=null){
            jobAppllicationRespository.delete(jobApplicationEntity);
            return true;
        }
        return false;
    }

    public List<JobApplicationEntity> search(String value) {
        return jobAppllicationRespository.searchValue(value);
    }
}
