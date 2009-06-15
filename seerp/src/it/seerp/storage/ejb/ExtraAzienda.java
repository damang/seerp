package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bran ExtraAzienda
 * @author matteo
 */
public class ExtraAzienda extends Utente {

    private String cognome;
    private String nome;
    private String ragioneSociale;
    private String pIva;
    private String fax;
    private String tipo;
    private ArrayList<Appuntamento> listAppuntamenti;
    private ArrayList<Contratto> listContratti;

    public ExtraAzienda() {
        
    }


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
     * @param idExtraAzienda
     * @param cognome
     * @param nome
     * @param ragioneSociale
     * @param pIva
     * @param fax
     * @param ruolo
     * @param v
     */

    public ExtraAzienda(Integer idUtente, String username, String password, String citta, String tipo,String provincia, String telefono,String cap, String email, String ruolo, String note, Boolean v, String cognome, String nome, String ragioneSociale, String pIva, String fax) {
        super(idUtente, username, password, citta, provincia, telefono,cap, email, ruolo, note, v);

        this.cognome = cognome;
        this.nome = nome;
        this.ragioneSociale = ragioneSociale;
        this.pIva = pIva;
        this.fax = fax;
        this.tipo = tipo;
        this.listAppuntamenti = new ArrayList<Appuntamento>();
        this.listContratti = new ArrayList<Contratto>();
    }

   

    /**
     * restituisce la lista dei contratti associati ad un extraazienda
     * @return la lista dei contrattia ssociatia d un extraazienda
     */
    public ArrayList<Contratto> getListContratti() {
        return listContratti;
    }

    /**
     * setta la lista di contratti associatia d un extraazienda
     * @param listContratti lista di contratti associatia d un extraazienda
     */
    public void setListContratti(ArrayList<Contratto> listContratti) {
        this.listContratti = listContratti;
    }

    /**
     * restuisce la lista di appuntamenti associatia d un extraazienda
     * @param listAppuntamenti lista di appuntamenti associatia d un extraazienda
     */
    public ArrayList<Appuntamento> getListAppuntamenti() {
        return listAppuntamenti;
    }

    /**
     * setta la lista di appuntamenti associatia d un extraazienda
     * @param listAppuntamenti lista di appuntamenti associatia d un extraazienda
     */
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
        return tipo;
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
        this.tipo = ruolo;
    }
    /**
     *  * metodo che rimuove un appuntamento alla lista contratti
      * @param c appuntamento di un extraazienda da eliminare dalla lista
     */
    public void removeAppuntamento(Appuntamento p){
     listAppuntamenti.remove(p);}
     /**
           * metodo che aggiunge un pagamento alla lista contratti
      * @param p appuntamento di un extraazienda da aggiungere alla lista
      */
     public void addAppuntamento(Appuntamento p){
     listAppuntamenti.add(p);}
     /**
      * metodo che rimuove un contratto alla lista contratti
      * @param c contratto di un extraazienda da eliminare dalla lista
      */
     public void removeContratto(Contratto c){
     listContratti.remove(c);}
     /**
      * metodo che aggiunge un contratto alla lista contratti
      * @param c contartto di un extraazienda da aggiungere alla lista
      */
     public void addContratto(Contratto c){
     listContratti.add(c);}


}