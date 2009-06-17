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
     * @param id
     * @param beanGuiContratto
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public E visualizzaContratto(String id, E beanGuiContratto) throws DatiErrati;

    /**
     *
     * @param listGui
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public ArrayList<E> ricercaPerDipendente(ArrayList<E> listGui) throws DatiErrati;

    /**
     *
     * @param beanGuiContratto
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserisci(E beanGuiContratto) throws DatiErrati, DatiDuplicati;

    /**
     *
     * @param beanGuiContratto
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public E modifica(E beanGuiContratto) throws DatiErrati;
}
