package dev.movie.Movieflix.controller;

import dev.movie.Movieflix.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class MovieController{

    @Autowired
    private final MovieService movieService;

}
