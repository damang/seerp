


package it.seerp.application.interfacce;

import it.seerp.application.Exception.InserimentoException;
import it.seerp.application.Exception.ModificaException;
import it.seerp.application.Exception.RicercaException;
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


    public E ricerca(JTextField id) throws RicercaException;

    public ArrayList<E> ricercaPerDipendente(JTextField nomeDipendente) throws RicercaException;

    public void inserisci(E BeanGuiContratto) throws InserimentoException;

    public E modifica(E BeanGuiContratto) throws ModificaException;
}
