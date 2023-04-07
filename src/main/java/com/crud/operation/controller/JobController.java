package com.crud.operation.controller;

import com.crud.operation.exception.ResourceFoundException;
import com.crud.operation.model.Job;
import com.crud.operation.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getJobs();
    }


    @PostMapping("/job")
    public ResponseEntity<Job> saveJob(@RequestBody Job job) throws ResourceFoundException {
        return new ResponseEntity<Job>(jobService.saveJob(job), HttpStatus.CREATED);
    }

    @PutMapping("/job/{id}")
    public ResponseEntity<Job> updateJobs(@RequestBody Job job, @PathVariable("id") long id)  {
        job.setId(id);
        return new ResponseEntity<Job>(jobService.updateJob(job),HttpStatus.CREATED);
    }

    @DeleteMapping("/job/{id}")
    public ResponseEntity<String> deleteJobs(@PathVariable("id") long id) {
        jobService.deleteJob(id);
        return new ResponseEntity<String>("Deleted",HttpStatus.OK);

    }
}
