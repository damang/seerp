/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public class Incarico {
 private Integer personale;
 private Integer permesso;
 private Integer ruolo;


 /**
  *
  * @param personale
  * @param permesso
  * @param ruolo
  */
 public Incarico(Integer personale, Integer permesso, Integer ruolo) {
        this.personale = personale;
        this.permesso = permesso;
        this.ruolo = ruolo;
    }

    /**
     * metodo che restituisce permesso legato all'incarico
     * @return permesso legato all'incarico
     */
    public Integer getPermesso() {
        return permesso;
    }

    /**
     * metodo che restituisce il permesso legato all incarico
     * @param permesso legato all'inarico
     */
    public void setPermesso(Integer permesso) {
        this.permesso = permesso;
    }

    /**
     * metodo che resttuisce identificativo del personale
     * @return personale dell'incarico
     */
    public Integer getPersonale() {
        return personale;
    }

    /**
     * metodo che restituisce l'identificativo del personale legato a quell'incarico
     * @param personale l'identificativo del personale legato a quell'incarico
     */
    public void setPersonale(Integer personale) {
        this.personale = personale;
    }

    /**
     * metodo che restituisce il ruolo di quell' incarico
     * @return ruolo dell'incarico
     */
    public Integer getRuolo() {
        return ruolo;
    }

    /**
      * metodo che restituisce l'id del ruolo di quell' incarico
     * @return ruolo dell'incarico
     */
    public void setRuolo(Integer ruolo) {
        this.ruolo = ruolo;
    }

}
