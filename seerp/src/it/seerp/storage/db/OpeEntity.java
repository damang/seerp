

package it.seerp.storage.db;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @param <E> tipo generico
 * @param <G> tipo generico
 * @author Luisa
 */
public interface OpeEntity<E, G> {

    /**
     * metodo che inserisce la tupla delle informazioni contenute nel bean
     * @param bean bean che contiene lr informazioni sulla tupla da iserire
     * @throws java.sql.SQLException
     * nel caso in cui ci siano problemi legati all'iserimento nel database
     */
    public void inserimento(E bean) throws SQLException;

    /**
     * @param bean
     * @return bean modificato
     * @throws java.sql.SQLException
     * nel caso in cui ci siano problemi legati alla modifica nel database
     */
    public E modifica(E bean) throws SQLException;

    /**
     * metodo che ricerca nel database l'enity con quel parametro in input
     * @param id
     * @return bean ricercato
     * @throws java.sql.SQLException
     * nel caso in cui ci siano problemi legati alla visualizzazione nel database
     *
     */

    public E visualizza(G id) throws SQLException;

    /**
     * metodo che restuisce l iniseme delle entity di una tabella
     * @return  arraylist delle entity di una tabella
     * @throws java.sql.SQLException
     * nel caso in cui ci siano problemi legati alla ricerca nel database
     */
    public ArrayList<E> visualizzaElenco() throws SQLException;
}
