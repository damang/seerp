package it.seerp.application.interfacce;

import it.seerp.application.Exception.InserimentoException;
import it.seerp.application.Exception.ModificaException;
import it.seerp.application.Exception.RicercaException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public interface GestioneServizi <E, G>{

    public ArrayList<E> elenca ();

    public ArrayList<E> ricerca (String nome)throws RicercaException;

    public void inserisci (G BeansGuiServizio)throws InserimentoException;

    public E visualizzaServizio(G BeansGuiServizio);

    public void modificaServizio (G BeansGuiServizio) throws ModificaException;
}
