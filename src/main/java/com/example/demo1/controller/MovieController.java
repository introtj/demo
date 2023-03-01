package com.example.demo1.controller;

import java.util.Optional;

import com.example.demo1.domain.Movie;
import com.example.demo1.service.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(path = "/hello")
    public String hello(@RequestParam(name = "message") String message) {
        return "Hello " + message;
    }


    @GetMapping(path = "/movies/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Movie getMovie(@PathVariable(name = "id") String id) {
        return this.movieService.getMovieById(id).get();
    }

    @GetMapping(path = "/movies", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Page<Movie> getMovies(Pageable pageable) {
        return this.movieService.getMovies(pageable);
    }
}
