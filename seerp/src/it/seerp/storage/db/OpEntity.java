package it.seerp.storage.db;

import it.seerp.storage.Exception.DatiErrati;
import it.seerp.storage.Exception.CancellazioneFallita;
import it.seerp.storage.Exception.DatiDuplicati;
import it.seerp.storage.Exception.RicercaFallita;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public interface OpEntity<E> {

    public void inserimento (E Bean) throws DatiErrati, DatiDuplicati;

    public void modifica (E Bean) throws DatiErrati;

    public E visualizza ();

    public void elimina () throws CancellazioneFallita;

}
