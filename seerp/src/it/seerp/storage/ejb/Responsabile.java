/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Responsabile extends Personale {

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
