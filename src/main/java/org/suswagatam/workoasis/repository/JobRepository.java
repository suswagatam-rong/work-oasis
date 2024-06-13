package org.suswagatam.workoasis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.suswagatam.workoasis.models.JobPost;

// takes care of the CRUD operations for our MongoDB database
public interface JobRepository extends MongoRepository<JobPost, String> {

}