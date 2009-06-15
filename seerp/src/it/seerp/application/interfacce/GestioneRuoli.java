package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;

/**
 *
 * @author Tommaso Cattolico
 */
public interface GestioneRuoli<E> {

    public void inserimento(E beanGuiEventi) throws DatiErrati, DatiDuplicati;
}