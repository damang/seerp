package it.seerp.application.interfacce;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Luisa
 */
public interface GestioneAgenda<E> {

    public  ArrayList<E> visualizzaListaEventi(E evento);

    public void visualizzaDettagliEvento(E evento);

    public void inserimentoEvento(E evento);

    public void modificaEvento(E evento);

    public ArrayList<E> RicercaEvento(String Nome, String Referente, Date data);

    public ArrayList<E> ricercaPerNome(String Nome);

    public ArrayList<E> ricercaPerGiorno(Date giorno);

    public E ricordaEvento(Date data, Time ora);

    public E ricercaGiorno();

    public void cancellaEvento();
}
