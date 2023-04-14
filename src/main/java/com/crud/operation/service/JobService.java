package com.crud.operation.service;

import com.couchbase.client.java.kv.GetResult;
import com.crud.operation.model.Job;
import com.crud.operation.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private static JobRepository jobRepository = new JobRepository();

    public void saveJob(Job job) {
        jobRepository.getBucket().defaultCollection().upsert(job.getId(), job);

    }

    public Job getJobById(String id) {
        GetResult getResult = jobRepository.getBucket().defaultCollection().get(id);

        Job job = new Job();

        job.setId(getResult.contentAsObject().get("id").toString());
        job.setJobDescription(getResult.contentAsObject().get("jobDescription").toString());
        job.setJobLocation(getResult.contentAsObject().get("jobLocation").toString());
        job.setJobName(getResult.contentAsObject().get("jobName").toString());
        job.setJobType(getResult.contentAsObject().get("jobType").toString());

        return job;
    }

    public void updateJob(Job job) {
        jobRepository.getBucket().defaultCollection().replace(job.getId(), job);
    }

    public void deleteJob(String id){
        jobRepository.getBucket().defaultCollection().remove(id);
    }
}
