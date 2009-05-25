/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Cliente extends ExtraAzienda {

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
