package dev.movie.Movieflix.repository;

import dev.movie.Movieflix.entity.Category;
import dev.movie.Movieflix.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

    List<Movie> findMovieByCategories(List<Category> categories);
}
