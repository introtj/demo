package com.example.demo1.repository;

import java.util.List;

import com.example.demo1.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
