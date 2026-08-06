package com.springdata.springDataJpa_01.Service;

import com.springdata.springDataJpa_01.Entity.JobApplicationEntity;
import com.springdata.springDataJpa_01.Hooks.JobApplicationHook;
import com.springdata.springDataJpa_01.Repository.JobAppllicationRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {

    @Autowired
    JobAppllicationRespository jobAppllicationRespository;

    @Autowired
    JobApplicationHook jobApplicationHook;

    public JobApplicationEntity addnewJob(JobApplicationEntity jobApplicationEntity){
        return jobApplicationHook.addJob(jobApplicationEntity);
    }

    public JobApplicationEntity editJob(JobApplicationEntity jobApplicationEntity){
        return jobApplicationHook.updateJob(jobApplicationEntity);
    }

    public List<JobApplicationEntity> findallJobs(int page){
        int limit=20;
        int offset=(page-1)*limit > 0 ? (page-1)*limit : 0;
        System.out.println("offset"+limit+" "+offset);
        return  jobApplicationHook.findAllJob(limit,offset);
    }

    public JobApplicationEntity getJob(long jobId){
        return jobApplicationHook.findJob(jobId);
    }

    public String remove(long jobid) {
        boolean status=jobApplicationHook.removeJob(jobid);

        if(status){
            return "Deleted job successfully";
        }

        return "Failled deleting";
    }

    public List<JobApplicationEntity> search(String value) {
        return jobApplicationHook.search(value);
    }
}
