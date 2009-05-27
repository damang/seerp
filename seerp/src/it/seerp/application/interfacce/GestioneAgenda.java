package it.seerp.application.interfacce;

import it.seerp.application.Exception.EliminaException;
import it.seerp.application.Exception.InserimentoException;
import it.seerp.application.Exception.ModificaException;
import it.seerp.application.Exception.RicercaException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Luisa
 */
public interface GestioneAgenda<G> {
    //ci vuole l extends???
    public  ArrayList<G> visualizzaListaEventi()throws RicercaException;

    public G visualizzaDettagli(JTextField nome);

    public void notificaEventi (G beanGuiEventi);

    public void inserimento(G beanGuiEventi) throws InserimentoException;

    public G modifica(G beanGuiEventi) throws ModificaException;

    public ArrayList<G> ricerca(JTextField Nome, JTextField Referente, JTextField data)throws  RicercaException;

    public ArrayList<G> ricercaPerNome(JTextField Nome) throws  RicercaException;

    public ArrayList<G> ricercaPerGiorno(JTextField giorno)throws  RicercaException;
//vedre cm e mappata
    public G cancellaEvento(G beanGuiEventi) throws EliminaException ;
}
