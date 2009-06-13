package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Amministratore
 * @author matteo
 */
public class Amministratore extends Personale {

    private Integer idAmministratore;
    private Azienda azienda;

    public Amministratore(Integer idUtente, String username, String password, String città, String provincia, String telefono, String cap, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, Boolean v, Integer idAmministratore) {
        super(idUtente, username, password, città, provincia, telefono, cap, email, note, ruolo, idPersonale, cognome, nome, codiceFiscale, tipo, v);
        this.idAmministratore = idAmministratore;
    }

    /**
     * costruttore
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
     * @param idAmministratore
     */
   

    /**
     * metodo che permette di restituire le informazioni relative all'azienda
     * @return le informazioni dell'azienda
     */
    public Azienda getAzienda() {
        return azienda;
    }

    /**
     * metoco che permette di settare le informazioni relative all'azienda
     * @param azienda rappresenta le informazioni dell'azienda
     */
    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    /**
     * restituisce il codice identificativo dell'Amministratore
     * @return il codice identificativo di un amministratore
     */
    public Integer getIdAmministratore() {
        return idAmministratore;
    }

    /**
     * setta il codice identificativo dell'Amministatore
     * @param idAmministratore di un amministratore
     */
    public void setIdAmministratore(Integer idAmministratore) {
        this.idAmministratore = idAmministratore;
    }
}
