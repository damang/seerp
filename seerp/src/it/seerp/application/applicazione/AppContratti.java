package it.seerp.application.applicazione;

import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
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

    /**
     * Metodo che permette la visualizzazione della lista dei contratti
     * @return ArrayList dei contratti presenti nel sistema
     */
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
        }
        return listGui;
    }

    /**
     * Metodo che permette la visualizzazione di un singolo contratto
     * @param nome
     * criterio di visualizzazione del contratto
     * @param list
     * lista di tutti i contratti
     * @return Bean Gui del contratto che è stato selezionato
     */
    public BeanGuiContratto visualizzaContratto(String id, BeanGuiContratto gui) throws DatiErrati {
        try {
            OpContratto ope = new OpContratto();
            Contratto cont = ope.visualizza(Integer.parseInt(id));
            gui = Conversione.conversioneContratto(cont, gui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return gui;
    }

    /**
     * Metodo che permette la ricerca per dipendente
     * @param nomeDipendente
     * nome del dipendente
     * @param list
     * lista di tutti i contratti
     * @return ArrayList contentente tutti i Bean Gui dei contratti appartenenti al dipendente immesso
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<BeanGuiContratto> ricercaPerDipendente(ArrayList<BeanGuiContratto> listGui) throws DatiErrati {
        try {
            OpContratto ope = new OpContratto();
            ArrayList<Contratto> list = ope.ricercaPerDipendente();
            for (Contratto cont : list) {
                BeanGuiContratto contGui = new BeanGuiContratto();
                contGui = it.seerp.application.conversioni.Conversione.conversioneContratto(cont, contGui);
                listGui.add(contGui);
            }
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return listGui;
    }

    /**
     * Metodo che permette l'inserimento di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da inserire
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui il contratto da inserire esista già
     */
    public void inserisci(BeanGuiContratto beanGuiContratto) throws DatiErrati, DatiDuplicati {
        try {
            Contratto contratto = Conversione.conversioneContratto(beanGuiContratto);
            OpContratto a = new OpContratto();
            a.inserimento(contratto);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette la modifica di un contratto
     * @param BeanGuiContratto
     * Bean Gui del contratto da modificare
     * @return il Bean Gui del contratto modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si immettano dati errati
     */
    public BeanGuiContratto modifica(BeanGuiContratto beanGuiContratto) throws DatiErrati {
        try {
            Contratto contratto = Conversione.conversioneContratto(beanGuiContratto);
            OpContratto a = new OpContratto();
            Contratto b = a.modifica(contratto);
            beanGuiContratto = Conversione.conversioneContratto(b, beanGuiContratto);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return beanGuiContratto;
    }

    public ArrayList<Contratto> visualizzaTabella() {
        ArrayList<Contratto> list = new ArrayList<Contratto>();
        try {
            OpContratto ope = new OpContratto();
            list = ope.visualizzaElenco();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }
}
