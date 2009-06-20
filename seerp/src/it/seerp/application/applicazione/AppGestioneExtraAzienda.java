package it.seerp.application.applicazione;

import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiContatto;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Operazioni.OpCliente;
import it.seerp.storage.Operazioni.OpContatto;
import it.seerp.storage.Operazioni.OpFornitore;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.Fornitore;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe che permette la gestione delle operazione relative agli ExtraAzienda
 * @author matteo - Tommaso Cattolico
 */
public class AppGestioneExtraAzienda extends AppGestioneUtente {

    /**
     * Metodo che permette di inserire un nuovo Contatto
     * @param cont il Contatto che si vuole inserire
     */
    public void inserisciContatto(BeanGuiContatto cont) {
        super.inserisci(cont);
        try {
            OpContatto a = new OpContatto();
            Contatto co = Conversione.conversioneContatto(cont);
            a.inserisci(co);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Cliente
     * @param clien il Cliente che si vuole inserire
     */
    public void inserisciCliente(BeanGuiCliente clien) {
        //  super.inserisci(clien);
        try {
            OpCliente a = new OpCliente();
            Cliente cl = Conversione.conversioneCliente(clien);
            a.inserisci(cl);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di visualizzare i dati di un cliente
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiCliente(int user, BeanGuiCliente beanGui) {
        try {
            OpCliente ope = new OpCliente();
            Cliente utente = ope.visualizzaDati(user);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneCliente(utente, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di visualizzare i dati di un fornitore
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiFornitore(int user, BeanGuiFornitore beanGui) {
        try {
            OpFornitore ope = new OpFornitore();
            Fornitore utente = ope.visualizzaDati(user);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneFornitore(utente, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Fornitore
     * @param forn il Fornitore che si vuole inserire
     */
    public void inserisciFornitore(BeanGuiFornitore forn) {
        //  super.inserisci(forn);
        try {
            OpFornitore a = new OpFornitore();
            Fornitore fo = Conversione.conversioneFornitore(forn);
            a.inserisci(fo);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di modificare i dati di un Contatto
     * @param cont il Contatto che si deve modificare
     * @return il Contatto modificato
     */
    public BeanGuiContatto modificaContatto(BeanGuiContatto cont) {
        super.modifica(cont);
        try {
            OpContatto a = new OpContatto();
            Contatto co = Conversione.conversioneContatto(cont);
            co = a.modifica(co);
            cont = Conversione.conversioneContatto(co, cont);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return cont;
    }

    /**
     * Metodo che permette di modificare i dati di un Cliente
     * @param clien il cliente che si deve modificare
     * @return il cliente modificato
     */
    public BeanGuiCliente modificaCliente(BeanGuiCliente clien) {
        super.modifica(clien);
        try {
            OpCliente a = new OpCliente();
            Cliente cl = Conversione.conversioneCliente(clien);
            cl = a.modifica(cl);
            clien = Conversione.conversioneCliente(cl, clien);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return clien;
    }

    /**
     * Metodo che permette di modificare i dati di un Fornitore
     * @param forn il Fornitore che si vuole modificare
     * @return il Fornitore modificato
     */
    public BeanGuiFornitore modificaFornitore(BeanGuiFornitore forn) {
        super.modifica(forn);
        try {
            OpFornitore a = new OpFornitore();
            Fornitore fo = Conversione.conversioneFornitore(forn);
            fo = a.modifica(fo);
            forn = Conversione.conversioneFornitore(fo, forn);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return forn;
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Cliente> visualizzaTabellaCliente() {
        ArrayList<Cliente> list = new ArrayList<Cliente>();
        try {
            OpCliente ope = new OpCliente();
            list = ope.elencaCliente();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Fornitore> visualizzaTabellaFornitore() {
        ArrayList<Fornitore> list = new ArrayList<Fornitore>();
        try {
            OpFornitore ope = new OpFornitore();
            list = ope.elencaFornitore();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }
}
