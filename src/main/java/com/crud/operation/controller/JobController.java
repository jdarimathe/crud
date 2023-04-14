package com.crud.operation.controller;

import com.crud.operation.model.Job;
import com.crud.operation.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/create")
    public String createJob(@RequestBody Job job)  {
        jobService.saveJob(job);

        return "Job created with id: " + job.getId();
    }

    @GetMapping(value = "/read/{id}")
    public Job getJob(@PathVariable String id){
        return jobService.getJobById(id);
    }


    @PutMapping("/job/{id}")
    public String updateJobs(@RequestBody Job job) {
        jobService.updateJob(job);
        return "Job updated  with id: " + job.getId();
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteJobs (@PathVariable String id){
        jobService.deleteJob(id);

        return "Job deleted  with id: " + id;

    }
}
