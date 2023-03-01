package com.example.demo1.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo1.domain.Comment;
import com.example.demo1.domain.Movie;
import com.example.demo1.exception.ResourceNotFoundException;
import com.example.demo1.repository.CommentRepository;
import com.example.demo1.repository.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CommentRepository commentRepository;

    public MovieService(MovieRepository movieRepository,
                        CommentRepository commentRepository) {
        this.movieRepository = movieRepository;
        this.commentRepository = commentRepository;
    }

    public Movie getMovieById(String id) {
        return this.movieRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found movie."));
    }

    public Page<Movie> getMovies(Pageable pageable) {
        return this.movieRepository.findAll(pageable);
    }
}
