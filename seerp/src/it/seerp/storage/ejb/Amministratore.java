
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class Amministratore extends Personale {

    public Amministratore(Integer idUtente, String username, String password, String città, String provincia, String telefono, String email, String note, Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listPermessi, ArrayList<Ruolo> listRuoli, Boolean v, Integer idAmministratore) {
        super(idUtente, username, password, città, provincia, telefono, email, note, idPersonale, cognome, nome, codiceFiscale, tipo, listPermessi, listRuoli, v);
        this.idAmministratore = idAmministratore;
    }

  
  



    private Integer idAmministratore;
   

    /**
     * restituisce il codice identificativo dell'Amministratore
     * @return il codice identificativo di un Cliente
     */
    public Integer getIdAmministratore() {
        return idAmministratore;
    }

    /**
     * setta il codice identificativo dell'Amministatore
     * @param idAmministratore di tipo int
     */
    public void setIdAmministratore(Integer idAmministratore) {
        this.idAmministratore = idAmministratore;
    }
 

}
