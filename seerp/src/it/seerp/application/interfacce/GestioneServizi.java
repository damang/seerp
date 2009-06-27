package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Servizi
 * @param <E> 
 * @param <U>
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneServizi<E, U> {

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<U> visualizzaTabella()throws SQLException;

    /**
     * Metodo che permette di visualizzare l'elenco dei servizi
     * @param listGui
     * @return ArrayList contenente i servizi
     */
    public ArrayList<E> elenca(ArrayList<E> listGui)throws SQLException,ValidatorException ;

    /**
     * Metodo che permette la ricerca di un servizio
     * @param listGui
     * Array List di bean gui da riempire coi dati che corrispondono ai criteri di ricerca
     * @return ArrayList con i servizi che corrispondono al nome inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produce risultati
     */
    public ArrayList<E> ricerca(ArrayList<E> list)throws SQLException;

    /**
     * Metodo che permette l'inserimento di un nuovo servizio
     * @param beanGui
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws DatiDuplicati
     */
    public void inserisci(E BeansGuiServizio) throws  SQLException,ValidatorException;

    /**
     * Metodo che permette la visualizzazione di un servizio
     * @param nome
     * nome del servizio
     * @param beanGui
     * @return Bean Gui del servizio da visualizzare
     */
    public E visualizza(int nome, E beanGui)throws ValidatorException,SQLException;

    /**
     * Metodo che permette la modifica di un servizio
     * @param beanGui
     * @return Bean Gui del servizio modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati durante la modifica
     */
    public E modifica(int id, E BeansGuiServizio) throws SQLException,ValidatorException;
}
