package br.com.geac.backend.Domain.Exceptions;

public class RequirementNotFoundException extends BadRequestException {
    public RequirementNotFoundException(String message) {
        super(message);
    }
}
