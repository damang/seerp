package it.seerp.application.interfacce;


import it.seerp.application.Exception.CancellazioneFallita;
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
    
    public  ArrayList<G> visualizzaListaEventi(ArrayList<G> list);

    public G visualizzaDettagli(JTextField id,ArrayList<G> list)throws DatiErrati;


    public void notificaEventi (G beanGuiEventi);


    public void inserimento(G beanGuiEventi) throws DatiErrati,DatiDuplicati;


    public G modifica(G beanGuiEventi) throws DatiErrati;
   
    public ArrayList<G> ricerca(JTextField Nome, JTextField Referente, JTextField data,ArrayList<G> list)throws  DatiErrati;

    public ArrayList<G> ricercaPerNome(JTextField Nome,ArrayList<G> list) throws  DatiErrati, RicercaFallita;

    public ArrayList<G> ricercaPerGiorno(JTextField giorno,ArrayList<G> list)throws  DatiErrati, RicercaFallita;
    
    public void cancellaEvento(G beanGuiEventi) throws CancellazioneFallita ;
}
