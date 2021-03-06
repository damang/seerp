package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.applicazione.bean.BeanGuiAmministratore;
import it.seerp.application.applicazione.bean.BeanGuiDipendente;
import it.seerp.application.applicazione.bean.BeanGuiFornitore;
import it.seerp.application.applicazione.bean.BeanGuiResponsabile;
import it.seerp.application.applicazione.conversioni.Conversione;
import it.seerp.storage.Exception.DatiDuplicatiEx;
import it.seerp.storage.Operazioni.OpAmministratore;
import it.seerp.storage.Operazioni.OpDipendente;
import it.seerp.storage.Operazioni.OpFornitore;
import it.seerp.storage.ejb.opPersonaleRuolo.OpPersonale;
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
     * Costruttore vuoto per la classe AppGestionePersonale
     */
    public AppGestionePersonale() {
        super();
    }

    /**
     * Metodo che peremette di inserire un nuovo Dipendente
     * @param user il dipendente da inserire
     * @throws SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisciDipendente(BeanGuiDipendente user) throws SQLException, ValidatorException {
        // super.inserisci(user);

        OpDipendente a = new OpDipendente();
        Dipendente dip = Conversione.conversioneDipendente(user);
        dip.setTipo("personale");
        a.inserisci(dip);

    }

    /**
     * Metodo che permette di inserire un nuovo Responsabile
     * @param user
     * @throws SQLException
     * @throws DatiDuplicatiEx
     */
    public void inserisciResponsabile(BeanGuiResponsabile user) throws SQLException, ValidatorException {
        //super.inserisci(user);

        OpResponsabile a = new OpResponsabile();
        Responsabile dip = Conversione.conversioneResponsabile(user);
        dip.setTipo("personale");
        a.inserisci(dip);

    }

    /**
     * Metodo che permette di modificare i dati di un Dipendente
     * @param id
     * @param user rappresenta il Dipendente da modificare
     * @return il Dipendente modificato
     * @throws SQLException
     */
    public BeanGuiDipendente modificaDipendente(int id, BeanGuiDipendente user) throws SQLException, ValidatorException {
        //super.modifica(user);

        OpPersonale a = new OpPersonale();
        Dipendente dip = Conversione.conversioneDipendente(user);
        dip.setIdUtente(id);
        a.modifica(dip);
        user.setValidatorEnabled(false);
        this.visualizzaDatiDipendente(id, user);

        return user;
    }

    /**
     * Metodo che permette di modificare i dati di un Amministratore
     * @param user rappresenta l'Amministratore da modificare
     * @return l'Amministratore modificato
     * @throws SQLException
     */
    public BeanGuiAmministratore modificaAmministratore(BeanGuiAmministratore user) throws SQLException, ValidatorException {
        //  super.modifica(user);

        OpAmministratore a = new OpAmministratore();
        Amministratore amm = Conversione.conversioneAmministratore(user);
        amm = (Amministratore) a.modifica(amm);
        user = Conversione.conversioneAmministratore(amm, user);

        return user;
    }

    /**
     * Metodo che permette di modificare i dati di un Responsabile
     * @param id
     * @param user il Responsabile da modificare
     * @return il Responsabile modificato
     * @throws SQLException
     */
    public BeanGuiResponsabile modificaResponsabile(int id, BeanGuiResponsabile user) throws SQLException, ValidatorException {
        // super.modifica(user);

        OpPersonale a = new OpPersonale();
        Responsabile res = Conversione.conversioneResponsabile(user);
        res.setIdUtente(id);
        user.setValidatorEnabled(false);
        a.modifica(res);
        this.visualizzaDatiResponsabile(id, user);

        return user;
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Dipendente> visualizzaTabellaDipendenti() throws SQLException {
        ArrayList<Dipendente> list = null;

        OpDipendente ope = new OpDipendente();
        list = ope.elencaDipendente();

        return list;
    }

    /**
     * Visualizza la tabella del Personale in base al Ruolo
     * @param r Ruolo per permettere la visualizzazione
     * @return ArrayList di Personale con quel Ruolo
     * @throws java.sql.SQLException
     */
    public ArrayList<Personale> visualizzaTabellaPersonaleRuolo(Ruolo r) throws SQLException {
        OpPersonale op = new OpPersonale();
        ArrayList<Personale> l = op.elencaPersonalePerRuolo(r);
        return l;
    }

    /**
     * Visualizza la tabella del Personale
     * @return ArrayList di Personale
     * @throws java.sql.SQLException
     */
    public ArrayList<Personale> visualizzaTabellaPersonale() throws SQLException {
        OpPersonale op = new OpPersonale();
        ArrayList<Personale> l = op.elencaPersonale();
        return l;

    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Responsabile> visualizzaTabellaResponsabili() throws SQLException {
        ArrayList<Responsabile> list = new ArrayList<Responsabile>();

        OpResponsabile ope = new OpResponsabile();
        list = ope.elencaResponsabile();

        return list;
    }

    /**
     * Metodo che permette la cancellazione di un cliente
     * @param id
     * @param beanGui
     * Bean Gui del cliente da eliminare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione
     */
    public void eliminaDipendente(int id, BeanGuiDipendente beanGui) throws SQLException, ValidatorException {

        OpDipendente ope = new OpDipendente();
        Dipendente dip = Conversione.conversioneDipendente(beanGui);
        dip.setIdUtente(id);
        ope.elimina(dip);

    }

    /**
     * Metodo che permette l'eliminazione di un Responsabile
     * @param id ID del Responsabile
     * @param beanGui Bean Gui del Responsabile
     * @throws it.seerp.application.Exception.CancellazioneFallita
     */
    public void eliminaResponsabile(int id, BeanGuiResponsabile beanGui) throws SQLException, ValidatorException {

        OpResponsabile ope = new OpResponsabile();
        Responsabile resp = Conversione.conversioneResponsabile(beanGui);
        resp.setIdUtente(id);
        ope.elimina(resp);

    }

    /**
     * Metodo che permette la cancellazione di un fornitore
     * @param id
     * @param beanGui
     * Bean Gui del fornitore da eliminare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione
     */
    public void eliminaFornitore(int id, BeanGuiFornitore beanGui) throws SQLException, ValidatorException {

        OpFornitore ope = new OpFornitore();
        Fornitore forn = Conversione.conversioneFornitore(beanGui);
        ope.elimina(forn);

    }

    /**
     * Metodo che permette di visualizzare i dati di un responsabile
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiResponsabile(int user, BeanGuiResponsabile beanGui) throws SQLException, ValidatorException {

        OpResponsabile ope = new OpResponsabile();
        Responsabile utente = ope.visualizzaResponsabile(user);
        beanGui = it.seerp.application.applicazione.conversioni.Conversione.conversioneResponsabile(utente, beanGui);
        AppRuoli op = new AppRuoli();
        for (String s : op.getNomeRuolo("responsabile")) {
            if (!s.equals(utente.getRuolo().getNome())) {
                beanGui.getRuolo().addItem(s);
            }
        }

    }

    /**
     * Metodo che permette di visualizzare i dati di un dipendente
     * @param user codice dell'utente
     * @param beanGui bean grafico dove inserire i dati visualizzati
     */
    public void visualizzaDatiDipendente(int user, BeanGuiDipendente beanGui) throws SQLException, ValidatorException {

        OpDipendente ope = new OpDipendente();
        Dipendente utente = ope.visualizzaDati(user);
        beanGui = it.seerp.application.applicazione.conversioni.Conversione.conversioneDipendente(utente, beanGui);
         AppRuoli op = new AppRuoli();
         for (String s : op.getNomeRuolo("dipendente")) {
            if (!s.equals(utente.getRuolo().getNome())) {
                beanGui.getRuolo().addItem(s);
            }
        }

    }
}
