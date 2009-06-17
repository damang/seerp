package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.bean.BeanGuiServizio;
import it.seerp.application.conversioni.Conversione;
import it.seerp.application.interfacce.GestioneServizi;
import it.seerp.storage.Operazioni.OpServizio;
import it.seerp.storage.ejb.Servizio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dei Servizi
 * @author Tommaso Cattolico
 */
public class AppServizi implements GestioneServizi<BeanGuiServizio, Servizio> {

    /**
     * Metodo che permette di visualizzare l'elenco dei servizi
     * @param listGui
     * @return ArrayList contenente i servizi
     */
    public ArrayList<BeanGuiServizio> elenca(ArrayList<BeanGuiServizio> listGui) {
        try {
            OpServizio ope = new OpServizio();
            ArrayList<Servizio> list = ope.visualizzaElenco();
            for (Servizio serv : list) {
                BeanGuiServizio servGui = new BeanGuiServizio();
                servGui = Conversione.conversioneServizio(serv, servGui);
                listGui.add(servGui);
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

    /**
     * Metodo che permette la ricerca di un servizio
     * @param listGui
     * Array List di bean gui da riempire coi dati che corrispondono ai criteri di ricerca
     * @return ArrayList con i servizi che corrispondono al nome inserito
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produce risultati
     */
    public ArrayList<BeanGuiServizio> ricerca(ArrayList<BeanGuiServizio> listGui) throws DatiErrati {
        try {
            OpServizio ope = new OpServizio();
            ArrayList<Servizio> list = ope.ricerca();
            for (Servizio serv : list) {
                BeanGuiServizio servGui = new BeanGuiServizio();
                servGui = Conversione.conversioneServizio(serv, servGui);
                listGui.add(servGui);
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

    /**
     * Metodo che permette l'inserimento di un nuovo servizio
     * @param beanGui
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     * @throws DatiDuplicati
     */
    public void inserisci(BeanGuiServizio beanGui) throws DatiErrati, DatiDuplicati {
        try {
            OpServizio ope = new OpServizio();
            Servizio serv = Conversione.conversioneServizio(beanGui);
            ope.inserimento(serv);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette la visualizzazione di un servizio
     * @param nome
     * nome del servizio
     * @param beanGui
     * @return Bean Gui del servizio da visualizzare
     */
    public BeanGuiServizio visualizza(String nome, BeanGuiServizio beanGui) {
        try {
            OpServizio ope = new OpServizio();
            Servizio serv = ope.visualizza(Integer.parseInt(nome));
            beanGui = Conversione.conversioneServizio(serv, beanGui);
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
     * Metodo che permette la modifica di un servizio
     * @param beanGui
     * @return Bean Gui del servizio modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati durante la modifica
     */
    public BeanGuiServizio modifica(BeanGuiServizio beanGui) throws DatiErrati {
        try {
            OpServizio ope = new OpServizio();
            Servizio serv = Conversione.conversioneServizio(beanGui);
            serv = ope.modifica(serv);
            beanGui = Conversione.conversioneServizio(serv, beanGui);
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
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
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
