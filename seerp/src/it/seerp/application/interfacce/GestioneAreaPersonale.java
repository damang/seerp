package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.Exception.DatiErrati;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneAreaPersonale<U extends BeanGuiUtente> {

    public U visualizzaDati(U utente);

    public U modificaPassword(U utente) throws DatiErrati;
}
