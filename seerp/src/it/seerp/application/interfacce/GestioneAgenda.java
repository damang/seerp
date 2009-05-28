package it.seerp.application.interfacce;


import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */

public interface GestioneAgenda<G> {
    //ci vuole l extends???
    public  ArrayList<G> visualizzaListaEventi()throws DatiErrati;

    public G visualizzaDettagli(JTextField nome);


    public void notificaEventi (G beanGuiEventi);


    public void inserimento(G beanGuiEventi) throws DatiErrati,DatiDuplicati;


    public G modifica(G beanGuiEventi) throws DatiErrati;
   
    public ArrayList<G> ricerca(JTextField Nome, JTextField Referente, JTextField data)throws  DatiErrati;

    public ArrayList<G> ricercaPerNome(JTextField Nome) throws  DatiErrati;

    public ArrayList<G> ricercaPerGiorno(JTextField giorno)throws  DatiErrati;
//vedre cm e mappata
    public void cancellaEvento(G beanGuiEventi) throws RicercaFallita ;
}
