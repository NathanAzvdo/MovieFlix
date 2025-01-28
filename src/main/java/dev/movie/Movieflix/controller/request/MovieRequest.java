package dev.movie.Movieflix.controller.request;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public record MovieRequest(
        @NotEmpty(message = "O título é obrigatório.")
        String name,

        @NotEmpty(message = "A descrição é obrigatória.")
        @Size(min = 10, message = "A descrição deve ter no mínimo 10 caracteres.")
        String description,

        @NotNull(message = "A data de lançamento é obrigatória.")
        @PastOrPresent(message = "A data de lançamento não pode ser no futuro.")
        LocalDate releaseDate,

        @Positive(message = "A avaliação deve ser um número positivo.")
        double rating,

        Optional<List<Long>> categoriesId,

        Optional<List<Long>> streamingsId
) {}
