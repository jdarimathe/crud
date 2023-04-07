package com.crud.operation.repository;

import  com.crud.operation.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface JobRepository extends JpaRepository<Job, Long> {
    }

