package it.seerp.application.applicazione;

import it.seerp.application.Exception.CancellazioneFallita;
import it.seerp.application.Exception.DatiDuplicati;
import it.seerp.application.Exception.DatiErrati;
import it.seerp.application.Exception.ValidatorException;
import it.seerp.application.bean.BeanGuiEvento;
import it.seerp.application.interfacce.GestioneAgenda;
import it.seerp.storage.ejb.Evento;
import java.sql.SQLException;
import java.util.ArrayList;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.Operazioni.OpEvento;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe del livello application riguardante la Gestione dell'Agenda
 * @author Tommaso Cattolico
 */
public class AppAgenda implements GestioneAgenda<BeanGuiEvento, Evento> {

 
    @Override
    public ArrayList<BeanGuiEvento> elenca(ArrayList<BeanGuiEvento> listGui,String usr) throws SQLException {
        
            OpEvento ope;
            ope = new OpEvento();
            ope.visualizzaElenco(usr);
        
        return listGui;
    }

    @Override
    public ArrayList<String> getEventiNotificare(int id) throws SQLException {
        SimpleDateFormat formatter_data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter_ora = new SimpleDateFormat("HH:mm:ss");

        OpEvento e= new OpEvento();
        Evento ev;
        ArrayList<Evento> evs = e.eventiNotificati(id, new GregorianCalendar());
        Iterator<Evento> it= evs.iterator();
        ArrayList<String> s= new ArrayList<String>();
        while (it.hasNext()){
            ev=it.next();
            s.add(formatter_data.format(ev.getData().getTime()) + " at "+ formatter_ora.format(ev.getOra().getTime()) + " - " + ev.getNome());
        }
        return s;
    }

    @Override
    public BeanGuiEvento visualizzaDettagli(int id, BeanGuiEvento gui) throws DatiErrati,SQLException,ValidatorException {
            OpEvento ope = new OpEvento();
            Evento eve = ope.visualizza(id);
            gui = Conversione.conversioneEvento(eve, gui);
            return gui;
    }

    @Override
    public void notificaEventi(BeanGuiEvento beanGui) throws SQLException, ValidatorException {
        
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            ope.notificaEvento(eve);
            JOptionPane.showMessageDialog(null, "Notifica creata con successo");
        
    }

    @Override
    public void inserimento(BeanGuiEvento beanGui) throws SQLException, ValidatorException {
      
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            ope.inserimento(eve);
       
    }

    @Override
    public BeanGuiEvento modifica(BeanGuiEvento beanGui) throws SQLException,ValidatorException {
       
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            eve = ope.modifica(eve);
        
        return beanGui;
    }

    @Override
    public ArrayList<BeanGuiEvento> ricercaEvento(ArrayList<BeanGuiEvento> listGui) throws SQLException, ValidatorException {
       
            OpEvento ope = new OpEvento();
            ArrayList<Evento> list = ope.ricercaEvento();
            for (Evento eve : list) {
                BeanGuiEvento eveGui = new BeanGuiEvento();
                eveGui = Conversione.conversioneEvento(eve, eveGui);
                listGui.add(eveGui);
            }
        return listGui;
    }

    @Override
    public void cancellaEvento(BeanGuiEvento beanGui) throws SQLException, ValidatorException {
       
            OpEvento ope = new OpEvento();
            Evento eve = Conversione.conversioneEvento(beanGui);
            ope.cancella(eve);
       
    }
    /**
     * Metodo che permette la cancellazione dell'evento
     * @param bean Bean dell'evento da cancellare
     * @throws it.seerp.application.Exception.CancellazioneFallita
     */
    public void cancellaEvento(Evento bean) throws SQLException {
            OpEvento ope = new OpEvento();
            ope.cancella(bean);
   }

    @Override
     public void cancellaEvento(int id) throws SQLException{
         Evento e= new Evento();
         e.setIdEvento(id);
         cancellaEvento(e);
     }

    @Override
    public ArrayList<Evento> visualizzaTabella(String user) {
        ArrayList<Evento> list = new ArrayList<Evento>();
        try {
            OpEvento ope = new OpEvento();
            list = ope.visualizzaElenco(user);
        } catch (SQLException se) {
            se.printStackTrace();
            JOptionPane.showMessageDialog(null, "Errore nel database!");
        }
        return list;
    }

    @Override
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
