package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiErrati;

/**
 * Interfaccia applicazione per la Gestione Azienda
 * @param <E>
 * @author Tommaso Cattolico
 */
public interface GestioneAzienda<E> {

    /**
     *
     * @param beanGui
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public E modifica(E beanGui) throws DatiErrati;

    /**
     * Metodo che permette la visualizzazione di una singola azienda
     * @param gui Bean Gui dell'azienda
     * @return Bean Gui dell'azienda
     * @throws DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public E visualizzaAzienda(E gui) throws DatiErrati;
}
