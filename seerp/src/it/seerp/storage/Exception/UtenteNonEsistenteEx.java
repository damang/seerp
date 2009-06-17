

package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 * viene lanciata quando si vuole effettuare una operazione su un utente non
 * esistente nel database
 */
public class UtenteNonEsistenteEx extends RuntimeException{
    /**
     *
     */
    public UtenteNonEsistenteEx() {
    }

    /**
     *
     * @param msg
     */
    public UtenteNonEsistenteEx(String msg) {
        super(msg);
    }

}
