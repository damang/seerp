/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.db;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */

    public interface OpeEntity<E> {

    public void inserimento (E Bean) throws SQLException;

    public  E modifica (E Bean) throws SQLException;

    public E visualizza (String nome) throws SQLException;

    public ArrayList<E> visualizzaElenco() throws SQLException;


}
