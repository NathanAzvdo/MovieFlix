package dev.movie.Movieflix.service;

import dev.movie.Movieflix.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService{

    @Autowired
    private MovieRepository movieRepository;

}
