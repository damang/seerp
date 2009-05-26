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
public class Agenda {
    ArrayList<Evento> agenda= new ArrayList<Evento>();
    Integer idAgenda;

    public ArrayList<Evento> getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList<Evento> agenda) {
        this.agenda = agenda;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }

}
