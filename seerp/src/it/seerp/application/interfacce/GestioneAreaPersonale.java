package it.seerp.application.interfacce;

import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.storage.ejb.Utente;
import java.util.ArrayList;

/**
 *
 * @param <E>
 * @author matteo
 */
public interface GestioneAreaPersonale <E extends Utente,U extends BeanGuiUtente> extends GestioneUtenti<E,U> {

    /**
     * è un metodo che permette di visualizzare tutti i dati
     * di un utente
     * @param user: oggetto contente i dati dell'utente
     */
    public void visualizzaDati(E user);

    /**
     * è un metodo che permette di modificare i dati personali di un utente
     * @param user: oggetto contenente i dati dell'utente
     */
    public void modifica(BeanGuiUtente user);

    /**
     * è un metodo che permette di modificare la password dell'utente
     * @param user:oggetto contenente i dati dell'utente
     */
    public void modificaPassword(BeanGuiUtente user);

    /**
     * è un metodo che permette di visualizzari tutti i contratti
     * di un utente
     * @param user: oggetto contenete i dati dell'user
     * @return una lista con tutti i contratti dell'utente
     * passato come parametro
     */
    public ArrayList<E> visualizzaContratti(E user);


}
