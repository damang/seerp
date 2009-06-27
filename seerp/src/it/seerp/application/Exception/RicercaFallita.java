package it.seerp.application.Exception;

/**
 * Classe d'eccezione che viene lanciata in caso di ricerca fallita
 * @author Luisa - Tommaso Cattolico
 */
public class RicercaFallita extends Exception {

    /**
     * Metodo che passa il messaggio d'errore al livello superiore
     * @param c Stringa d'errore
     */
    public RicercaFallita(String c) {
        super(c);
    }
}
