/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Amministratore extends Personale {

    private Integer idAmministratore;
   

    /**
     * restituisce il codice identificativo dell'Amministratore
     * @return il codice identificativo di un Cliente
     */
    public Integer getIdAmministratore() {
        return idAmministratore;
    }

    /**
     * setta il codice identificativo dell'Amministatore
     * @param idAmministratore di tipo int
     */
    public void setIdAmministratore(Integer idAmministratore) {
        this.idAmministratore = idAmministratore;
    }


}
