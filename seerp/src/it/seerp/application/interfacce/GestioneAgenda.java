package it.seerp.application.interfacce;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Agenda
 * @param <E> 
 * @param <U>
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneAgenda<E, U> {

    /**
     * Metodo che permette la visualizzazione della lista degli eventi
     * @param listGui
     * @param usr
     * @return  Array List contenente la lista degli eventi
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public ArrayList<E> elenca(ArrayList<E> listGui, String usr) throws SQLException;

    /**
     * Metodo che permette la visualizzazione degli eventi da notificare
     * @param id ID dell'evento
     * @return  elenco degli eventi che corrispondono all'id inserito
     * @throws java.sql.SQLException
     */
    public ArrayList<String> getEventiNotificare(int id) throws SQLException;

    /**
     * Visualizzazione della tabella dei bean
     * @return ArrayList contenente i bean richiesti
     */
    public ArrayList<U> visualizzaTabella();

    /**
     * Metodo che permette la visualizzazione dei dettagli di un singolo evento
     * @param id ID dell'evento
     * @param gui  Bean Gui dell'evento
     * @return Bean Gui dell'evento
     * @throws DatiErrati
     */
    public E visualizzaDettagli(int id, E gui) throws DatiErrati, SQLException, ValidatorException;

    /**
     * Metodo che permette la gestione delle notifiche
     * @param beanGui
     */
    public void notificaEventi(E beanGuiEventi) throws SQLException,ValidatorException;

    /**
     * Metodo che permette l'inserimento di un nuovo evento
     * @param beanGui
     * @throws it.seerp.application.Exception.DatiErrati
     * in caso di inserimento di dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui esista l'evento che si tenta di inserire
     */
    public void inserimento(E beanGuiEventi) throws DatiErrati, SQLException,ValidatorException;

    /**
     * Metodo che permette la modifica di un evento
     * @param beanGui
     * @return
     * Bean Gui dell'evento modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public E modifica(E beanGuiEventi) throws DatiErrati;

    /**
     * Metodo che permette la ricerca di un evento
     * @param listGui
     * @para list
     * lista di tutti gli eventi
     * @return la lista degli eventi che corrispondono ai criteri di ricerca
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<E> ricercaEvento(ArrayList<E> list) throws DatiErrati;

    /**
     * Metodo che permette la ricerca per giorno di un evento
     * @param beanGui
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione dell'evento
     */
    public void cancellaEvento(E beanGuiEventi) throws CancellazioneFallita;

    /**
     * Metodo che permette la cancellazione dell'evento
     * @param id ID dell'evento
     * @throws it.seerp.application.Exception.CancellazioneFallita
     */
    public void cancellaEvento(int id) throws CancellazioneFallita;

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @param user Stringa col nome dell'utente
     * @return lista dei bean
     */
    public ArrayList<U> visualizzaTabella(String user);
}
