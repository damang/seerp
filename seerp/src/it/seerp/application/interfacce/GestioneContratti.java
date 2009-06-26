package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Contratti
 * @param <E>
 * @param <U>
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneContratti<E, U> {

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<U> visualizzaTabella();

    /**
     * Metodo che permette la visualizzazione della lista dei contratti
     * @param listGui
     * @return ArrayList dei contratti presenti nel sistema
     */
    public ArrayList<E> elenca(ArrayList<E> listGui);

    /**
     * Metodo che permette la visualizzazione di un singolo contratto
     * @param id
     * @param gui
     * @return Bean Gui del contratto che è stato selezionato
     * @throws DatiErrati
     */
    public E visualizzaContratto(int id, E beanGuiContratto) throws DatiErrati;

    /**
     * Metodo che permette la ricerca per dipendente
     * @param listGui
     * @return ArrayList contentente tutti i Bean Gui dei contratti appartenenti al dipendente immesso
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<E> ricercaPerDipendente(ArrayList<E> listGui) throws DatiErrati;

    /**
     * Metodo che permette l'inserimento di un contratto
     * @param beanGuiContratto
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui il contratto da inserire esista già
     */
    public void inserisci(E beanGuiContratto) throws DatiErrati, DatiDuplicati;

    /**
     * Metodo che permette la modifica di un contratto
     * @param beanGuiContratto
     * @return il Bean Gui del contratto modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    public E modifica(E beanGuiContratto) throws DatiErrati;
}
