
package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * viene lanciata quando l'utente è già esistente nel database
 */
public class UtenteGiàEsistenteEx extends java.lang.RuntimeException{

    public UtenteGiàEsistenteEx() {
    }

    public UtenteGiàEsistenteEx(String msg) {
        super(msg);
    }

}
