package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Servizi
 * @param <E> 
 * @param <U>
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneServizi<E, U> {

    /**
     *
     * @return
     */
    public ArrayList<U> visualizzaTabella();

    /**
     *
     * @param listGui
     * @return
     */
    public ArrayList<E> elenca(ArrayList<E> listGui);

    /**
     *
     * @param list
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public ArrayList<E> ricerca(ArrayList<E> list) throws DatiErrati;

    /**
     *
     * @param BeansGuiServizio
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserisci(E BeansGuiServizio) throws DatiErrati, DatiDuplicati;

    /**
     *
     * @param nome
     * @param beanGui
     * @return
     */
    public E visualizza(String nome, E beanGui);

    /**
     *
     * @param BeansGuiServizio
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public E modifica(E BeansGuiServizio) throws DatiErrati;
}
