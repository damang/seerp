
package it.seerp.storage.Exception;

/**
 *
 * @author Ila
 *
 * viene lanciata quando l'utente è già esistente nel database
 */
public class UtenteGiàEsistente extends java.lang.RuntimeException{

    public UtenteGiàEsistente() {
    }

    public UtenteGiàEsistente(String msg) {
        super(msg);
    }

}
