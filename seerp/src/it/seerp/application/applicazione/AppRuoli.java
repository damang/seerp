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
     * Metodo che permette la modifica di un ruolo
     * @param beanGuiEventi
     * Bean Gui del ruolo da modificare
     * @return
     * Bean Gui del ruolo modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public BeanGuiRuolo modifica(BeanGuiRuolo beanGui) throws DatiErrati {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo ruo = Conversione.conversioneRuolo(beanGui);
            ruo = ope.modifica(ruo);
            beanGui = Conversione.conversioneRuolo(ruo, beanGui);
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
     *
     * @param r
     * @return
     
    public void elimina(BeanGuiRuolo r) {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo ruo = Conversione.conversioneRuolo(r);
            ope.elimina(ruo);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette la visualizzazione della lista dei ruoli
     * @return  Array List contenente la lista dei ruoli
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public ArrayList<BeanGuiRuolo> getElenco() {
        ArrayList<Ruolo> list;
        ArrayList<BeanGuiRuolo> listGui= new ArrayList<BeanGuiRuolo>();
        try {
            OpRuolo ope = new OpRuolo();
            list = ope.visualizzaElenco();
            for (Ruolo eve : list) {
                BeanGuiRuolo eveGui = new BeanGuiRuolo();
                eveGui = Conversione.conversioneRuolo(eve, eveGui);
                listGui.add(eveGui);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return listGui;
    }

    public ArrayList<Ruolo> visualizzaTabella() {
        ArrayList<Ruolo> list;
        //ArrayList<BeanGuiRuolo> listGui= new ArrayList<BeanGuiRuolo>();
        try {
            OpRuolo ope = new OpRuolo();
            list = ope.visualizzaElenco();
            return list;
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return null;
    }

}
