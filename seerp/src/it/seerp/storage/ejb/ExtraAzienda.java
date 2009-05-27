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
public class ExtraAzienda extends Utente {

    private Integer idExtraAzienda;
    private String cognome;
    private String nome;
    private String ragioneSociale;
    private String pIva;
    private String fax;
    private String ruolo;
    private ArrayList<Appuntamento> listAppuntamenti;
    private ArrayList<Contratto> listContratti;

    public ExtraAzienda(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, Integer idExtraAzienda, String cognome, String nome, String ragioneSociale, String pIva, String fax, String ruolo, ArrayList<Appuntamento> listAppuntamenti, ArrayList<Contratto> listContratti) {
        super(idUtente, username, password, città, provincia, telefono, email, note);
        this.idExtraAzienda = idExtraAzienda;
        this.cognome = cognome;
        this.nome = nome;
        this.ragioneSociale = ragioneSociale;
        this.pIva = pIva;
        this.fax = fax;
        this.ruolo = ruolo;
        this.listAppuntamenti = listAppuntamenti;
        this.listContratti = listContratti;
    }

    

    public ArrayList<Contratto> getListContratti() {
        return listContratti;
    }

    public void setListContratti(ArrayList<Contratto> listContratti) {
        this.listContratti = listContratti;
    }

    public ArrayList<Appuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    public void setListAppuntamenti(ArrayList<Appuntamento> listAppuntamenti) {
        this.listAppuntamenti = listAppuntamenti;
    }

    /**
     * restituisce il cognome dell'ExtraAzienda
     * @return una strinfa contenente il cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     *restituisce il numero di fax dell'ExtraAzienda
     * @return una stringa contenente il fax
     */
    public String getFax() {
        return fax;
    }

    /**
     *restituisce il codice identificativo dell'ExtraAzienda
     * @return un intero che rappresenta l'identificativo
     */
    public Integer getIdExtraAzienda() {
        return idExtraAzienda;
    }

    /**
     *restituisce il gnome dell'ExtraAzienda
     * @return una stringa contenente il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *restituisce il codice della partita iva dell'ExtraAzienda
     * @return una stringa contenente la partita iva
     */
    public String getPIva() {
        return pIva;
    }

    /**
     * restituisce la ragione sociale dell'ExtraAzienda
     * @return una stringa contenente la ragione sociale
     */
    public String getRagioneSociale() {
        return ragioneSociale;
    }

    /**
     * restituisce il ruolo dell'ExtraAzienda
     * @return una stringa contenente il ruolo
     */
    public String getRuolo() {
        return ruolo;
    }

    /**
     * setta il cognome dell'ExtraAzienda
     * @param cognome di tipo stringa
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * setta il numero di fax dell'ExtraAzienda
     * @param fax di tipo stringa
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * setta il codice identificativo dell'ExtraAzienda
     * @param idExtraAzienda di tipo intero
     */
    public void setIdExtraAzienda(Integer idExtraAzienda) {
        this.idExtraAzienda = idExtraAzienda;
    }

    /**
     * setta il nome dell'ExtraAzienda
     * @param nome di tipo stringa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * setta il codice di partita iva dell'ExtraAzienda
     * @param pIva di tipo stringa
     */
    public void setPIva(String pIva) {
        this.pIva = pIva;
    }

    /**
     *setta la ragione sociale dell'ExtraAzienda
     * @param ragioneSociale di tipo stringa
     */
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }

    /**
     * setta il ruolo dell'ExtraAzienda
     * @param ruolo di tipo stringa
     */
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
     public void removeAppuntamento(Appuntamento p){
     listAppuntamenti.remove(p);}
    public void addAppuntamento(Appuntamento p){
     listAppuntamenti.add(p);}
       public void removeContratto(Contratto c){
     listContratti.remove(c);}
    public void addContratto(Contratto c){
     listContratti.add(c);}

}
