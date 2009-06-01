/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che gestisce le informazioni sugli eventi di un agenda
 * @author Luisa
 */
public class Agenda {
    ArrayList<Evento> listEventi= new ArrayList<Evento>();
    Integer idAgenda;

    /**
     *  costruttore classe
     * @param idAgenda
     * @param listEventi
     */
    public Agenda(Integer idAgenda, ArrayList<Evento> listEventi) {
        this.idAgenda = idAgenda;
        this.listEventi=listEventi;
    }

    



    /**
     *  metodo che restituisce una lista di eventi
     * @return : lista di eventi
     */
    public ArrayList<Evento> getAgenda() {
        return listEventi;
    }

    /**
     *  metodo che setta una lisat di eventi
     * @param agenda lista di eventi
     */
    public void setAgenda(ArrayList<Evento> agenda) {
        this.listEventi = agenda;
    }

    /**
     * metodo che restituisce l'identificativo dell'agenda
     * @return identificativo dell'agenda
     */
    public Integer getIdAgenda() {
        return idAgenda;
    }

    /**
     *  metodo che setta l'identificativo dell'agenda
     * @param idAgenda identificativo agenda
     */
    public void setIdAgenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
    }
    /**
     * metodo che elemina un evento dalla lista degli eventi
     * @param evento da eliminare
     */
    public void removeEvento(Evento c){
     listEventi.remove(c);}
    /**
     * metodo che restituisce un evento dalla lista degli eventi
     * @param evento della lista eventi
     */
    public void addEvento(Evento c){
     listEventi.add(c);}

}
