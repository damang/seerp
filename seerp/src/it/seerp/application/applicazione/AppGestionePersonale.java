package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiCliente;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Operazioni.OpAmministratore;
import it.seerp.storage.Operazioni.OpCliente;
import it.seerp.storage.Operazioni.OpDipendente;
import it.seerp.storage.Operazioni.OpFornitore;
import it.seerp.storage.Operazioni.OpResponsabile;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Cliente;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Responsabile;
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
    public void inserisciDipendente(BeanGuiDipendente user) {
       // super.inserisci(user);
        try {
            OpDipendente a = new OpDipendente();
            Dipendente dip = Conversione.conversioneDipendente(user);
            a.inserisci(dip);
        } catch (SQLException se) {
                   while (se != null) {
	                System.out.println("State  : " + se.getSQLState());
	                System.out.println("Message: " + se.getMessage());
	                System.out.println("Error  : " + se.getErrorCode());

	                se = se.getNextException();}
          
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Responsabile
     * @param user
     */
    public void inserisciResponsabile(BeanGuiResponsabile user) {
        //super.inserisci(user);
        try {
            OpResponsabile a = new OpResponsabile();
            Responsabile dip = Conversione.conversioneResponsabile(user);
            a.inserisci(dip);
        } catch (SQLException se) {
              while (se != null) {
	                System.out.println("State  : " + se.getSQLState());
	                System.out.println("Message: " + se.getMessage());
	                System.out.println("Error  : " + se.getErrorCode());
              
	                se = se.getNextException();}
            JOptionPane.showMessageDialog(null, "Errore nel database!");
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
    public BeanGuiDipendente modificaDipendente(BeanGuiDipendente user) {
        super.modifica(user);
        try {
            OpDipendente a = new OpDipendente();
            Dipendente dip = Conversione.conversioneDipendente(user);
            dip = a.modifica(dip);
            user = Conversione.conversioneDipendente(dip, user);

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
     * Metodo che permette di modificare i dati di un Amministratore
     * @param user rappresenta l'Amministratore da modificare
     * @return l'Amministratore modificato
     */
    public BeanGuiAmministratore modificaAmministratore(BeanGuiAmministratore user) {
        super.modifica(user);
        try {
            OpAmministratore a = new OpAmministratore();
            Amministratore amm = Conversione.conversioneAmministratore(user);
            amm = (Amministratore) a.modifica(amm);
            user = Conversione.conversioneAmministratore(amm, user);
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
     * Metodo che permette di modificare i dati di un Responsabile
     * @param user il Responsabile da modificare
     * @return il Responsabile modificato
     */
    public BeanGuiResponsabile modificaResponsabile(BeanGuiResponsabile user) {
        super.modifica(user);
        try {
            OpResponsabile a = new OpResponsabile();
            Responsabile res = Conversione.conversioneResponsabile(user);
            res = a.modifica(res);
            user = Conversione.conversioneResponsabile(res, user);
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
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Dipendente> visualizzaTabellaDipendenti() {
        ArrayList<Dipendente> list = new ArrayList<Dipendente>();
        try {
            OpDipendente ope = new OpDipendente();
            list = ope.elencaDipendente();
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
    public ArrayList<Responsabile> visualizzaTabellaResponsabili() {
        ArrayList<Responsabile> list = new ArrayList<Responsabile>();
        try {
            OpResponsabile ope = new OpResponsabile();
            list = ope.elencaResponsabile();
        } catch (SQLException se) {
            se.printStackTrace();
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
    public void eliminaCliente(BeanGuiCliente beanGui) throws CancellazioneFallita {
        try {
            OpCliente ope = new OpCliente();
            Cliente cli = Conversione.conversioneCliente(beanGui);
            ope.elimina(cli);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
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
    public void eliminaFornitore(BeanGuiFornitore beanGui) throws CancellazioneFallita {
        try {
            OpFornitore ope = new OpFornitore();
            Fornitore forn = Conversione.conversioneFornitore(beanGui);
            ope.elimina(forn);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }
}
