package com.grace.resumechallenge.repositories;

import com.grace.resumechallenge.models.Resume;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepo extends CrudRepository<Resume,Long> {
}

