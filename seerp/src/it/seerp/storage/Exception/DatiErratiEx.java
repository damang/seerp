
package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * lanciata quando si inseriscono dati errati in un inserimento o modifica
 * utente,servizio,evento,contratti fornitore
 */
public class DatiErratiEx extends java.lang.RuntimeException {
    /**
     *
     * @param msg
     */
    public DatiErratiEx(String  msg){
    super(msg);
    }
}
