package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneUtenti;
import it.seerp.storage.Operazioni.OpeUtente;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextField;

/**
 * classe per permette di effettuare le operazioni della Gestione
 * degli Utenti
 * @author matteo
 */
public class AppGestioneUtente implements GestioneUtenti<Utente, BeanGuiUtente> {

    /**
     * Metodo che permette di visualizzare la lista degli utenti
     * @return la lista di tutti gli utenti
     */
    public ArrayList<BeanGuiUtente> elenca(ArrayList<BeanGuiUtente> listGui) {
        OpeUtente ope = new OpeUtente();
        try {
            ArrayList<Utente> list = ope.visualizzaElenco();
            int i = 0;
            for (Utente user : list) {
                listGui.add(Conversione.conversioneUtente(user, listGui.get(i)));
                i++;
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return listGui;
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
    public ArrayList<BeanGuiUtente> ricerca(JTextField cognome, JTextField ruolo, ArrayList<BeanGuiUtente> list) throws DatiErrati, RicercaFallita {

        OpeUtente ope = new OpeUtente();
        try {
            ArrayList<Utente> listGui = ope.ricerca(cognome.getText(), ruolo.getText());
            int i = 0;
            for (Utente user : listGui) {
                list.add(it.seerp.application.conversioni.Conversione.conversioneUtente(user, list.get(i)));
                i++;
            }
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return list;
    }

    /**
     * Metodo che permette di eliminare un utente
     * @param user
     * l'utente che si vuole eliminare
     */
    public void elimina(BeanGuiUtente user) {
        OpeUtente ope = new OpeUtente();
        Utente ut = it.seerp.application.conversioni.Conversione.conversioneUtente(user);
        try {
            ope.elimina(ut);
        } catch (SQLException ex) {
            System.out.println("SQL Exception:");
            while (ex != null) {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
    }

    /**
     * Metodo che permette di nascondere un utente al sistema senza eliminarlo in maniera permanente
     * @param user
     * l'utente che si vuole eliminare logicamente
     */
    public void eliminazioneLogica(BeanGuiUtente user) {
        OpeUtente ope = new OpeUtente();
        Utente ut = it.seerp.application.conversioni.Conversione.conversioneUtente(user);
        try {
            ope.eliminaLogica(ut);
        } catch (SQLException ex) {
            System.out.println("SQL Exception:");
            while (ex != null) {
                System.out.println("State  : " + ex.getSQLState());
                System.out.println("Message: " + ex.getMessage());
                System.out.println("Error  : " + ex.getErrorCode());
                ex = ex.getNextException();
            }
        }
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
        OpeUtente a = new OpeUtente();
        Utente serv = it.seerp.application.conversioni.Conversione.conversioneUtente(user);
        try {
            a.inserimento(serv);
            user = it.seerp.application.conversioni.Conversione.conversioneUtente(serv, user);
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return user;
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
        OpeUtente ope = new OpeUtente();
        Utente utente = it.seerp.application.conversioni.Conversione.conversioneUtente(user);
        try {
            utente = ope.modifica(utente);
            user = it.seerp.application.conversioni.Conversione.conversioneUtente(utente, user);
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return user;
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
    public BeanGuiUtente visualizzaDati(JTextField user, BeanGuiUtente beanGui) throws DatiErrati {
        OpeUtente ope = new OpeUtente();
        try {
            Utente utente = ope.visualizza(Integer.parseInt(user.getText()));
            beanGui = it.seerp.application.conversioni.Conversione.conversioneUtente(utente, beanGui);
        } catch (SQLException se) {
            System.out.println("SQL Exception:");
            while (se != null) {
                System.out.println("State  : " + se.getSQLState());
                System.out.println("Message: " + se.getMessage());
                System.out.println("Error  : " + se.getErrorCode());
                se = se.getNextException();
            }
        }
        return beanGui;
    }
}
