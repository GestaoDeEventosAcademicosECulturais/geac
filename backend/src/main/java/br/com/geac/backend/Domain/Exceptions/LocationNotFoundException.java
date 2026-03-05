package br.com.geac.backend.Domain.Exceptions;

public class LocationNotFoundException extends BadRequestException {
    public LocationNotFoundException(String message) {
        super(message);
    }
}
