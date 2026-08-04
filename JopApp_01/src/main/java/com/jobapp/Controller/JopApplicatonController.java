package com.jobapp.Controller;

import com.jobapp.entity.JobApplicationEntity;
import com.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.util.List;

@Controller
public class JopApplicatonController {

    @Autowired
    JobService jobService;

    @GetMapping("/getAllJobs")
    public String getAllJobListng(Model model){
        List<JobApplicationEntity> alljobs = jobService.getAllJobs();
        model.addAttribute("jobs", alljobs == null ? java.util.Collections.emptyList() : alljobs);
        return "AllJobPage";
    }

    @GetMapping("/getJob")
    public String getJob(@RequestParam int applicationNo, Model model){
        System.out.println("heyy"+applicationNo);
        JobApplicationEntity jobApplicationEntity=jobService.getSpecificApplication(applicationNo);
        model.addAttribute("job", jobApplicationEntity==null?new JobApplicationEntity() : jobApplicationEntity);
        return "Job";
    }



    @PostMapping("/addNewJob")
    public String postNewJob(JobApplicationEntity newJob) {
        boolean status=jobService.SaveNewJOb(newJob);
        System.out.println(status);
        if(status){
            return "Home";
        };

        return "Failled";
    }

    @GetMapping({"/","/home"})
    public String defaultPage(){
//        return jobService.getAllJobs();
        System.out.println("in home");
        return "Home";
    }



    @GetMapping("/ApplicationForm")
    public String getForm(){
//        return jobService.getAllJobs();
        return "Form";
    }

    @GetMapping("/search")
    public String getSearchedItem(@RequestParam String searchValue,Model model){
        List<JobApplicationEntity>searchedResult=jobService.getSerachedResult(searchValue);
        model.addAttribute("searchedResult",searchedResult == null ? java.util.Collections.emptyList() : searchedResult);
        return "serachREsult";
    }
}
