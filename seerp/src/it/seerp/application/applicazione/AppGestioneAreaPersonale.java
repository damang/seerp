package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiUtente;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneAreaPersonale;
import it.seerp.storage.ejb.Utente;
import it.seerp.storage.Operazioni.OpAreaPersonale;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe che permette di effetture le principali operazioni relative
 * alla gestionde dellì'Area Personale
 * @author matteo - Tommaso Cattolico
 */
public class AppGestioneAreaPersonale implements GestioneAreaPersonale<BeanGuiUtente> {

    /**
     * Metodo che permette di visualizzare tutti i dati relativi ad un utente
     * @param beanGui
     * @return il Bean Grafico contenente i dati dell'utente
     */
    @Override
    public BeanGuiUtente visualizzaDati(int id, BeanGuiUtente beanGui) {
        try {
            OpAreaPersonale ope = new OpAreaPersonale();
            Utente user = ope.visualizzaDati(id);
            beanGui = it.seerp.application.conversioni.Conversione.conversioneUtente(user, beanGui);
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
     * Metodo che permette di modificare la password di un utente
     * @param beanGui
     * @return il Bean grafico modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui i dati inseriti sono errati
     */
    @Override
    public BeanGuiUtente modificaPassword(BeanGuiUtente beanGui) throws DatiErrati {
        try {
            OpAreaPersonale ope = new OpAreaPersonale();
            Utente user = Conversione.conversioneUtente(beanGui);
            user = ope.modificaPassword(user);
            beanGui = Conversione.conversioneUtente(user, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGui;
    }
}
