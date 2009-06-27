package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import java.sql.SQLException;

/**
 * Interfaccia applicazione per la Gestione Area Personale
 * @param <U>
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneAreaPersonale<U extends BeanGuiUtente> {

    /**
     * Metodo che permette di visualizzare tutti i dati relativi ad un utente
     * @param beanGui
     * @return il Bean Grafico contenente i dati dell'utente
     */
    public U visualizzaDati(int id, U utente)  throws SQLException, ValidatorException;

    /**
     * Metodo che permette di modificare la password di un utente
     * @param beanGui
     * @return il Bean grafico modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    public U modificaPassword(U utente) throws SQLException, ValidatorException;
}
