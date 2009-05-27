package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public interface GestioneUtenti<E extends Utente,U extends BeanGuiUtente> {

    /**
     * è un metodo che permette di visualizzare tutti
     * gli utenti del sistema, con le relative informazioni
     * @return una lista di utenti
     */
    public ArrayList<E> elenca();

    /**
     * è un metodo che permette di ricercare un utente
     * in base alla sua username
     * @param username: stirnga di caratteri
     * @return un utente con le sue informazioni
     */
    public E ricerca(String username);

    /**
     * è un metodo che permette di eliminare in maniera permanente
     * un utente dal sistema prendendo in input la sua username
     * @param username: stringa di caratteri
     */
    public void elimina(String username);

    /**
     * è un metodo che permette di nascondere al sistema
     * la presenza di un utenteprendendo in input la sua username
     * @param username: stringa di caratteri
     */
    public void eliminazioneLogica(String username);

    /**
     * è un metodo che permette di inserire un nuovo utente nel sistema
     * @param user: oggetto contenente le informazioni dell'utente
     */
    public void inserisci(BeanGuiUtente user);

     /**
     * è un metodo che permette di modificare la password dell'utente
     * @param user:oggetto contenente i dati dell'utente
     */
    public BeanGuiUtente modifica(BeanGuiUtente user);



}
