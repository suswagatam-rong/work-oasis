package org.suswagatam.workoasis.repository;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;
import org.suswagatam.workoasis.models.JobPost;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImplementation implements SearchRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<JobPost> findByText(String text) {
        final List<JobPost> jobPosts = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("suswagatam");
        MongoCollection<Document> collection = database.getCollection("jobLists");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                        new Document("$search",
                        new Document("index", "default")
                        .append("text",
                        new Document("query", text)
                        .append("path", Arrays.asList("desc", "skills", "profile")))),
                        new Document("$sort",
                        new Document("exp", 1L)),
                        new Document("$limit", 5L)));

        result.forEach(document -> jobPosts.add(mongoConverter.read(JobPost.class, document)));
        return jobPosts;
    }
}