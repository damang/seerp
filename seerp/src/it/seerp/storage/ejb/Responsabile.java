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
public class Responsabile extends Personale {

    /**
     *
     */
    public Responsabile() {
        
    }

    /**
     *
     * @param idUtente
     * @param username
     * @param password
     * @param citta
     * @param provincia
     * @param telefono
     * @param cap
     * @param email
     * @param note
     * @param tipo
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param ruolo
     * @param v
     */
    public Responsabile(Integer idUtente, String username, String password, String citta, String provincia, String telefono, String cap, String email, String note, String tipo, String cognome, String nome, String codiceFiscale, Ruolo ruolo, Boolean v) {
       super(idUtente, username, password, citta, provincia, telefono, cap, email, note, tipo, cognome, nome, codiceFiscale, v, ruolo);
    }

}
