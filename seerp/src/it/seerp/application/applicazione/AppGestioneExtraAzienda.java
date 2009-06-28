package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiCliente;
import it.seerp.application.applicazione.bean.BeanGuiContatto;
import it.seerp.application.applicazione.bean.BeanGuiExtraAzienda;
import it.seerp.application.applicazione.bean.BeanGuiFornitore;
import it.seerp.application.applicazione.conversioni.Conversione;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Operazioni.OpCliente;
import it.seerp.storage.Operazioni.OpContatto;
import it.seerp.storage.Operazioni.OpExtraAzienda;
import it.seerp.storage.Operazioni.OpFornitore;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Contatto;
import it.seerp.storage.ejb.ExtraAzienda;
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
     * @throws SQLException
     */
    public void inserisciContatto(BeanGuiContatto cont) throws SQLException, ValidatorException{
        super.inserisci(cont);
            OpContatto a = new OpContatto();
            Contatto co = Conversione.conversioneContatto(cont);
            a.inserisci(co);
       
    }

    /**
     * Metodo che permette di inserire un nuovo Cliente
     * @param clien il Cliente che si vuole inserire
     * @throws SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisciCliente(BeanGuiCliente clien) throws SQLException, ValidatorException {
        //  super.inserisci(clien);
       
            OpCliente a = new OpCliente();
            Cliente cl = Conversione.conversioneCliente(clien);
            cl.setTipo("extraazienda");
            a.inserisci(cl);
        

    }

    /**
     * Metodo che permette di visualizzare i dati di un cliente
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiCliente(int user, BeanGuiCliente beanGui) throws SQLException, ValidatorException {
      
            OpCliente ope = new OpCliente();
            Cliente utente = ope.visualizzaDati(user);
            beanGui = it.seerp.application.applicazione.conversioni.Conversione.conversioneCliente(utente, beanGui);
        
    }

    /**
     * Metodo che permette di visualizzare i dati di un fornitore
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiFornitore(int user, BeanGuiFornitore beanGui) throws SQLException, ValidatorException {
       
            OpFornitore ope = new OpFornitore();
            Fornitore utente = ope.visualizzaDati(user);
            beanGui = it.seerp.application.applicazione.conversioni.Conversione.conversioneFornitore(utente, beanGui);
       
    }

    /**
     * Metodo che permette di inserire un nuovo Fornitore
     * @param forn il Fornitore che si vuole inserire
     * @throws SQLException
     * @throws ValidatorException
     * @throws DatiDuplicatiEx
     */
    public void inserisciFornitore(BeanGuiFornitore forn) throws SQLException, ValidatorException {
        //  super.inserisci(forn);
       
            OpFornitore a = new OpFornitore();
            Fornitore fo = Conversione.conversioneFornitore(forn);
            fo.setTipo("extraazienda");
            a.inserisci(fo);
        
    }

    /**
     * Metodo che permette di modificare i dati di un Contatto
     * @param id
     * @param cont il Contatto che si deve modificare
     * @return il Contatto modificato
     * @throws SQLException
     */
    public BeanGuiContatto modificaContatto(int id, BeanGuiContatto cont) throws SQLException, ValidatorException {
//        super.modifica(cont);
       
            OpContatto a = new OpContatto();
            Contatto co = Conversione.conversioneContatto(cont);
            co = (Contatto) a.modifica(co);
            cont = Conversione.conversioneContatto(co, cont);
       
        return cont;
    }

    /**
     * Metodo che permette di modificare i dati di un Cliente
     * @param id
     * @param clien il cliente che si deve modificare
     * @return il cliente modificato
     * @throws SQLException
     */
    public BeanGuiCliente modificaCliente(int id, BeanGuiCliente clien) throws SQLException, ValidatorException {
        //   super.modifica(clien);
       
            OpExtraAzienda a = new OpExtraAzienda();
            Cliente cl = Conversione.conversioneCliente(clien);
            cl.setIdUtente(id);
            a.modifica(cl);
            this.visualizzaDatiCliente(id, clien);
            clien.setValidatorEnabled(false);
        // clien = Conversione.conversioneCliente(cl, clien);
       
        return clien;
    }

    /**
     * Metodo che permette di modificare i dati di un Fornitore
     * @param id
     * @param forn il Fornitore che si vuole modificare
     * @return il Fornitore modificato
     * @throws SQLException
     */
    public BeanGuiFornitore modificaFornitore(int id, BeanGuiFornitore forn) throws SQLException, ValidatorException {
       
            OpExtraAzienda a = new OpExtraAzienda();
            Fornitore fo = Conversione.conversioneFornitore(forn);
            fo.setIdUtente(id);
            a.modifica(fo);
            forn.setValidatorEnabled(false);
            this.visualizzaDatiFornitore(id, forn);
       
        return forn;
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Cliente> visualizzaTabellaCliente() throws SQLException {
        ArrayList<Cliente> list = new ArrayList<Cliente>();
       
            OpCliente ope = new OpCliente();
            list = ope.elencaCliente();
       
        return list;
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Fornitore> visualizzaTabellaFornitore() throws SQLException {
        ArrayList<Fornitore> list = new ArrayList<Fornitore>();
     
            OpFornitore ope = new OpFornitore();
            list = ope.elencaFornitore();
       
        return list;
    }

    /**
     * Metodo che permette la cancellazione di un utente Extra Azienda
     * @param id ID dell'utente
     * @param e Bean Gui dell'utente
     */
    public void eliminaExtraAziena(int id, BeanGuiExtraAzienda e) throws SQLException, ValidatorException {
        
            ExtraAzienda extra = new ExtraAzienda();
            OpExtraAzienda ope = new OpExtraAzienda();
            extra = Conversione.conversioneExtraAzienda(e);
            extra.setIdUtente(id);
            ope.elimina(extra);
       
    }
}
