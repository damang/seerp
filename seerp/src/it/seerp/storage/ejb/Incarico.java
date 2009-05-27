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


    public Incarico(Integer personale, Integer permesso, Integer ruolo) {
        this.personale = personale;
        this.permesso = permesso;
        this.ruolo = ruolo;
    }

    public Integer getPermesso() {
        return permesso;
    }

    public void setPermesso(Integer permesso) {
        this.permesso = permesso;
    }

    public Integer getPersonale() {
        return personale;
    }

    public void setPersonale(Integer personale) {
        this.personale = personale;
    }

    public Integer getRuolo() {
        return ruolo;
    }

    public void setRuolo(Integer ruolo) {
        this.ruolo = ruolo;
    }

}
