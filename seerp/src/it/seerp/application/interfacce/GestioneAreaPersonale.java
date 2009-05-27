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
     * @param username:stringa di caratteri che rappresenta l'username dell'utente
     */
    public BeanGuiUtente visualizzaDati(Utente user);

    /**
     * è un metodo che permette di modificare i dati personali di un utente
     * @param user: oggetto contenente i dati dell'utente
     */
   
    public BeanGuiUtente modificaPassword(BeanGuiUtente user);

    /**
     * è un metodo che permette di visualizzari tutti i contratti
     * di un utente
     * @param username: stringa di caratteriche rappresenta l'username dell'utente
     * @return una lista con tutti i contratti dell'utente
     * passato come parametro
     */
    public ArrayList<E> visualizzaContratti(String username);


}
