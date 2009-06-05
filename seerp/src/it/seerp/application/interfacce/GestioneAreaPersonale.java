package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import it.seerp.application.Exception.DatiErrati;

/**
 *
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneAreaPersonale <E extends Utente,U extends BeanGuiUtente>
{
    public U visualizzaDati(U utente);

    public U modificaPassword(U utente) throws DatiErrati;
}
