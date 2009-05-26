package it.seerp.application.interfacce;

import it.seerp.application.Exception.EliminaException;
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
public interface GestioneAgenda<E, G> {

    public  ArrayList<E> visualizzaListaEventi()throws RicercaException;

    public E visualizzaDettagli(E evento);

    public void inserimento(G BeanGuiServizio) throws InserimentoException;

    public void modifica(G BeanGuiServizio) throws ModificaException;

    public ArrayList<E> ricerca(String Nome, String Referente, Date data)throws  RicercaException;

    public ArrayList<E> ricercaPerNome(String Nome) throws  RicercaException;

    public ArrayList<E> ricercaPerGiorno(Date giorno)throws  RicercaException;

    public void cancellaEvento(G BeanGuiServizio) throws EliminaException ;
}
