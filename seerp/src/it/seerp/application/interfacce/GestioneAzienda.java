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
}
