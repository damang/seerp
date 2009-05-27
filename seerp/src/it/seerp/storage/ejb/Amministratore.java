
package it.seerp.storage.ejb;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public class Amministratore extends Personale {

    public Amministratore(Integer idPersonale, String cognome, String nome, String codiceFiscale, String tipo, ArrayList<Permesso> listp, ArrayList<Ruolo> listr, Integer idAmministratore) {
        super(idPersonale, cognome, nome, codiceFiscale, tipo, listp, listr);
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
