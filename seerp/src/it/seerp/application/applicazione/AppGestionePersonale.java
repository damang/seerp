package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Operazioni.OpAmministratore;
import it.seerp.storage.Operazioni.OpDipendente;
import it.seerp.storage.Operazioni.OpFornitore;
import it.seerp.storage.Operazioni.OpPersonale;
import it.seerp.storage.Operazioni.OpResponsabile;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Personale;
import it.seerp.storage.ejb.Responsabile;
import it.seerp.storage.ejb.Ruolo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe che permette di effettuare delle operazioni sul Personale
 * @author matteo - Tommaso Cattolico
 */
public class AppGestionePersonale extends AppGestioneUtente {

    /**
     *Costruttore vuoto per la classe AppGestionePersonale
     */
    public AppGestionePersonale() {
        super();
    }

    /**
     * Metodo che peremette di inserire un nuovo Dipendente
     * @param user il dipendente da inserire
     */
    public void inserisciDipendente(BeanGuiDipendente user) throws SQLException {
        // super.inserisci(user);
        try {
            OpDipendente a = new OpDipendente();
            Dipendente dip = Conversione.conversioneDipendente(user);
            a.inserisci(dip);
        } catch (DatiDuplicatiEx e) {
            JOptionPane.showMessageDialog(null, "Dati duplicati");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Responsabile
     * @param user
     */
    public void inserisciResponsabile(BeanGuiResponsabile user) throws SQLException {
        //super.inserisci(user);
        try {
            OpResponsabile a = new OpResponsabile();
            Responsabile dip = Conversione.conversioneResponsabile(user);
            a.inserisci(dip);
        } catch (DatiDuplicatiEx e) {
            JOptionPane.showMessageDialog(null, "Dati duplicati");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di modificare i dati di un Dipendente
     * @param user rappresenta il Dipendente da modificare
     * @return il Dipendente modificato
     */
    public BeanGuiDipendente modificaDipendente(int id, BeanGuiDipendente user) throws SQLException {
        //super.modifica(user);
        try {
            OpPersonale a = new OpPersonale();
            Dipendente dip = Conversione.conversioneDipendente(user);
            dip.setIdUtente(id);
            a.modifica(dip);
            this.visualizzaDatiDipendente(id, user);
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return user;
    }

    /**
     * Metodo che permette di modificare i dati di un Amministratore
     * @param user rappresenta l'Amministratore da modificare
     * @return l'Amministratore modificato
     */
    public BeanGuiAmministratore modificaAmministratore(BeanGuiAmministratore user) throws SQLException {
        //  super.modifica(user);
        try {
            OpAmministratore a = new OpAmministratore();
            Amministratore amm = Conversione.conversioneAmministratore(user);
            amm = (Amministratore) a.modifica(amm);
            user = Conversione.conversioneAmministratore(amm, user);
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return user;
    }

    /**
     * Metodo che permette di modificare i dati di un Responsabile
     * @param user il Responsabile da modificare
     * @return il Responsabile modificato
     */
    public BeanGuiResponsabile modificaResponsabile(int id, BeanGuiResponsabile user) throws SQLException {
        // super.modifica(user);
        try {
            OpPersonale a = new OpPersonale();
            Responsabile res = Conversione.conversioneResponsabile(user);
            res.setIdUtente(id);
            a.modifica(res);
            this.visualizzaDatiResponsabile(id, user);
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return user;
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Dipendente> visualizzaTabellaDipendenti() {
        ArrayList<Dipendente> list = null;
        try {
            OpDipendente ope = new OpDipendente();
            list = ope.elencaDipendente();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }

    public ArrayList<Personale> visualizzaTabellaPersonaleRuolo(Ruolo r) throws SQLException {
        OpPersonale op = new OpPersonale();
        ArrayList<Personale> l = op.elencaPersonalePerRuolo(r);
        return l;

    }

    public ArrayList<Personale> visualizzaTabellaPersonale() throws SQLException {
        OpPersonale op = new OpPersonale();
        ArrayList<Personale> l = op.elencaPersonale();
        return l;

    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Responsabile> visualizzaTabellaResponsabili() {
        ArrayList<Responsabile> list = new ArrayList<Responsabile>();
        try {
            OpResponsabile ope = new OpResponsabile();
            list = ope.elencaResponsabile();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }

    /**
     * Metodo che permette la cancellazione di un cliente
     * @param beanGui
     * Bean Gui del cliente da eliminare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione
     */
    public void eliminaDipendente(int id, BeanGuiDipendente beanGui) throws CancellazioneFallita {
        try {
            OpDipendente ope = new OpDipendente();
            Dipendente dip = Conversione.conversioneDipendente(beanGui);
            dip.setIdUtente(id);
            ope.elimina(dip);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    public void eliminaResponsabile(int id, BeanGuiResponsabile beanGui) throws CancellazioneFallita {
        try {
            OpResponsabile ope = new OpResponsabile();
            Responsabile resp = Conversione.conversioneResponsabile(beanGui);
            resp.setIdUtente(id);
            ope.elimina(resp);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette la cancellazione di un fornitore
     * @param beanGui
     * Bean Gui del fornitore da eliminare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione
     */
    public void eliminaFornitore(int id, BeanGuiFornitore beanGui) throws CancellazioneFallita {
        try {
            OpFornitore ope = new OpFornitore();
            Fornitore forn = Conversione.conversioneFornitore(beanGui);
            ope.elimina(forn);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di visualizzare i dati di un responsabile
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiResponsabile(int user, BeanGuiResponsabile beanGui) {
        try {
            OpResponsabile ope = new OpResponsabile();
            Responsabile utente = ope.visualizzaResponsabile(user);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneResponsabile(utente, beanGui);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di visualizzare i dati di un dipendente
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiDipendente(int user, BeanGuiDipendente beanGui) {
        try {
            OpDipendente ope = new OpDipendente();
            Dipendente utente = ope.visualizzaDati(user);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneDipendente(utente, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }
}
