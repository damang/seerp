package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 *
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneServizi <E>
{
    public ArrayList<E> elenca (ArrayList<E> listGui);

    public ArrayList<E> ricerca (JTextField nome,ArrayList<E> list)throws DatiErrati;

    public void inserisci (E BeansGuiServizio)throws DatiErrati, DatiDuplicati;

    public E visualizza(JTextField nome, E beanGui);

    public E modifica (E BeansGuiServizio) throws DatiErrati;
}
