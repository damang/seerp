package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiContratto;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneContratti;
import it.seerp.storage.Operazioni.OpContratto;
import it.seerp.storage.ejb.Contratto;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dei Contratti
 * @author Tommaso Cattolico
 */
public class AppContratti implements GestioneContratti<BeanGuiContratto, Contratto> {

    @Override
    public ArrayList<BeanGuiContratto> elenca(ArrayList<BeanGuiContratto> listGui) {
        try {
            OpContratto ope = new OpContratto();
            ArrayList<Contratto> list = ope.visualizzaElenco();
            for (Contratto cont : list) {
                BeanGuiContratto contGui = new BeanGuiContratto();
                contGui = Conversione.conversioneContratto(cont, contGui);
                listGui.add(contGui);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return listGui;
    }

    @Override
    public BeanGuiContratto visualizzaContratto(int id, BeanGuiContratto gui) throws DatiErrati {
        try {
            OpContratto ope = new OpContratto();
            Contratto cont = ope.visualizza(id);
            gui = Conversione.conversioneContratto(cont, gui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return gui;
    }

    @Override
    public ArrayList<BeanGuiContratto> ricercaPerDipendente(ArrayList<BeanGuiContratto> listGui) throws DatiErrati {
        try {
            OpContratto ope = new OpContratto();
            ArrayList<Contratto> list = ope.ricercaPerDipendente();
            for (Contratto cont : list) {
                BeanGuiContratto contGui = new BeanGuiContratto();
                contGui = Conversione.conversioneContratto(cont, contGui);
                listGui.add(contGui);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return listGui;
    }

    @Override
    public void inserisci(BeanGuiContratto beanGuiContratto) throws SQLException, ValidatorException {
        Contratto contratto = Conversione.conversioneContratto(beanGuiContratto);
        OpContratto a = new OpContratto();
        a.inserimento(contratto);
    }

    @Override
    public BeanGuiContratto modifica(
            BeanGuiContratto beanGuiContratto) throws DatiErrati {
        try {
            Contratto contratto = Conversione.conversioneContratto(beanGuiContratto);
            OpContratto a = new OpContratto();
            Contratto b = a.modifica(contratto);
            beanGuiContratto = Conversione.conversioneContratto(b, beanGuiContratto);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGuiContratto;
    }

    @Override
    public ArrayList<Contratto> visualizzaTabella() {
        ArrayList<Contratto> list = new ArrayList<Contratto>();
        try {
            OpContratto ope = new OpContratto();
            list =
                    ope.visualizzaElenco();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }
}
