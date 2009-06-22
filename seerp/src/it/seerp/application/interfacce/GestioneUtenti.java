package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Utenti
 * @param <E>
 * @param <U>
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneUtenti<E extends Utente, U extends BeanGuiUtente> {

    /**
     *
     * @return
     */
    public ArrayList<E> visualizzaTabella();

    /**
     *
     * @param listGui
     * @return
     */
    public ArrayList<U> elenca(ArrayList<U> listGui);

    /**
     *
     * @param list
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.RicercaFallita
     */
    public ArrayList<U> ricerca(ArrayList<U> list) throws DatiErrati, RicercaFallita;

    /**
     *
     * @param user
     */
    public void elimina(int id,U user);

    /**
     *
     * @param user
     */
    public void eliminazioneLogica(U user);

    /**
     *
     * @param user
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     * @throws it.seerp.application.Exception.DatiDuplicati
     */
    public void inserisci(U user) throws DatiErrati, DatiDuplicati;

    /**
     *
     * @param user
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public U modifica(int id,U user) throws DatiErrati;

    /**
     *
     * @param user
     * @param beanGui
     * @return
     * @throws it.seerp.application.Exception.DatiErrati
     */
    public U visualizzaDati(int user, U beanGui) throws DatiErrati;
}
