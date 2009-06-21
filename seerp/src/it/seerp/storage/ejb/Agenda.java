package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe che gestisce le informazioni sugli eventi di un agenda
 * @author Luisa-Matteo - Tommaso Cattolico
 */
public class Agenda {

    private ArrayList<Evento> listEventi;
    private Integer idAgenda;
    private Utente utente;

    /**
     * Costruttore vuoto
     */
    public Agenda() {
    }

    /**
     * Costruttore di classe
     * @param idAgenda
     */
    public Agenda(Integer idAgenda) {
        this.idAgenda = idAgenda;
        listEventi = new ArrayList<Evento>();
    }

    /**
     * Costruttore di classe
     * @param idAgenda
     * @param user
     */
    public Agenda(Integer idAgenda, Utente user) {
        this.idAgenda = idAgenda;
        listEventi = new ArrayList<Evento>();
        this.utente = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agenda other = (Agenda) obj;
        if (this.listEventi != other.listEventi && (this.listEventi == null || !this.listEventi.equals(other.listEventi))) {
            return false;
        }
        if (this.idAgenda != other.idAgenda && (this.idAgenda == null || !this.idAgenda.equals(other.idAgenda))) {
            return false;
        }
        if (this.utente != other.utente && (this.utente == null || !this.utente.equals(other.utente))) {
            return false;
        }
        return true;
    }

    /**
     * metodo che permette di restituire la lista degli eventi associati all'agenda
     * @return la lista degli eventi
     */
    public ArrayList<Evento> getListEventi() {
        return listEventi;
    }

    /**
     * metodo che permette di settare la lista degli eventi associati all'agenda
     * @param listEventi rappresenta la lista degli eventi
     */
    public void setListEventi(ArrayList<Evento> listEventi) {
        this.listEventi = listEventi;
    }

    /**
     *  metoco che permette di restituire la informazioni dell'utente associato
     * all'agenda
     * @return le informazioni dell'utente
     */
    public Utente getUtente() {
        return utente;
    }

    /**
     * metodo che permette di settare le informazioni relative
     * all'utente associato all'agenda
     * @param utente rappresenta l'utente
     */
    public void setUtente(Utente utente) {
        this.utente = utente;
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
     * @param c
     */
    public void removeEvento(Evento c) {
        listEventi.remove(c);
    }

    /**
     * metodo che restituisce un evento dalla lista degli eventi
     * @param c
     */
    public void addEvento(Evento c) {
        listEventi.add(c);
    }
}
