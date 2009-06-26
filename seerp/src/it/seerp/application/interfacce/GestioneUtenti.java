package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Utenti
 * @param <E>
 * @param <U>
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneUtenti<E extends Utente, U extends BeanGuiUtente> {

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<E> visualizzaTabella();

    /**
     * Metodo che permette di visualizzare la lista degli utenti
     * @param listGui
     * @return la lista di tutti gli utenti
     */
    public ArrayList<U> elenca(ArrayList<U> listGui);

    /**
     * Metodo che permette di ricercare un utente del sistema
     * @param list
     * la lista di tutti gli utenti
     * @return l'utente se è trovato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel momento in cui i dati inseriti sono errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel momento in cui nn viene trovato l'elemento e la ricerca fallisce
     */
    public ArrayList<U> ricerca(ArrayList<U> list) throws DatiErrati, RicercaFallita;

    /**
     * Metodo che permette di eliminare un utente
     * @param user
     * l'utente che si vuole eliminare
     */
    public void elimina(int id, U user);

    /**
     * Metodo che permette di nascondere un utente al sistema senza eliminarlo in maniera permanente
     * @param user
     * l'utente che si vuole eliminare logicamente
     */
    public void eliminazioneLogica(U user);

    /**
     * Metodo che permette di inserire un utente
     * @param user
     * l'utente che si vuole inserire
     * @return
     * l'utente inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui i dati inseriti sono duplicati
     */
    public void inserisci(U user) throws DatiErrati, DatiDuplicati, SQLException;

    /**
     * Metodo che permette di modificare i dati di un utente
     * @param user
     * l'utente del quale si vogliono modificare i dati
     * @return
     * l'utente modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    public U modifica(int id, U user) throws DatiErrati, SQLException;

    /**
     * Metodo che permette di visualizzare i dati di un utente
     * @param user
     * l'username dell'utente
     * @param beanGui
     * @return tutti i dati di un utente
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    public U visualizzaDati(int user, U beanGui) throws DatiErrati;
}
