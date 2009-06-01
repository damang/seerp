/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class Dipendente extends Personale {

    private Integer idDipendente;
    private ArrayList<Appuntamento> listAppuntamenti;
    private ArrayList<Contratto> listContratti;

    /**
     *
     * @param idUtente
     * @param username
     * @param password
     * @param città
     * @param provincia
     * @param telefono
     * @param email
     * @param note
     * @param ruolo
     * @param idPersonale
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param tipo
     * @param listPermessi
     * @param listRuoli
     * @param v
     * @param idDipendente
     * @param listAppuntamenti
     * @param listContratti
     */


    public Dipendente(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idDipendente, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti) {
        super(idUtente, username, password, città, provincia, telefono, email, note, ruolo, idPersonale, cognome, nome, codiceFiscale, tipo, listPermessi, listRuoli, v);

        this.idDipendente = idDipendente;
        this.listAppuntamenti = listAppuntamenti;
        this.listContratti = listContratti;
    }


    /**
     * metodo che setta la lista di contratti associati ad un dipendente
     * @param listContratti  la lista di contratti associati ad un dipendente
     */
    

   

  

     public void setListContratti(ArrayList<Contratto> listContratti) {

        this.listContratti = listContratti;
    }

    /**
     * metodo che setta la lista di contratti associati ad un dipendente
     * @return la lista di contratti associati ad un dipendente
     */
    public ArrayList<Contratto> getListContratti() {
        return listContratti;
    }

    /**
     * metodo che restituisce la lista degli appuntamenti associati ad un dipendente
     * @return appuntamenti associati ad un dipendente
     */
    public ArrayList<Appuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    /**
     * metodo che setta la lista degli appuntamenti associati ad un dipendente
     * @param listAppuntamenti appuntamenti associati ad un dipendente
     */
    public void setListAppuntamenti(ArrayList<Appuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

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

    /**
     *  * metodo che rimuove un appuntamento alla lista contratti
     * @param c appuntamento di un extraazienda da eliminare dalla lista
     */
    public void removeAppuntamento(Appuntamento p) {
        listAppuntamenti.remove(p);
    }

    /**
     * metodo che aggiunge un pagamento alla lista contratti
     * @param p appuntamento di un extraazienda da aggiungere alla lista
     */
    public void addAppuntamento(Appuntamento p) {
        listAppuntamenti.add(p);
    }

    /**
     * metodo che rimuove un contratto alla lista contratti
     * @param c contratto di un extraazienda da eliminare dalla lista
     */
    public void removeContratto(Contratto c) {
        listContratti.remove(c);
    }

    /**
     * metodo che aggiunge un contratto alla lista contratti
     * @param c contartto di un extraazienda da aggiungere alla lista
     */
    public void addContratto(Contratto c) {
        listContratti.add(c);
    }
}
