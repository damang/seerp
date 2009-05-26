


package it.seerp.application.interfacce;

import it.seerp.application.Exception.InserimentoException;
import it.seerp.application.Exception.ModificaException;
import it.seerp.application.Exception.RicercaException;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 *
 * @author Luisa
 */
public interface GestioneContratti<E,G> {

    public ArrayList<E> visualizza();

     public E visualizzaContratto(G BeanGuiContatto);

    public E ricerca(Integer id) throws RicercaException;

    public ArrayList<E> ricercaPerDipendente(String nomeDipendente) throws RicercaException;

    public void inserisci(G BeanGuiContatto) throws InserimentoException;

    public void modifica(G BeanGuiContatto) throws ModificaException;
}
