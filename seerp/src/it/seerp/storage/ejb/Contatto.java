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
     *
     */
    public Contatto() {
        
    }

    /**
     * costruttore
     * @param idUtente
     * @param username
     * @param password
     * @param citta
     * @param provincia
     * @param telefono
     * @param email
     * @param cap
     * @param ruol
     * @param note
     * @param v
     * @param cognome
     * @param nome
     * @param ragioneSociale
     * @param pIva
     * @param fax
     * @param ruolo
     * @param feedback
     */
    public Contatto(Integer idUtente, String username, String password, String citta, String ruol, String provincia, String telefono, String cap, String email, String ruolo, String note, Boolean v, String cognome, String nome, String ragioneSociale, String pIva, String fax, Integer feedback) {
        super(idUtente, username, password, citta, ruol, provincia, telefono, cap, email, ruolo, note, v, cognome, nome, ragioneSociale, pIva, fax);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contatto other = (Contatto) obj;
        if (this.feedback != other.feedback && (this.feedback == null || !this.feedback.equals(other.feedback))) {
            return false;
        }
        return true;
    }

   

}
