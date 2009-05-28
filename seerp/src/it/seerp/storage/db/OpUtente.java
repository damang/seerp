/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.storage.db;

import it.seerp.storage.Exception.DatiDuplicati;
import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.Exception.RicercaFallita;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author LuNy
 */
public interface OpUtente<E, BG> {

    public void inserimento (E Bean) throws DatiErrati, DatiDuplicati;

    public  BG modifica (E Bean) throws DatiErrati;

    public ArrayList<BG> visualizzaElenco ();

    public ArrayList<BG> ricerca() throws DatiErrati;

    public void elimina (E Bean) throws CancellazioneFallita;

    public void eliminazioneLogica (E Bean);
}
