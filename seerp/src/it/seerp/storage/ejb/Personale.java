package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Personale
 * @author matteo
 */
public class Personale extends Utente {

    private String cognome;
    private String nome;
    private String codiceFiscale;
    private String tipo;
    private Ruolo ruolo;

    /**
     *
     */
    public Personale() {
        
    }


    /**
     * Costruttore per la classe Personale
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
    public Personale(Integer idUtente, String username, String password, String citta, String provincia, String telefono,String cap, String email, String note, String tipo, String cognome, String nome, String codiceFiscale, Boolean v, Ruolo ruolo) {
        super(idUtente, username, password, citta, provincia, telefono,cap,email, note, tipo, v );
        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.ruolo = ruolo;
    }

    /**
     * metodo che permette di restituire la liste dei ruoli del personale
     * @return la lista dei ruoli
     */
    public Ruolo getRuolo() {
        return ruolo;
    }

    /**
     * metodo che permette di settare la liste dei ruoli del personale
     * @param ruolo
     */
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
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
}
