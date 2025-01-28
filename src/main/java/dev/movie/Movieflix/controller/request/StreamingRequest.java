package dev.movie.Movieflix.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record StreamingRequest(@NotEmpty(message = "Nome do Streaming é obrigatório.") String name){
}
