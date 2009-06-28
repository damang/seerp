package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiUtente;
import it.seerp.application.applicazione.conversioni.Conversione;
import it.seerp.application.applicazione.interfacce.GestioneUtenti;
import it.seerp.storage.ejb.opPersonaleRuolo.OpeUtente;
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
    public ArrayList<BeanGuiUtente> elenca(ArrayList<BeanGuiUtente> listGui) throws SQLException, ValidatorException {
    
            OpeUtente ope = new OpeUtente();
            ArrayList<Utente> list = ope.visualizzaElenco();
            int i = 0;
            for (Utente user : list) {
                listGui.add(Conversione.conversioneUtente(user, listGui.get(i)));
                i++;
            }
        return listGui;
    }

    @Override
    public ArrayList<BeanGuiUtente> ricerca(ArrayList<BeanGuiUtente> list) throws SQLException, ValidatorException {
       
            OpeUtente ope = new OpeUtente();
            ArrayList<Utente> listGui = ope.visualizzaElenco();
            int i = 0;
            for (Utente user : listGui) {
                list.add(Conversione.conversioneUtente(user, list.get(i)));
                i++;
            }
       
        return list;
    }

    @Override
    public void elimina(int id,BeanGuiUtente user)throws SQLException, ValidatorException {
       
            OpeUtente ope = new OpeUtente();
            Utente ut = Conversione.conversioneUtente(user);
            ope.elimina(ut);
        
    }

    @Override
    public void eliminazioneLogica(BeanGuiUtente user)throws SQLException, ValidatorException {
        
            OpeUtente ope = new OpeUtente();
            Utente ut = Conversione.conversioneUtente(user);
            ope.eliminaLogica(ut);
        
    }

    @Override
    public void inserisci(BeanGuiUtente user) throws SQLException, ValidatorException {
       
            OpeUtente a = new OpeUtente();
            Utente utente = Conversione.conversioneUtente(user);
            a.inserimento(utente);
       
    }

    @Override
    public BeanGuiUtente modifica(int id,BeanGuiUtente user)throws SQLException, ValidatorException{
        
            OpeUtente ope = new OpeUtente();
            Utente utente = Conversione.conversioneUtente(user);
            utente = ope.modifica(utente);
            user = Conversione.conversioneUtente(utente, user);
        
        return user;
    }

    @Override
    public BeanGuiUtente visualizzaDati(int user, BeanGuiUtente beanGui)throws SQLException, ValidatorException {
        
            OpeUtente ope = new OpeUtente();
            Utente utente = ope.visualizza(user);
            beanGui = it.seerp.application.applicazione.conversioni.Conversione.conversioneUtente(utente, beanGui);
        
        return beanGui;
    }

    @Override
    public ArrayList<Utente> visualizzaTabella() throws SQLException {
        ArrayList<Utente> list = new ArrayList<Utente>();
       
            OpeUtente ope = new OpeUtente();
            list = ope.visualizzaElenco();
        
        return list;
    }
}
