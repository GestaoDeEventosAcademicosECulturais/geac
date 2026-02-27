package br.com.geac.backend.aplication.dtos.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Set;

public record EventRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        String title,

        @NotBlank(message = "A descrição é obrigatória")
        String description,

        String onlineLink,

        @NotNull(message = "A data de início é obrigatória")
        @Future(message = "A data de início deve ser no futuro")
        LocalDateTime startTime,

        @NotNull(message = "A data de término é obrigatória")
        @Future(message = "A data de término deve ser no futuro")
        LocalDateTime endTime,

        @NotNull(message = "A carga horária é obrigatória")
        @Min(value = 1, message = "A carga horária deve ser de no mínimo 1 hora")
        Integer workloadHours,

        @NotNull(message = "A capacidade máxima é obrigatória")
        @Min(value = 1, message = "A capacidade deve ser de no mínimo 1 pessoa")
        Integer maxCapacity,

        @NotNull(message = "O ID da categoria é obrigatório")
        Integer categoryId,

        @NotNull(message = "O requisito do evento é obrigatório")
        Integer requirementId,

        @NotNull
        Set<Integer> tags,

        @NotNull
        //pode ser nulo, pois o evento pode ser online
        Integer locationId
) {
}
