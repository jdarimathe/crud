package com.crud.operation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Job {

    private String id;
    private String jobName;
    private String jobDescription;
    private String jobLocation;
    private String jobType;
}
