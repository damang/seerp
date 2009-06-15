/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Contatto extends ExtraAzienda {

    private Integer feedback;

    /**
     * costruttore
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
     * @param idContatto
     * @param feedback
     */
    public Contatto(Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, String cognome, String nome, String ragioneSociale, String pIva, String fax, Integer feedback) {
        super(idUtente, username, password, città, ruol, provincia, telefono, cap, email, ruolo, note, v, cognome, nome, ragioneSociale, pIva, fax);
        this.feedback = feedback;
    }

    /**
     * restituisce il feedback associato al Contatto
     * @return un intero che rappresenti il feedback
     */
    public Integer getFeedback() {
        return feedback;
    }

   

    /**
     * setta il feedback associato ad un Contatto
     * @param feedback di tipo int
     */
    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

}
