package it.seerp.application.interfacce;


import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
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

    public ArrayList<E> ricerca (JTextField nome)throws DatiErrati;

    public void inserisci (E BeansGuiServizio)throws DatiErrati, DatiDuplicati;

    public E visualizza(JTextField nome);

    public E modifica (E BeansGuiServizio) throws DatiDuplicati;
}
