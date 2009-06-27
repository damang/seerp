package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiFornitore;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneServizi;
import it.seerp.storage.Exception.DatiErratiEx;
import it.seerp.storage.Operazioni.OpServizio;
import it.seerp.storage.ejb.Fornitore;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dei Servizi
 * @author Tommaso Cattolico
 */
public class AppServizi implements GestioneServizi<BeanGuiServizio, Servizio> {


    public ArrayList<BeanGuiServizio> elenca(ArrayList<BeanGuiServizio> listGui)throws SQLException,ValidatorException {
        
            OpServizio ope = new OpServizio();
            ArrayList<Servizio> list = ope.visualizzaElenco();
        /* for (Servizio serv : list) {
        BeanGuiServizio servGui = new BeanGuiServizio();
        servGui = Conversione.conversioneServizio(serv, servGui);
        listGui.add(servGui);
        }*/
  
        return listGui;
    }

    @Override
    public ArrayList<BeanGuiServizio> ricerca(ArrayList<BeanGuiServizio> listGui) throws SQLException {
     
            OpServizio ope = new OpServizio();
            ArrayList<Servizio> list = ope.ricerca();
        /*   for (Servizio serv : list) {
        BeanGuiServizio servGui = new BeanGuiServizio();
        servGui = Conversione.conversioneServizio(serv, servGui);
        listGui.add(servGui);
        }*/

        return listGui;
    }

    @Override
    public void inserisci(BeanGuiServizio beanGui) throws SQLException,ValidatorException {
        {
            OpServizio ope = new OpServizio();
            Servizio serv = Conversione.conversioneServizio(beanGui);
            ope.inserimento(serv);
        }
    }

    @Override
    public BeanGuiServizio visualizza(int id, BeanGuiServizio beanGui) throws SQLException,ValidatorException {

            OpServizio ope = new OpServizio();
            Servizio serv = ope.visualizza(id);
            serv.setIdServizio(id);
            Conversione.conversioneServizio(serv, beanGui);


        
        return beanGui;
    }

    @Override
    public BeanGuiServizio modifica(int id, BeanGuiServizio beanGui) throws SQLException,ValidatorException {

            OpServizio ope = new OpServizio();
            Servizio serv = Conversione.conversioneServizio(beanGui);
            serv.setIdServizio(id);

            serv = ope.modifica(serv);
            // this.visualizza(nome, beanGui)

            // this.visualizza(nome, beanGui)

        // this.visualizza(nome, beanGui)
     
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
