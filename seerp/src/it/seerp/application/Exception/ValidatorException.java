package it.seerp.application.Exception;

/**
 * Classe d'eccezione che viene lanciata per i validator
 * @author Tommaso Cattolico
 */
public class ValidatorException extends Exception {

    /**
     * Metodo che passa il messaggio d'errore al livello superiore
     * @param c Stringa d'errore
     */
    public ValidatorException(String c) {
        super(c);
    }
}
