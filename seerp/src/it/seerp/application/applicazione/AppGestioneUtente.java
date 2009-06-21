package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneUtenti;
import it.seerp.storage.Operazioni.OpeUtente;
import it.seerp.storage.ejb.Utente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * classe per permette di effettuare le operazioni della Gestione
 * degli Utenti
 * @author matteo
 */
public class AppGestioneUtente implements GestioneUtenti<Utente, BeanGuiUtente> {

    /**
     * Metodo che permette di visualizzare la lista degli utenti
     * @param listGui
     * @return la lista di tutti gli utenti
     */
    public ArrayList<BeanGuiUtente> elenca(ArrayList<BeanGuiUtente> listGui) {
        try {
            OpeUtente ope = new OpeUtente();
            ArrayList<Utente> list = ope.visualizzaElenco();
            int i = 0;
            for (Utente user : list) {
                listGui.add(Conversione.conversioneUtente(user, listGui.get(i)));
                i++;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return listGui;
    }

    /**
     * Metodo che permette di ricercare un utente del sistema
     * @param list
     * la lista di tutti gli utenti
     * @return l'utente se è trovato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel momento in cui i dati inseriti sono errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel momento in cui nn viene trovato l'elemento e la ricerca fallisce
     */
    public ArrayList<BeanGuiUtente> ricerca(ArrayList<BeanGuiUtente> list) throws DatiErrati, RicercaFallita {
        try {
            OpeUtente ope = new OpeUtente();
            ArrayList<Utente> listGui = ope.visualizzaElenco();
            int i = 0;
            for (Utente user : listGui) {
                list.add(Conversione.conversioneUtente(user, list.get(i)));
                i++;
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return list;
    }

    /**
     * Metodo che permette di eliminare un utente
     * @param user
     * l'utente che si vuole eliminare
     */
    public void elimina(BeanGuiUtente user) {
        try {
            OpeUtente ope = new OpeUtente();
            Utente ut = Conversione.conversioneUtente(user);
            ope.elimina(ut);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di nascondere un utente al sistema senza eliminarlo in maniera permanente
     * @param user
     * l'utente che si vuole eliminare logicamente
     */
    public void eliminazioneLogica(BeanGuiUtente user) {
        try {
            OpeUtente ope = new OpeUtente();
            Utente ut = Conversione.conversioneUtente(user);
            ope.eliminaLogica(ut);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
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
    public void inserisci(BeanGuiUtente user) throws DatiErrati, DatiDuplicati {
        try {
            OpeUtente a = new OpeUtente();
            Utente utente = Conversione.conversioneUtente(user);
            a.inserimento(utente);

        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }

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
        try {
            OpeUtente ope = new OpeUtente();
            Utente utente = Conversione.conversioneUtente(user);
            utente = ope.modifica(utente);
            user = Conversione.conversioneUtente(utente, user);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return user;
    }

    /**
     * Metodo che permette di visualizzare i dati di un utente
     * @param user
     * l'username dell'utente
     * @param beanGui
     * @return tutti i dati di un utente
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    public BeanGuiUtente visualizzaDati(int user, BeanGuiUtente beanGui) throws DatiErrati {
        try {
            OpeUtente ope = new OpeUtente();
            Utente utente = ope.visualizza(user);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneUtente(utente, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGui;
    }

    public void visualizzaDati(String user, BeanGuiUtente utente) throws SQLException {
         OpeUtente ope = new OpeUtente();
         Utente ut = ope.visualizza(user);
         Conversione.conversioneUtente(ut, utente);
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Utente> visualizzaTabella() {
        ArrayList<Utente> list = new ArrayList<Utente>();
        try {
            OpeUtente ope = new OpeUtente();
            list = ope.visualizzaElenco();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }
}
