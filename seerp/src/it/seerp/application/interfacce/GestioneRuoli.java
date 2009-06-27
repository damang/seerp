package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Interfaccia applicazione per la Gestione Ruoli
 * @param <E> 
 * @param <U>
 * @author Tommaso Cattolico
 */
public interface GestioneRuoli<E, U> {

    /**
     * Metodo che permette l'inserimento di un nuovo ruolo
     * @param beanGuiEventi 
     * @throws SQLException
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui si immettano dati duplicati
     */
    public void inserimento(E beanGuiEventi) throws SQLException,ValidatorException;

    /**
     * Metodo che permette la modifica di un ruolo
     * @param bean
     * @return
     * Bean Gui del ruolo modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public E modifica(E bean)throws SQLException,ValidatorException;

    /**
     * Metodo che permette l'eliminazione di un Ruolo
     * @param r Bean Gui del Ruolo da eliminare
     */
    public void elimina(E r)throws SQLException,ValidatorException;

    /**
     * Metodo che permette l'eliminazione di un Ruolo
     * @param r Stringa del Ruolo da eliminare
     */
    public void elimina(String r)throws SQLException,ValidatorException;

    /**
     * Metodo che permette la visualizzazione della lista dei ruoli
     * @return  Array List contenente la lista dei ruoli
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public ArrayList<E> getElenco()throws SQLException,ValidatorException ;

    /**
     * Metodo che permette di visualizzare i bean dei Ruoli
     * @return ArrayList di Ruoli
     */
    public ArrayList<U> visualizzaTabella()throws SQLException,ValidatorException ;

    /**
     *
     * @param nome
     * @param b Bean Gui del Ruolo
     */
    public void visualizzaDati(String nome, E b)throws SQLException,ValidatorException ;

    /**
     * Metodo che ritorna i Ruoli dell'utente selezionato
     * @param s nome dell'utente
     * @return ArrayList dei Ruoli dell'utente selezionato
     */
    public ArrayList<String> getNomeRuolo(String s)throws SQLException,ValidatorException ;
}