package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 *
 *
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneContratti<E, U> {

    public ArrayList<U> visualizzaTabella();

    public ArrayList<E> elenca(ArrayList<E> listGui);

    public E visualizzaContratto(String id, E beanGuiContratto) throws DatiErrati;

    public ArrayList<E> ricercaPerDipendente(ArrayList<E> listGui) throws DatiErrati;

    public void inserisci(E beanGuiContratto) throws DatiErrati, DatiDuplicati;

    public E modifica(E beanGuiContratto) throws DatiErrati;
}
