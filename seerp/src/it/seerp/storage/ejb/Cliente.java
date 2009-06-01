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

    private Integer idCliente;

    public Cliente(Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti, Integer idCliente) {
        super(idUtente, username, password, città, ruol, provincia, telefono, email, ruolo, note, v, idExtraAzienda, cognome, nome, ragioneSociale, pIva, fax, listAppuntamenti, listContratti);
        this.idCliente = idCliente;
    }

    /**
     *
     * @param idUtente
     * @param username
     * @param password
     * @param città
     * @param provincia
     * @param telefono
     * @param email
     * @param ruol
     * @param note
     * @param v
     * @param idExtraAzienda
     * @param cognome
     * @param nome
     * @param ragioneSociale
     * @param pIva
     * @param fax
     * @param ruolo
     * @param listAppuntamenti
     * @param listContratti
     * @param idCliente
     */

    /**
     * restituisce il codice identificativo del Cliente
     * @return una stringa contenente il codice identificativo
     */
    public Integer getIdCliente() {
        return idCliente;
    }

    /**
     *setta il codice identificativo del Cliente
     * @param idCliente identificativo del cliente
     */
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }
}
