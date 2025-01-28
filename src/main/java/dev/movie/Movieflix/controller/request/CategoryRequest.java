package dev.movie.Movieflix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CategoryRequest(@NotEmpty(message = "Nome da Categoria é obrigatório.") String name) {
}
