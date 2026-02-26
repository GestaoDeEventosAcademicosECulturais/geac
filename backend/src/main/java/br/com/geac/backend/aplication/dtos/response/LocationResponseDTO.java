package br.com.geac.backend.aplication.dtos.response;

public record LocationResponseDTO (
        Integer id,
        String name,
        String street,
        String number,
        String neighborhood,
        String city,
        String state,
        String zipCode,
        String referencePoint,
        Integer capacity){
}
