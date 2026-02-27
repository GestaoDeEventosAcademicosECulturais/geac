package br.com.geac.backend.aplication.dtos.request;

import jakarta.validation.constraints.NotBlank;

public record TagRequestDTO(
        @NotBlank(message = "O nome da tag não pode ser vazio")
        String name
) {}