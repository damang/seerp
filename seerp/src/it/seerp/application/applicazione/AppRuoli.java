package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiRuolo;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneRuoli;
import it.seerp.storage.Operazioni.OpRuolo;
import it.seerp.storage.ejb.Ruolo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Classe del livello application riguardante la Gestione dei Ruoli
 * @author Tommaso Cattolico
 */
public class AppRuoli implements GestioneRuoli<BeanGuiRuolo, Ruolo> {

    @Override
    public void inserimento(BeanGuiRuolo beanGui) throws SQLException, DatiErrati, DatiDuplicati {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo ruolo = Conversione.conversioneRuolo(beanGui);
            ope.inserimento(ruolo);
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    @Override
    public BeanGuiRuolo modifica(BeanGuiRuolo beanGui) throws DatiErrati {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo ruo = Conversione.conversioneRuolo(beanGui);
            ruo = ope.modifica(ruo);
        //beanGui = Conversione.conversioneRuolo(ruo, beanGui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        } catch (Exception ex) {
            Logger.getLogger(AppRuoli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beanGui;
    }

    @Override
    public void elimina(BeanGuiRuolo r) {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo ruo = Conversione.conversioneRuolo(r);
            ope.elimina(ruo);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    @Override
    public void elimina(String r) {
        try {
            OpRuolo ope = new OpRuolo();
            ope.elimina(new Ruolo(r));
        } catch (SQLException se) {
            se.printStackTrace();
            switch (se.getErrorCode()) {
                case 1451:
                    JOptionPane.showMessageDialog(null, "Impossibile eliminare perchè il ruolo è assegnato!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Errore nel database!");
                    break;
            }
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    @Override
    public ArrayList<BeanGuiRuolo> getElenco() {
        ArrayList<Ruolo> list;
        ArrayList<BeanGuiRuolo> listGui = new ArrayList<BeanGuiRuolo>();
        try {
            OpRuolo ope = new OpRuolo();
            list = ope.visualizzaElenco();
            for (Ruolo eve : list) {
                BeanGuiRuolo eveGui = new BeanGuiRuolo(new JPanel());
                //    eveGui = Conversione.conversioneRuolo(eve, eveGui);
                listGui.add(eveGui);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        } catch (Exception ex) {
            Logger.getLogger(AppRuoli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listGui;
    }

    @Override
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
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return null;
    }

    @Override
    public void visualizzaDati(String nome, BeanGuiRuolo b) {
        try {
            OpRuolo ope = new OpRuolo();
            Ruolo r = ope.visualizza(nome);
            Conversione.conversioneRuolo(r, b);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }

    }

    @Override
    public ArrayList<String> getNomeRuolo(String s) {
        ArrayList<String> list = new ArrayList<String>();
        OpRuolo op;
        try {
            op = new OpRuolo();
            Iterator<Ruolo> it = op.GetListaRuoli(s).iterator();
            while (it.hasNext()) {
                list.add(it.next().getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppRuoli.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
