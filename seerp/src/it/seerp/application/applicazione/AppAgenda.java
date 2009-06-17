package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.RicercaFallita;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.interfacce.GestioneAgenda;
import it.seerp.storage.ejb.Evento;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Operazioni.OpEvento;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dell'Agenda
 * @author Tommaso Cattolico
 */
public class AppAgenda implements GestioneAgenda<BeanGuiEvento, Evento> {

    /**
     * Metodo che permette la visualizzazione della lista degli eventi
     * @param listGui
     * @return  Array List contenente la lista degli eventi
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui vi siano dati errati
     */
    public ArrayList<BeanGuiEvento> elenca(ArrayList<BeanGuiEvento> listGui) {
        ArrayList<Evento> list;
        try {
            OpEvento ope = new OpEvento();
            list = ope.visualizzaElenco();
            for (Evento eve : list) {
                BeanGuiEvento eveGui = new BeanGuiEvento();
                eveGui = Conversione.conversioneEvento(eve, eveGui);
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

    /**
     * Metodo che permette la visualizzazione dei dettagli di un singolo evento
     * @param id
     * @param gui 
     * @return Bean Gui dell'evento
     * @throws DatiErrati
     */
    public BeanGuiEvento visualizzaDettagli(String id, BeanGuiEvento gui) throws DatiErrati {
        try {
            OpEvento ope = new OpEvento();
            Evento eve = ope.visualizza(Integer.parseInt(id));
            gui = Conversione.conversioneEvento(eve, gui);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
        return gui;
    }

    /**
     * Metodo che permette la gestione delle notifiche
     * @param beanGui
     */
    public void notificaEventi(BeanGuiEvento beanGui) {
        try {
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            ope.notificaEvento(eve);
            JOptionPane.showMessageDialog(null, "Notifica creata con successo");
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette l'inserimento di un nuovo evento
     * @param beanGui
     * @throws it.seerp.application.Exception.DatiErrati
     * in caso di inserimento di dati errati
     * @throws it.seerp.application.Exception.DatiDuplicati
     * nel caso in cui esista l'evento che si tenta di inserire
     */
    public void inserimento(BeanGuiEvento beanGui) throws DatiErrati, DatiDuplicati {
        try {
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            ope.inserimento(eve);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che permette la modifica di un evento
     * @param beanGui
     * @return
     * Bean Gui dell'evento modificato
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public BeanGuiEvento modifica(BeanGuiEvento beanGui) throws DatiErrati {
        try {
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            eve = ope.modifica(eve);
            beanGui = Conversione.conversioneEvento(eve, beanGui);
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
     * Metodo che permette la ricerca di un evento
     * @param listGui
     * @para list
     * lista di tutti gli eventi
     * @return la lista degli eventi che corrispondono ai criteri di ricerca
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     */
    public ArrayList<BeanGuiEvento> ricercaEvento(ArrayList<BeanGuiEvento> listGui) throws DatiErrati {
        try {
            OpEvento ope = new OpEvento();
            ArrayList<Evento> list = ope.ricercaEvento();
            for (Evento eve : list) {
                BeanGuiEvento eveGui = new BeanGuiEvento();
                eveGui = Conversione.conversioneEvento(eve, eveGui);
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

    /**
     * Metodo che permette la ricerca per nome di un evento
     * @param beanGui
     * @throws it.seerp.application.Exception.RicercaFallita
     * nel caso in cui la ricerca non produca risultati

    public ArrayList<BeanGuiEvento> ricercaPerNome(JTextField nome, ArrayList<BeanGuiEvento> listGui) throws DatiErrati, RicercaFallita {
    try {
    OpEvento ope = new OpEvento();
    ArrayList<Evento> list = ope.ricercaEvento(nome.getText());
    for (Evento eve : list) {
    BeanGuiEvento eveGui = new BeanGuiEvento();
    eveGui = Conversione.conversioneEvento(eve, eveGui);
    listGui.add(eveGui);
    }

    } catch (SQLException se) {
    se.printStackTrace();
    JOptionPane.showMessageDialog(null, "Errore nel database!");
    }
    return listGui;
    }

    /**
     * Metodo che permette la ricerca per giorno di un evento
     * @throws it.seerp.application.Exception.DatiErrati
     * nel caso in cui si inseriscano dati errati
     * @throws it.seerp.application.Exception.CancellazioneFallita
     * nel caso in cui il sistema fallisca nell'eliminazione dell'evento
     */
    public void cancellaEvento(BeanGuiEvento beanGui) throws CancellazioneFallita {
        try {
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            ope.cancella(eve);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Controllare i campi inseriti!");
        }
    }

    /**
     * Metodo che passa la lista di bean utilizzando l'operazioni del lato storage
     * @return lista dei bean
     */
    public ArrayList<Evento> visualizzaTabella() {
        ArrayList<Evento> list = new ArrayList<Evento>();
        try {
            OpEvento ope = new OpEvento();
            list = ope.visualizzaElenco();
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }
}
