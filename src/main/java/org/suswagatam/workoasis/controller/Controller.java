package org.suswagatam.workoasis.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.suswagatam.workoasis.repository.JobRepository;
import org.suswagatam.workoasis.models.JobPost;
import org.suswagatam.workoasis.repository.SearchRepository;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.List;

/*
    Spring MVC - fetches all the job posts using the POST method
 */
@RestController
public class Controller {

    // Spring creates an object for you and handles the things
    @Autowired
    JobRepository jobRepository;

    @Autowired
    SearchRepository searchRepository;

    // when home directory is fetched, this will redirect it to the Swagger UI
    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    // Fetches all the job posts
    @GetMapping("/posts")
    public List<JobPost> getAllPosts() {
        // uses Spring Data MongoDB to fetch data
        return jobRepository.findAll();
    }

    @GetMapping("/posts/{text}")
    public List<JobPost> searchThroughKeyword(@PathVariable String text) {
        return searchRepository.findByText(text);
    }

    @PostMapping("/job-post")
    public JobPost addJob(@RequestBody JobPost post) {
        return jobRepository.save(post);
    }
}