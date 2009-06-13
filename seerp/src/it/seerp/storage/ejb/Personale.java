package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Personale
 * @author matteo
 */
public class Personale extends Utente {

    private Integer idPersonale;
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private String tipo;
    private ArrayList<Ruolo> listRuoli;


    /**
     * Costruttore per la classe Personale
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
     * @param v
     */
    public Personale(Integer idUtente, String username, String password, String città, String provincia, String telefono,String cap, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, Boolean v) {
        super(idUtente, username, password, città, provincia, telefono,cap,email, note, ruolo, v );
        this.idPersonale = idPersonale;
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.tipo = tipo;
        this.listRuoli = new ArrayList<Ruolo>();
    }

    /**
     * metodo che permette di restituire la liste dei ruoli del personale
     * @return la lista dei ruoli
     */
    public ArrayList<Ruolo> getListaRuoli() {
        return listRuoli;
    }

    /**
     * metodo che permette di settare la liste dei ruoli del personale
     * @param listRuoli rappresenta la lista dei ruoli
     */
    public void setListRuoli(ArrayList<Ruolo> listRuoli) {
        this.listRuoli = listRuoli;
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

     /**
      * metodo che permette di rimuovere un ruolo dalla lista dei ruoli di un personale
      * @param c rappresenta il ruolo da rimuovere
      */
     public void removeRuolo(Ruolo c){
     listRuoli.remove(c);}

     /**
      * metodo che permette di aggiungere un ruolo alla lista dei ruoli di un personale
      * @param c rappresenta il ruolo da inserire
      */
     public void addRuolo(Ruolo c){
     listRuoli.add(c);}
     
}
