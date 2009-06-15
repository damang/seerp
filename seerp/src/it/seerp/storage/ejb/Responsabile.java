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

    public Responsabile(Integer idUtente, String username, String password, String città, String provincia, String telefono, String cap, String email, String note, String tipo, String cognome, String nome, String codiceFiscale, Ruolo ruolo, Boolean v) {
       super(idUtente, username, password, città, provincia, telefono, cap, email, note, tipo, cognome, nome, codiceFiscale, v, ruolo);
    }

}
