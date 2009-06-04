package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.interfacce.GestioneUtenti;
import it.seerp.storage.Operazioni.OpResponsabile;
import it.seerp.storage.ejb.Responsabile;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * classe per permette di effettuare le operazioni della Gestione
 * degli Utenti
 * @author matteo
 */
public class AppGestioneUtente implements GestioneUtenti<Utente,BeanGuiUtente> {

        
    /**
     * Metodo che permette di visualizzare la lista degli utenti
     * @return la lista di tutti gli utenti
     */
    public ArrayList<BeanGuiUtente> elenca() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette di ricercare un utente del sistema
     * @param cognome
     * il cognome dell'utente
     * @param ruolo
     * il ruolo dell'utente
     * @param list
     * la lista di tutti gli utenti
     * @return l'utente se è trovato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel momento in cui i dati inseriti sono errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel momento in cui nn viene trovato l'elemento e la ricerca fallisce
     */
    public BeanGuiUtente ricerca(JTextField cognome, JTextField ruolo, ArrayList<BeanGuiUtente> list) throws DatiErrati, RicercaFallita {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette di eliminare un utente
     * @param user
     * l'utente che si vuole eliminare
     */
    public void elimina(BeanGuiUtente user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette di nascondere un utente al sistema senza eliminarlo in maniera permanente
     * @param user
     * l'utente che si vuole eliminare logicamente
     */
    public void eliminazioneLogica(BeanGuiUtente user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette di inserire un utente
     * @param user
     * l'utente che si vuole inserire
     * @return
     * l'utente inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui i dati inseriti sono duplicati
     */
    public BeanGuiUtente inserisci(BeanGuiUtente user) throws DatiErrati, DatiDuplicati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette di modificare i dati di un utente
     * @param user
     * l'utente del quale si vogliono modificare i dati
     * @return
     * l'utente modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    public BeanGuiUtente modifica(BeanGuiUtente user) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Metodo che permette di visualizzare i dati di un utente
     * @param user
     * l'username dell'utente
     * @param list
     * la lista di tutti gli utenti
     * @return tutti i dati di un utente
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    public BeanGuiUtente visualizzaDati(JTextField user, ArrayList<BeanGuiUtente> list) throws DatiErrati {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
