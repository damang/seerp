package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiAzienda;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Operazioni.OpAzienda;
import it.seerp.storage.ejb.Azienda;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dell'Azienda
 * @author Tommaso Cattolico
 */
public class AppAzienda {

    /**
     * Metodo che permette la modifica di un'azienda
     * @param beanGui
     * Bean Gui dell'azienda da modificare
     * @return
     * Bean Gui dell'azienda modificata
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public BeanGuiAzienda modifica(BeanGuiAzienda beanGui) throws DatiErrati {
        try {
            OpAzienda ope = new OpAzienda();
            Azienda azi = Conversione.conversioneAzienda(beanGui);
            azi = ope.modifica(azi);
            beanGui = Conversione.conversioneAzienda(azi, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGui;
    }

    /**
     * Metodo che permette la visualizzazione di una singola azienda
     * @param gui Bean Gui dell'azienda
     * @return Bean Gui dell'azienda
     * @throws DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public BeanGuiAzienda visualizzaAzienda(BeanGuiAzienda gui) throws DatiErrati {
        try {
            OpAzienda ope = new OpAzienda();
            Azienda azi = ope.visualizza();
            gui = Conversione.conversioneAzienda(azi, gui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return gui;
    }
}
