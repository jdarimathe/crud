package com.crud.operation.repository;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import org.springframework.stereotype.Repository;


@Repository
public class JobRepository {
    private Cluster cluster;
    private Bucket bucket;


    public JobRepository(){
        //Creates a connection to the CouchBase cluster
        cluster = Cluster.connect("couchbase://localhost", "Administrator", "password");
        //Specifies the name of the bucket to work out of
        bucket = cluster.bucket("JobBucket");
    }

    public Bucket getBucket() {
        return bucket;
    }
}



