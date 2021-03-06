package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 * classe per la gestione del bean Amministratore
 * @author matteo
 */
public class Amministratore extends Personale {

    private Azienda azienda;

    /**
     *
     */
    public Amministratore() {
        azienda=new Azienda();
    }

    /**
     *
     * @param idUtente
     * @param username
     * @param password
     * @param citta
     * @param provincia
     * @param telefono
     * @param cap
     * @param email
     * @param note
     * @param tipo
     * @param idPersonale
     * @param cognome
     * @param nome
     * @param codiceFiscale
     * @param ruolo
     * @param v
     */
    public Amministratore(Integer idUtente, String username, String password, String citta, String provincia, String telefono, String cap, String email, String note, String tipo, Integer idPersonale, String cognome, String nome, String codiceFiscale, Ruolo ruolo, Boolean v) {
        super(idUtente, username, password, citta, provincia, telefono, cap, email, note, tipo, cognome, nome, codiceFiscale, v, ruolo);
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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Amministratore other = (Amministratore) obj;
        if (this.azienda != other.azienda && (this.azienda == null || !this.azienda.equals(other.azienda))) {
            return false;
        }
        return true;
    }

    

}
