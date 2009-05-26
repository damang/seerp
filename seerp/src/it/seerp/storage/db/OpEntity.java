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

    public void inserimento (E Source) throws DatiErrati, DatiDuplicati;

    public void modifica (E source) throws DatiErrati;

    public void elimina (E source) throws CancellazioneFallita;

    public ArrayList<E> ricerca () throws RicercaFallita;
}
