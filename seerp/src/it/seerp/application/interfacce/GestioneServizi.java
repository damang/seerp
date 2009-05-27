package it.seerp.application.interfacce;

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
public interface GestioneServizi <E>{

    public ArrayList<E> elenca ();

    public ArrayList<E> ricerca (JTextField nome)throws RicercaException;

    public void inserisci (E BeansGuiServizio)throws InserimentoException;

    public E visualizzaServizio(JTextField nome);

    public E modificaServizio (E BeansGuiServizio) throws ModificaException;
}
