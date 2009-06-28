package it.seerp.application.applicazione.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import java.sql.SQLException;

/**
 * Interfaccia applicazione per la Gestione Azienda
 * @param <E>
 * @author Tommaso Cattolico
 */
public interface GestioneAzienda<E> {

    /**
     * Metodo che permette la modifica di un'azienda
     * @param beanGui
     * Bean Gui dell'azienda da modificare
     * @return
     * Bean Gui dell'azienda modificata
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public E modifica(E beanGui) throws SQLException, ValidatorException;

    /**
     * Metodo che permette la visualizzazione di una singola azienda
     * @param gui Bean Gui dell'azienda
     * @return Bean Gui dell'azienda
     * @throws DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public E visualizzaAzienda(E gui) throws SQLException, ValidatorException;

    /**
     * Metodo che permette l'inserimento di un'Azienda
     * @param BeanGuiAzienda
     * Bean Guid ell'azienda da inserire
     * @throws java.sql.SQLException
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserimento(E BeanGuiAzienda) throws SQLException, ValidatorException;
}
