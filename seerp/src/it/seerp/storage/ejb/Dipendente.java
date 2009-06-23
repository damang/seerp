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

    private ArrayList<Appuntamento> listAppuntamenti;
    private ArrayList<Contratto> listContratti;

    /**
     *
     */
    public Dipendente() {
        
    }

     /**
     *
     * @param idUtente
     * @param username
     * @param password
      * @param citta
      * @param provincia
     * @param telefono
     * @param email
      * @param cap
      * @param note
     * @param ruolo
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param tipo
     * @param v
     */

    public Dipendente(Integer idUtente, String username, String password, String citta, String provincia, String telefono, String cap, String email, String note, String tipo, String cognome, String nome, String codiceFiscale, Ruolo ruolo, Boolean v) {
        super(idUtente, username, password, citta, provincia, telefono, cap, email, note, tipo, cognome, nome, codiceFiscale, v, ruolo);
        this.listAppuntamenti= new  ArrayList<Appuntamento>();
        this.listContratti= new ArrayList<Contratto>();

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
     *  * metodo che rimuove un appuntamento alla lista contratti
     * @param p
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
