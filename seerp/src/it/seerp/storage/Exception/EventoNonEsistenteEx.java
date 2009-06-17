

package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * è lanciata nel caso in cui si vanno a fare operazioni di modifica o cancellazione
 * su un evento non esistente nel database
 */
public class EventoNonEsistenteEx extends RuntimeException{

    /**
     *
     */
    public EventoNonEsistenteEx() {
    }

    /**
     *
     * @param msg
     */
    public EventoNonEsistenteEx(String msg) {
        super(msg);
    }

}
