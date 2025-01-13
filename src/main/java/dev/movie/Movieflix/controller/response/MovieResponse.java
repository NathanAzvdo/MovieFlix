package dev.movie.Movieflix.controller.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id, String name, String description, double rating,
                            List<CategoryResponse> categoriesId, List<StreamingResponse> streamings,
                            LocalDate releaseDate) {
}
