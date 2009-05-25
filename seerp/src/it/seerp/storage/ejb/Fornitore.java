/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Fornitore extends ExtraAzienda {

    private Integer idFornitore;

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
