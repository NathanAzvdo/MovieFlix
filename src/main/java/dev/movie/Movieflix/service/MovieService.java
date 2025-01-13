package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.entity.Movie;
import dev.movie.Movieflix.entity.Streaming;
import dev.movie.Movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService{

    private final MovieRepository movieRepository;
    private final CategoryService categoryService;
    private final StreamingService streamingService;

    public MovieService(MovieRepository movieRepository, CategoryService categoryService, StreamingService streamingService) {
        this.movieRepository = movieRepository;
        this.categoryService = categoryService;
        this.streamingService = streamingService;
    }

    public Movie save(Movie newMovie){
        newMovie.setCategories(this.findCategories(newMovie.getCategories()));
        newMovie.setStreamings(this.findStreaming(newMovie.getStreamings()));
        return movieRepository.save(newMovie);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    private List<Category> findCategories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();
        categories.forEach(category -> {
            System.out.println("Buscando categoria com ID: " + category.getId());
            categoryService.findById(category.getId())
                    .ifPresentOrElse(categoriesFound::add,
                            () -> System.out.println("Categoria com ID " + category.getId() + " não encontrada!"));
        });
        return categoriesFound;
    }


    private List<Streaming> findStreaming(List<Streaming> streamings){
        List<Streaming> streamingsFound = new ArrayList<>();
        streamings.forEach(streaming -> {
            System.out.println("Buscando streaming com ID: " + streaming.getId());
            streamingService.getById(streaming.getId())
                    .ifPresentOrElse(streamingsFound::add,
                            () -> System.out.println("Streaming com ID " + streaming.getId() + " não encontrado!"));
        });
        return streamingsFound;
    }


}
