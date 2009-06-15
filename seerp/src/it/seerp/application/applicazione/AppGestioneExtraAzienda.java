package it.seerp.application.applicazione;

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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Cliente
     * @param clien il Cliente che si vuole inserire
     */
    public void inserisciCliente(BeanGuiCliente clien) {
        super.inserisci(clien);
        try {
            OpCliente a = new OpCliente();
            Cliente cl = Conversione.conversioneCliente(clien);
            a.inserisci(cl);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Fornitore
     * @param forn il Fornitore che si vuole inserire
     */
    public void inserisciFornitore(BeanGuiFornitore forn) {
        super.inserisci(forn);
        try {
            OpFornitore a = new OpFornitore();
            Fornitore fo = Conversione.conversioneFornitore(forn);
            a.inserisci(fo);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return forn;
    }
}
