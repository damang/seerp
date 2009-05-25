/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Dipendente extends Personale{

    private Integer idDipendente;
  

    /**
     *  restituisce il codice identificativo del Dipendente
     * @return una stringa contenente l'identificativo del Dipendente
     */
    public Integer getIdDipendente() {
        return idDipendente;
    }

    /**
     * setta il codice identificativo del Dipendente
     * @param idDipendente di tipo int
     */
    public void setIdDipendente(Integer idDipendente) {
        this.idDipendente = idDipendente;
    }



}
