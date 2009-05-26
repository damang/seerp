package it.seerp.application.interfacce;

import java.util.ArrayList;

/**
 *
 * @author matteo
 */
public interface GestioneUtenti<E> {

    /**
     *
     * @return
     */
    public ArrayList<E> elenca();

    /**
     *
     * @param username
     * @return
     */
    public E ricerca(String username);

    /**
     *
     * @param username
     */
    public void elimina(String username);

    /**
     *
     * @param username
     */
    public void eliminazioneLogica(String username);

    /**
     *
     * @param utente
     */
    public void inserisci(E utente);

}
