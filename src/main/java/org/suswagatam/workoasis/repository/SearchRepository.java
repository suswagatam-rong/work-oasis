package org.suswagatam.workoasis.repository;

import org.suswagatam.workoasis.models.JobPost;

import java.util.List;

public interface SearchRepository {
    List<JobPost> findByText(String text);
}