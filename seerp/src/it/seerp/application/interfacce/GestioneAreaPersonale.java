package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.Exception.DatiErrati;

/**
 * Interfaccia applicazione per la Gestione Area Personale
 * @param <U>
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneAreaPersonale<U extends BeanGuiUtente> {

    /**
     *
     * @param utente
     * @return
     */
    public U visualizzaDati(U utente);

    /**
     *
     * @param utente
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public U modificaPassword(U utente) throws DatiErrati;
}
