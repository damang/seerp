/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.ejb;

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

}
