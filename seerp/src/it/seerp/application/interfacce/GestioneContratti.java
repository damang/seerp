


package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 *
 * @author Luisa
 */

public interface GestioneContratti<E> {




    public ArrayList<E> visualizza(ArrayList<E> list);

     public E visualizzaContratto(JTextField id,ArrayList<E> list) throws DatiErrati;

    public E ricerca(JTextField id,ArrayList<E> list) throws DatiErrati;

    public ArrayList<E> ricercaPerDipendente(JTextField nomeDipendente,ArrayList<E> list) throws DatiErrati;

    public void inserisci(E beanGuiContratto) throws DatiErrati,DatiDuplicati;

    public E modifica(E beanGuiContratto) throws DatiErrati;
}
