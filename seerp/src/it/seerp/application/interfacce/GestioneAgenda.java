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
    //ci vuole l extends???
    public  ArrayList<E> visualizzaListaEventi()throws RicercaException;

    public E visualizzaDettagli(E evento);

    public void noficaEventi (G BeanGuiEventi);

    public void inserimento(G BeanGuiEventi) throws InserimentoException;

    public void modifica(G BeanGuiEventi) throws ModificaException;

    public ArrayList<E> ricerca(String Nome, String Referente, Date data)throws  RicercaException;

    public ArrayList<E> ricercaPerNome(String Nome) throws  RicercaException;

    public ArrayList<E> ricercaPerGiorno(Date giorno)throws  RicercaException;

    public void cancellaEvento(G BeanGuiEventi) throws EliminaException ;
}
