package com.crud.operation.service;

import com.crud.operation.exception.ResourceFoundException;
import com.crud.operation.model.Job;
import com.crud.operation.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public Job saveJob(Job job) throws ResourceFoundException {
        Optional<Job> savedJob = jobRepository.findById(job.getId());
        if (savedJob.isPresent()) {
            throw new ResourceFoundException("Job already exist with given ID:" + job.getId());
        }

        return jobRepository.save(job);
    }


    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    public Job updateJob(Job job) {

        return jobRepository.save(job);
    }

    public Job getJobById(long id) throws ResourceFoundException {
        Optional<Job> job_new = jobRepository.findById(id);
        if (!job_new.isPresent()) {
            throw new ResourceFoundException("Resource Not Found!!!!");
        } else {
            return job_new.get();
        }
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
}
