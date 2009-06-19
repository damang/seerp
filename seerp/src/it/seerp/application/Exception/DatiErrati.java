package it.seerp.application.Exception;

/**
 * Classe d'eccezione che viene lanciata in caso di dati errati
 * @author Luisa - Tommaso Cattolico
 */
public class DatiErrati extends RuntimeException {

    /**
     * Metodo che passa il messaggio d'errore al livello superiore
     * @param c Stringa d'errore
     */
    public DatiErrati(String c) {
        super(c);
    }
}
