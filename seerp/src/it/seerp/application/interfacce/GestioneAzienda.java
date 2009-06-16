package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiErrati;

/**
 * Interfaccia applicazione per la Gestione Azienda
 * @author Tommaso Cattolico
 */
public interface GestioneAzienda<E> {

    public E modifica(E beanGui) throws DatiErrati;
}
