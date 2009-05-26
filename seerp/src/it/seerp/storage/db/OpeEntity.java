/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package it.seerp.storage.db;

import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.Exception.DatiDuplicati;
import it.seerp.storage.Exception.CancellazioneFallita;
import it.seerp.storage.ejb.Contratto;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public interface OpeEntity<E, BG> {

    public void inserimento (E Bean) throws DatiErrati, DatiDuplicati;

    public  BG modifica (E Bean) throws DatiErrati;

    public BG visualizza ();

    public ArrayList<BG> ricerca();

    public void elimina (E Bean) throws CancellazioneFallita;
}
