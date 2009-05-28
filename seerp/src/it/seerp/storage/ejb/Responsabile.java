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

    public Responsabile(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idResponsabile) {
        super(idUtente, username, password, città, provincia, telefono, email, note, ruolo, idPersonale, cognome, nome, codiceFiscale, tipo, listPermessi, listRuoli, v);
        this.idResponsabile = idResponsabile;
    }

  

   private Integer idResponsabile;

    /**
     * restituisce l'idetificatore del Responsabile
     * @return un intero che rappresenta l'id del Responsabile
     */
    public Integer getIdResponsabile() {
        return idResponsabile;
    }

    /**
     * setta il codice identificativo del Responsabile
     * @param idResponsabile di tipo int
     */
    public void setIdResponsabile(Integer idResponsabile) {
        this.idResponsabile = idResponsabile;
    }

}
