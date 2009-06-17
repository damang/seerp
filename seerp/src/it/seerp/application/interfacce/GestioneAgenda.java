package it.seerp.application.interfacce;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Agenda
 * @param <E> 
 * @param <U>
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneAgenda<E, U> {

    /**
     *
     * @return
     */
    public ArrayList<U> visualizzaTabella();

    /**
     *
     * @param listGui
     * @return
     */
    public ArrayList<E> elenca(ArrayList<E> listGui);

    /**
     *
     * @param id
     * @param gui
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public E visualizzaDettagli(String id, E gui) throws DatiErrati;

    /**
     *
     * @param beanGuiEventi
     */
    public void notificaEventi(E beanGuiEventi);

    /**
     *
     * @param beanGuiEventi
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserimento(E beanGuiEventi) throws DatiErrati, DatiDuplicati;

    /**
     *
     * @param beanGuiEventi
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public E modifica(E beanGuiEventi) throws DatiErrati;

    /**
     *
     * @param list
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public ArrayList<E> ricercaEvento(ArrayList<E> list) throws DatiErrati;

    //public ArrayList<E> ricercaPerTema(JTextField tema, ArrayList<E> list)throws  DatiErrati;

    //public ArrayList<E> ricercaPerNome(JTextField nome,ArrayList<E> list) throws  DatiErrati, RicercaFallita;

    //public ArrayList<E> ricercaPerGiorno(JTextField giorno,ArrayList<E> list)throws  DatiErrati, RicercaFallita;
    
    /**
     *
     * @param beanGuiEventi
     * @throws it.seerp.application.Exception.CancellazioneFallita
     */
    public void cancellaEvento(E beanGuiEventi) throws CancellazioneFallita;
}
