
package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * viene lanciata quando l'utente è già esistente nel database
 */
public class UtenteGiaEsistenteEx extends Exception{

    /**
     *
     */
    public UtenteGiaEsistenteEx() {
    }

    /**
     *
     * @param msg
     */
    public UtenteGiaEsistenteEx(String msg) {
        super(msg);
    }

}
