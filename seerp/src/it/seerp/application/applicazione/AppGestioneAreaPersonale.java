package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiExtraAzienda;
import it.seerp.application.bean.BeanGuiPersonale;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneAreaPersonale;
import it.seerp.storage.ejb.Utente;
import it.seerp.storage.Operazioni.OpAreaPersonale;
import it.seerp.storage.ejb.ExtraAzienda;
import it.seerp.storage.ejb.Personale;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe che permette di effetture le principali operazioni relative
 * alla gestionde dellì'Area Personale
 * @author matteo - Tommaso Cattolico
 */
public class AppGestioneAreaPersonale implements GestioneAreaPersonale<BeanGuiUtente> {

    @Override
    public BeanGuiUtente visualizzaDati(int id, BeanGuiUtente beanGui) {
        Utente user;
        try {
            OpAreaPersonale ope = new OpAreaPersonale();
            if (beanGui.getTipo().equals("Personale")) {
                user = ope.visualizzaDatiPersonale(beanGui.getTxtUsername().getText());
            } else {
                user = ope.visualizzaDatiExtraAzienda(beanGui.getTxtUsername().getText());
            }
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
    public BeanGuiUtente modificaPassword(BeanGuiUtente beanGui) throws DatiErrati {
        try {
            OpAreaPersonale ope = new OpAreaPersonale();

            Utente user = Conversione.conversionePersonale(beanGui);
            ope.modificaPassword(user);
        //beanGui = Conversione.conversioneUtente(user, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGui;
    }

    /**
     * Metodo che visualizza i dati del personale
     * @param id ID del personale
     * @param beanGui Bean Gui del personale
     */
    public void visualizzaDatiPersonale(String id, BeanGuiPersonale beanGui) {
        Personale user;
        try {
            OpAreaPersonale ope = new OpAreaPersonale();

            beanGui.getTxtUsername().setText(id);
            user = ope.visualizzaDatiPersonale(beanGui.getTxtUsername().getText());
            Conversione.conversioneAreaPersonalePer(user, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che visualizza i dati di un Extra Azienda
     * @param id ID dell'Extra Azienda
     * @param beanGui Bean Gui dell'Extra Azienda
     */
    public void visualizzaDatiExtraAzienda(String id, BeanGuiExtraAzienda beanGui) {
        ExtraAzienda user;
        try {
            OpAreaPersonale ope = new OpAreaPersonale();
            beanGui.getTxtUsername().setText(id);
            user = ope.visualizzaDatiExtraAzienda(beanGui.getTxtUsername().getText());
            Conversione.conversioneAreaPersonaleExtra(user, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }
}
