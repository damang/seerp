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
public interface OpeEntity<E, BG> {

    public void inserimento (E Bean) throws SQLException, DatiErrati, DatiDuplicati;

    public  BG modifica (E Bean) throws SQLException,DatiErrati;

    public BG visualizza (E Bean) throws SQLException;

    public ArrayList<BG> ricerca() throws SQLException,RicercaFallita;

    public void elimina (E Bean) throws SQLException, CancellazioneFallita;
}
