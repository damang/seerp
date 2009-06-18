package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Ruoli
 * @param <E>
 * @author Tommaso Cattolico
 */
public interface GestioneRuoli<E> {

    /**
     *
     * @param beanGuiEventi
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserimento(E beanGuiEventi) throws DatiErrati, DatiDuplicati;

    /**
     *
     * @param bean
     * @return
     */
    public E modifica(E bean);

    /**
     *
     * @param r
     
    public void elimina(E r);

    /**
     *
     * @param list
     * @return
     */
    public ArrayList<E> getElenco();
}