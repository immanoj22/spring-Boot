package com.springdata.springDataJpa_01.Controller;

import com.springdata.springDataJpa_01.Entity.JobApplicationEntity;
import com.springdata.springDataJpa_01.Service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobProcessingController {

    @Autowired
    JobApplicationService jobApplicationService;

    @PostMapping("job")
    public JobApplicationEntity addJob(@RequestBody JobApplicationEntity jobApplicationEntity){
        return jobApplicationService.addnewJob(jobApplicationEntity);
    }

    @PutMapping("job")
    public JobApplicationEntity editJob(@RequestBody JobApplicationEntity jobApplicationEntity){
        return jobApplicationService.editJob(jobApplicationEntity);
    }

    @GetMapping("jobs/{page}")
    public List<JobApplicationEntity> allJobs(@PathVariable("page") int pageNumber){
        return jobApplicationService.findallJobs(pageNumber);
    }

    @GetMapping("job")
    public JobApplicationEntity getjob(@RequestParam("jobId") long jobid){
        return jobApplicationService.getJob(jobid);
    }

    @DeleteMapping("job")
    public String remove(@RequestParam("jobId") long jobid){
        return jobApplicationService.remove(jobid);
    }

    @GetMapping("job/search")
    public List<JobApplicationEntity> search(@RequestParam("search") String value){
        return jobApplicationService.search(value);
    }
}
