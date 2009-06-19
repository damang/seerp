package it.seerp.application.Exception;

/**
 * Classe d'eccezione che viene lanciata in caso di cancellazione fallita
 * @author Luisa - Tommaso Cattolico
 */
public class CancellazioneFallita extends RuntimeException {

    /**
     * Metodo che passa il messaggio d'errore al livello superiore
     * @param c Stringa d'errore
     */
    public CancellazioneFallita(String c) {
        super(c);
    }
}
