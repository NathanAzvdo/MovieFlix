package dev.movie.Movieflix.controller.request;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record MovieRequest(String name, String description,
                           LocalDate releaseDate, double rating,
                           Optional<List<Long>> categoriesId,
                           Optional<List<Long>> streamingsId)
{

}
