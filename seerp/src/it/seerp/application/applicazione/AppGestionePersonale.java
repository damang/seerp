package it.seerp.application.applicazione;

import it.seerp.application.bean.BeanGuiAmministratore;
import it.seerp.application.bean.BeanGuiDipendente;
import it.seerp.application.bean.BeanGuiResponsabile;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Operazioni.OpAmministratore;
import it.seerp.storage.Operazioni.OpDipendente;
import it.seerp.storage.Operazioni.OpResponsabile;
import it.seerp.storage.ejb.Amministratore;
import it.seerp.storage.ejb.Dipendente;
import it.seerp.storage.ejb.Responsabile;
import java.sql.SQLException;
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
        super.inserisci(user);
        try {
            OpDipendente a = new OpDipendente();
            Dipendente dip = Conversione.conversioneDipendente(user);
            a.inserisci(dip);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette di inserire un nuovo Responsabile
     * @param user
     */
    public void inserisciResponsabile(BeanGuiResponsabile user) {
        super.inserisci(user);
        try {
            OpResponsabile a = new OpResponsabile();
            Responsabile dip = Conversione.conversioneResponsabile(user);
            a.inserisci(dip);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return user;
    }
}
