/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

/**
 *
 * @author matteo
 */
public class Permesso {

    private Integer idPermesso;
    private String Nome;

    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @return
     */
    public Integer getIdPermesso() {
        return idPermesso;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    /**
     * 
     * @param idPermesso
     */
    public void setIdPermesso(Integer idPermesso) {
        this.idPermesso = idPermesso;
    }



}
