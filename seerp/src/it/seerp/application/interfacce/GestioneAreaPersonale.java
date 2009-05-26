package it.seerp.application.interfacce;

import java.util.ArrayList;

/**
 *
 * @param <E>
 * @author matteo
 */
public interface GestioneAreaPersonale<E> extends GestioneUtenti<E> {

    /**
     * 
     * @param user
     */
    public void visualizzaDati(E user);
    /**
     *
     * @param user
     */
    public void modifica(E user);
    /**
     *
     * @param user
     */
    public void modificaPassword(E user);
    /**
     *
     * @param user
     * @return
     */
    public ArrayList<E> visualizzaContratti(E user);


}
