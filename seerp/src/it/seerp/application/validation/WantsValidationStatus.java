package it.seerp.application.validation;

/**
 *
 * @author LesAnge
 */
public interface WantsValidationStatus {

    /**
     *
     */
    void validateFailed();

    /**
     *
     */
    void validatePassed();
}