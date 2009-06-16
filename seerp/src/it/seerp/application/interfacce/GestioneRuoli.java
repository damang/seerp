package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Ruoli
 * @author Tommaso Cattolico
 */
public interface GestioneRuoli<E> {

    public void inserimento(E beanGuiEventi) throws DatiErrati, DatiDuplicati;

    public E modifica(E bean);

    public E elimina(E r);

    public ArrayList<E> getElenco(ArrayList<E> list);
}