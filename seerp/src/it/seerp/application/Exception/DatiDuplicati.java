package it.seerp.application.Exception;

/**
 * Classe d'eccezione che viene lanciata in caso di dati duplicati
 * @author Luisa - Tommaso Cattolico
 */
public class DatiDuplicati extends RuntimeException {

    /**
     * Metodo che passa il messaggio d'errore al livello superiore
     * @param c Stringa d'errore
     */
    public DatiDuplicati(String c) {
        super(c);
    }
}
