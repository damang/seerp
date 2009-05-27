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

    public Cliente(Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, String ruolo, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idCliente) {
        super(idExtraAzienda, cognome, nome, ragioneSociale, pIva, fax, ruolo, listAppuntamenti, listContratti);
        this.idCliente = idCliente;
    }

    private Integer idCliente;
   
    /**
     * restituisce il codice identificativo del Cliente
     * @return una stringa contenente il codice identificativo
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     *setta il codice identificativo del Cliente
     * @param idCliente di tipo int
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
    

}
