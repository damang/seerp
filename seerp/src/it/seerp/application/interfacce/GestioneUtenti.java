package it.seerp.application.interfacce;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;

/**
 * Interfaccia applicazione per la Gestione Utenti
 * @author matteo - Tommaso Cattolico
 */
public interface GestioneUtenti<E extends Utente, U extends BeanGuiUtente> {

    public ArrayList<E> visualizzaTabella();

    public ArrayList<U> elenca(ArrayList<U> listGui);

    public ArrayList<U> ricerca(ArrayList<U> list) throws DatiErrati, RicercaFallita;

    public void elimina(U user);

    public void eliminazioneLogica(U user);

    public U inserisci(U user) throws DatiErrati, DatiDuplicati;

    public U modifica(U user) throws DatiErrati;

    public U visualizzaDati(String user, U beanGui) throws DatiErrati;
}
