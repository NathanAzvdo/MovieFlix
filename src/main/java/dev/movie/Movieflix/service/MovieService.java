package dev.movie.Movieflix.service;

import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.entity.Movie;
import dev.movie.Movieflix.entity.Streaming;
import dev.movie.Movieflix.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Movie> findById(Long id){
        return movieRepository.findById(id);
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Optional<Movie> update(Long movieId, Movie updatedMovie){
        Optional<Movie> optionalMovie = movieRepository.findById(movieId);
        if(optionalMovie.isPresent()){

            List<Category> categories = this.findCategories(updatedMovie.getCategories());
            List<Streaming> streamings = this.findStreaming(updatedMovie.getStreamings());

            Movie movie = optionalMovie.get();
            movie.setName(updatedMovie.getName());
            movie.setReleaseDate(updatedMovie.getReleaseDate());

            movie.getStreamings().clear();
            movie.setStreamings(streamings);

            movie.setRating(updatedMovie.getRating());

            movie.getCategories().clear();
            movie.setCategories(categories);

            movie.setDescription(updatedMovie.getDescription());


            return Optional.of(movieRepository.save(movie));
        }
        return Optional.empty();
    }

    public List<Movie> findByCategories(Long categoryId){
        return movieRepository.findMovieByCategories(List.of(Category.builder().id(categoryId).build()));
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

    public void deleteMovie(Long id){
        movieRepository.deleteById(id);
    }



}
