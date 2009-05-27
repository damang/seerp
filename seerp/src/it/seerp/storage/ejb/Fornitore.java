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

    public Fornitore(Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, String ruolo, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idFornitore) {
        super(idExtraAzienda, cognome, nome, ragioneSociale, pIva, fax, ruolo, listAppuntamenti, listContratti);
        this.idFornitore = idFornitore;
    }

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
