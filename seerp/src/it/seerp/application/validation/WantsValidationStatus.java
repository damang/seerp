package it.seerp.application.validation;

public interface WantsValidationStatus {

    void validateFailed();

    void validatePassed();
}