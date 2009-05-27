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
    ArrayList<Evento> listEventi= new ArrayList<Evento>();
    Integer idAgenda;

    public Agenda(Integer idAgenda, ArrayList<Evento> listEventi) {
        this.idAgenda = idAgenda;
        this.listEventi=listEventi;
    }

    

    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }


    public ArrayList<Evento> getAgenda() {
        return listEventi;
    }

    public void setAgenda(ArrayList<Evento> agenda) {
        this.listEventi = agenda;
    }

    public Integer getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }
      public void removeServizio(Evento c){
     listEventi.remove(c);}
    public void addServizio(Evento c){
     listEventi.add(c);}

}
