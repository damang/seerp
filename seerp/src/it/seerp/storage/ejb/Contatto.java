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

    private Integer idContatto;
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
    public Contatto(Integer idUtente, String username, String password, String città, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, Integer idContatto, Integer feedback) {
        super(idUtente, username, password, città, ruol, provincia, telefono, cap, email, ruolo, note, v, idExtraAzienda, cognome, nome, ragioneSociale, pIva, fax);
        this.idContatto = idContatto;
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
     * restituisce il codice identificativo di un Contatto
     * @return una stringa contente il codice
     */
    public Integer getIdContatto() {
        return idContatto;
    }

    /**
     * setta il feedback associato ad un Contatto
     * @param feedback di tipo int
     */
    public void setFeedback(Integer feedback) {
        this.feedback = feedback;
    }

    /**
     * setta il codice identificativo del Contatto
     * @param idContatto di tipo int
     */
    public void setIdContatto(Integer idContatto) {
        this.idContatto = idContatto;
    }
}
