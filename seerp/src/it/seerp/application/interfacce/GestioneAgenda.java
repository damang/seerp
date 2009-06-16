package it.seerp.application.interfacce;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Agenda
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneAgenda<E, U> {

    public ArrayList<U> visualizzaTabella();

    public ArrayList<E> elenca(ArrayList<E> listGui);

    public E visualizzaDettagli(String id, E gui) throws DatiErrati;

    public void notificaEventi(E beanGuiEventi);

    public void inserimento(E beanGuiEventi) throws DatiErrati, DatiDuplicati;

    public E modifica(E beanGuiEventi) throws DatiErrati;

    public ArrayList<E> ricercaEvento(ArrayList<E> list) throws DatiErrati;

    //public ArrayList<E> ricercaPerTema(JTextField tema, ArrayList<E> list)throws  DatiErrati;

    //public ArrayList<E> ricercaPerNome(JTextField nome,ArrayList<E> list) throws  DatiErrati, RicercaFallita;

    //public ArrayList<E> ricercaPerGiorno(JTextField giorno,ArrayList<E> list)throws  DatiErrati, RicercaFallita;
    
    public void cancellaEvento(E beanGuiEventi) throws CancellazioneFallita;
}
