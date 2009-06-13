/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class Fornitore extends ExtraAzienda {
      private Integer idFornitore;

    public Fornitore(Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, Integer idFornitore) {
        super(idUtente, username, password, città, ruol, provincia, telefono, cap, email, ruolo, note, v, idExtraAzienda, cognome, nome, ragioneSociale, pIva, fax);
        this.idFornitore = idFornitore;
    }

   



   

   

    /**
     * restituisce il codice identificativo del Fornitore
     * @return un intero che rappresenta l'identificativo
     */
    public Integer getIdFornitore() {
        return idFornitore;
    }

    /**
     * setta il codice identificativo del Fornitore
     * @param idFornitore di tipo int
     */
    public void setIdFornitore(Integer idFornitore) {
        this.idFornitore = idFornitore;
    }

}
