package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiRuolo;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneRuoli;
import it.seerp.storage.Operazioni.OpRuolo;
import it.seerp.storage.ejb.Ruolo;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dei Ruoli
 * @author Tommaso Cattolico
 */
public class AppRuoli implements GestioneRuoli<BeanGuiRuolo> {

    /**
     * Metodo che permette l'inserimento di un nuovo ruolo
     * @param beanGui
     * Bean Gui del ruolo da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui si immettano dati duplicati
     */
    public void inserimento(BeanGuiRuolo beanGui) throws DatiErrati, DatiDuplicati {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo ruolo = Conversione.conversioneRuolo(beanGui);
            ope.inserimento(ruolo);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     *
     * @param bean
     * @return
     */
    public BeanGuiRuolo modifica(BeanGuiRuolo bean) {
        return null;
    }

    /**
     *
     * @param r
     * @return
     */
    public BeanGuiRuolo elimina(BeanGuiRuolo r) {
        return null;
    }
    /**
     *
     * @return
     */
    public ArrayList<BeanGuiRuolo> getElenco() {
        return null;
    }

    /**
     *
     * @param list
     * @return
     */
    public ArrayList<BeanGuiRuolo> getElenco(ArrayList<BeanGuiRuolo> list) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
