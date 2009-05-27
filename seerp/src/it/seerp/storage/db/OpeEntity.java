/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package it.seerp.storage.db;

import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.Exception.DatiDuplicati;
import it.seerp.storage.Exception.CancellazioneFallita;
import it.seerp.storage.Exception.RicercaFallita;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public interface OpeEntity<E> {

    public void inserimento (E Bean) throws SQLException, DatiErrati, DatiDuplicati;

    public  E modifica (E Bean) throws SQLException,DatiErrati;

    public E visualizza (String nome) throws SQLException;

    public ArrayList<E> visualizzaElenco() throws SQLException,RicercaFallita;

    public E elimina (E Bean) throws SQLException, CancellazioneFallita;
}
