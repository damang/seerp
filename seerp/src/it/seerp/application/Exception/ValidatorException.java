package it.seerp.application.Exception;

/**
 * Eccezione lanciata per i validator
 * @author Tommaso Cattolico
 */
public class ValidatorException extends RuntimeException{

    /**
     *
     * @param c
     */
    public ValidatorException(String c) {
        super(c);
    }
}
