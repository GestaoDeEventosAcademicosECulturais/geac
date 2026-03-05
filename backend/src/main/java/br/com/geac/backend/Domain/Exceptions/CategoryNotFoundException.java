package br.com.geac.backend.Domain.Exceptions;

public class CategoryNotFoundException extends BadRequestException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
