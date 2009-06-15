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
public class Cliente extends ExtraAzienda {

    public Cliente() {
        
    }

  

    /**
     * 
     * @param idUtente
     * @param username
     * @param password
     * @param città
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
    public Cliente(Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, String cognome, String nome, String ragioneSociale, String pIva, String fax) {
        super(idUtente, username, password, città, ruol, provincia, telefono, cap, email, ruolo, note, v, cognome, nome, ragioneSociale, pIva, fax);
     
    }


}
