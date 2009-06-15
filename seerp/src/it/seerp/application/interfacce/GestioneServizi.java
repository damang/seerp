package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import java.util.ArrayList;

/**
 *
 * @author Luisa - Tommaso Cattolico
 */
public interface GestioneServizi<E, U> {

    public ArrayList<U> visualizzaTabella();

    public ArrayList<E> elenca(ArrayList<E> listGui);

    public ArrayList<E> ricerca(ArrayList<E> list) throws DatiErrati;

    public void inserisci(E BeansGuiServizio) throws DatiErrati, DatiDuplicati;

    public E visualizza(String nome, E beanGui);

    public E modifica(E BeansGuiServizio) throws DatiErrati;
}
