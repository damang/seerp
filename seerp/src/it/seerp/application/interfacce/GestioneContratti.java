package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 *
 * @author Luisa - Tommaso Cattolico
 */

public interface GestioneContratti<E>
{
    public ArrayList<E> visualizza(ArrayList<E> listGui);

    public E visualizzaContratto(String id,E beanGuiContratto) throws DatiErrati;

    public ArrayList<E> ricercaPerDipendente(ArrayList<E> listGui) throws DatiErrati;

    public void inserisci(E beanGuiContratto) throws DatiErrati,DatiDuplicati;

    public E modifica(E beanGuiContratto) throws DatiErrati;
}
