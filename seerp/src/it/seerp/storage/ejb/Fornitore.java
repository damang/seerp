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
       
    }

}
