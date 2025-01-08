package dev.movie.Movieflix.controller.response;


import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}
