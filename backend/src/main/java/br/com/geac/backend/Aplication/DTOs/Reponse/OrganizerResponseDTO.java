package br.com.geac.backend.Aplication.DTOs.Reponse;

import java.util.UUID;

public record OrganizerResponseDTO(
        UUID id,
        String name,
        String contactEmail
) {
}