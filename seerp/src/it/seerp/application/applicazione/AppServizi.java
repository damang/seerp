package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneServizi;
import it.seerp.storage.Operazioni.OpServizio;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dei Servizi
 * @author Tommaso Cattolico
 */
public class AppServizi implements GestioneServizi<BeanGuiServizio, Servizio,BeanGuiFornitore> {

    @Override
    public ArrayList<BeanGuiServizio> elenca(ArrayList<BeanGuiServizio> listGui) {
        try {
            OpServizio ope = new OpServizio();
            ArrayList<Servizio> list = ope.visualizzaElenco();
           /* for (Servizio serv : list) {
                BeanGuiServizio servGui = new BeanGuiServizio();
                servGui = Conversione.conversioneServizio(serv, servGui);
                listGui.add(servGui);
            }*/
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
    public ArrayList<BeanGuiServizio> ricerca(ArrayList<BeanGuiServizio> listGui) throws DatiErrati {
        try {
            OpServizio ope = new OpServizio();
            ArrayList<Servizio> list = ope.ricerca();
         /*   for (Servizio serv : list) {
                BeanGuiServizio servGui = new BeanGuiServizio();
                servGui = Conversione.conversioneServizio(serv, servGui);
                listGui.add(servGui);
            }*/
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
    public void inserisci(BeanGuiServizio beanGui) throws DatiErrati, DatiDuplicati, SQLException {
        try {
            OpServizio ope = new OpServizio();
            Servizio serv = Conversione.conversioneServizio(beanGui);
            ope.inserimento(serv);
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    @Override
    public BeanGuiServizio visualizza(int id, BeanGuiServizio beanGui, BeanGuiFornitore forni) {
        try {
            OpServizio ope = new OpServizio();
            Servizio serv = ope.visualizza(id);
            serv.setIdServizio(id);
            
            Fornitore forn=ope.visualizzaFornitore(serv.getIdServizio());
          
           // beanGui =

           Conversione.conversioneServizio(serv, beanGui);
           Conversione.conversioneServiziFor(forn,forni);
            
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
    public BeanGuiServizio modifica(int id,BeanGuiServizio beanGui) throws DatiErrati, SQLException {
        try {
            OpServizio ope = new OpServizio();
            Servizio serv = Conversione.conversioneServizio(beanGui);
            serv.setIdServizio(id);
            serv = ope.modifica(serv);
          // this.visualizza(nome, beanGui)
        } catch (ValidatorException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGui;
    }

    @Override
    public ArrayList<Servizio> visualizzaTabella() {
        ArrayList<Servizio> list = new ArrayList<Servizio>();
        try {
            OpServizio ope = new OpServizio();
            list = ope.visualizzaElenco();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }
}
