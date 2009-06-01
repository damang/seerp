package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class Amministratore extends Personale {

    private Integer idAmministratore;

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
     * @param listPermessi
     * @param listRuoli
     * @param v
     * @param idAmministratore
     */
    public Amministratore(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, String ruolo, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idAmministratore) {
        super(idUtente, username, password, città, provincia, telefono, email, note, ruolo, idPersonale, cognome, nome, codiceFiscale, tipo, listPermessi, listRuoli, v);
        this.idAmministratore = idAmministratore;
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
