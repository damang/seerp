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

    public Responsabile(Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listp, ArrayList<Ruolo> listr, Integer idResponsabile) {
        super(idPersonale, cognome, nome, codiceFiscale, tipo, listp, listr);
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
