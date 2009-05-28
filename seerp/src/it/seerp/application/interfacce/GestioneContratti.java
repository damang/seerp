


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




    public ArrayList<E> visualizza();


     public E visualizzaContratto(JTextField nome);

    public E visualizzaContratto(E BeanGuiContatto);

    public E ricerca(JTextField id) throws DatiErrati;

    public ArrayList<E> ricercaPerDipendente(JTextField nomeDipendente) throws DatiErrati;

    public void inserisci(E BeanGuiContratto) throws DatiErrati;

    public E modifica(E BeanGuiContratto) throws DatiErrati,DatiDuplicati;
}
