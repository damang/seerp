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
 * Classe per permette di effettuare le operazioni della Gestione
 * degli Utenti
 * @author matteo
 */
public class AppGestioneUtente implements GestioneUtenti<Utente, BeanGuiUtente> {

    @Override
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

    @Override
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

    @Override
    public void elimina(int id,BeanGuiUtente user) {
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

    @Override
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

    @Override
    public void inserisci(BeanGuiUtente user) throws DatiErrati, DatiDuplicati, SQLException {
        try {
            OpeUtente a = new OpeUtente();
            Utente utente = Conversione.conversioneUtente(user);
            a.inserimento(utente);
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    @Override
    public BeanGuiUtente modifica(int id,BeanGuiUtente user) throws DatiErrati, SQLException{
        try {
            OpeUtente ope = new OpeUtente();
            Utente utente = Conversione.conversioneUtente(user);
            utente = ope.modifica(utente);
            user = Conversione.conversioneUtente(utente, user);
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return user;
    }

    @Override
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

    @Override
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
