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
public class Personale extends Utente {

    private Integer idPersonale;
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private String tipo;
    private ArrayList<Permesso> listPermessi;
    private ArrayList<Ruolo> listRuoli;

    public Personale(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v) {
        super(idUtente, username, password, città, provincia, telefono, email, note,v );
        this.idPersonale = idPersonale;
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.tipo = tipo;
        this.listPermessi = listPermessi;
        this.listRuoli = listRuoli;
    }

    
     
    public ArrayList<Permesso> getListaPermessi() {
        return listPermessi;
    }

    public void setListaPermessi(ArrayList<Permesso> listaPermessi) {
        this.listPermessi = listaPermessi;
    }

    public ArrayList<Ruolo> getListaRuoli() {
        return listRuoli;
    }

    public void setListaRuoli(ArrayList<Ruolo> listaRuoli) {
        this.listRuoli = listaRuoli;
    }

   /**
     * setta il codice fiscale del personale
     * @param codiceFiscale di tipo stringa
     */
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * setta il cognome del personale
     * @param cognome di tipo stringa
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * setta il nome del personale
     * @param nome di tipo stringa
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *setta il tipo di personale
     * @param tipo di tipo string
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * restituisce il codice fiscale del personale
     * @return una stringa che contiene il codice fiscale
     */
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    /**
     *restituisce il cognome del personale
     * @return una stringa contenente il cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * restituisce il nome del personale
     * @return una stringa contenente il nome
     */
    public String getNome() {
        return nome;
    }

    /**
     *restituisce il tipo di personale
     * @return restituisce una stringa contente il tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * setta il codice identificativo del personale
     * @param idPersonale di tipo intero
     */
    public void setIdPersonale(Integer idPersonale) {
        this.idPersonale = idPersonale;
    }

     /**
      * restituisce il codice identificativo del personale
      * @return un intero che rappresenta l'identificativo
      */
     public Integer getIdPersonale() {
        return idPersonale;
    }
       public void removeRuolo(Ruolo c){
     listRuoli.remove(c);}
    public void addRuolo(Ruolo c){
     listRuoli.add(c);}
   public void removePermesso(Permesso c){
     listPermessi.remove(c);}
    public void addPermesso(Permesso c){
     listPermessi.add(c);}
}
