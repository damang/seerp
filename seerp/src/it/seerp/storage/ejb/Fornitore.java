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

      /**
       *
       */
      public Fornitore() {
        
    }

    /**
     *
     * @param idUtente
     * @param username
     * @param password
     * @param citta
     * @param ruol
     * @param provincia
     * @param telefono
     * @param cap
     * @param email
     * @param ruolo
     * @param note
     * @param v
     * @param cognome
     * @param nome
     * @param ragioneSociale
     * @param pIva
     * @param fax
     */
    public Fornitore(Integer idUtente, String username, String password, String citta, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, String cognome, String nome, String ragioneSociale, String pIva, String fax) {
        super(idUtente, username, password, citta, ruol, provincia, telefono, cap, email, ruolo, note, v, cognome, nome, ragioneSociale, pIva, fax);
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
