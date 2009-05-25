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
