/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.bottoni.Nuovo;

import configurazioni.CommandInterface;
import it.seerp.Gui.Menu.MenuAppuntamento;
import it.seerp.Gui.Menu.MenuRuoli;
import it.seerp.Gui.command.ObserverButton;
import it.seerp.storage.ejb.Evento;
import it.seerp.storage.operazioni.OpEvento;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JTabbedPane;
import it.seerp.Gui.Gestione.agenda.CalendarDataRepository;
import it.seerp.Gui.Gestione.agenda.CalendarPanel;
import it.seerp.Gui.Gestione.agenda.Event;



/**
 *
 * @author peppe
 */
public class ButtonAgenda extends ObserverButton implements CommandInterface{

    protected JTabbedPane tabbedPane;
    private MenuAppuntamento menu;
    CalendarPanel panel;
    String s = "Agenda";

    /**
     *
     * @param gruppoFinestreUpdate
     * @param aThis
     */
    public ButtonAgenda(JTabbedPane pan, MenuAppuntamento menu, ActionListener act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;
        //this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);

    //panel.register(this);
        this.addActionListener(act);


    }

    public ButtonAgenda() {
        super();
    }

    public void execute() {

        if (!isPresente) {
           
               this.panel = new CalendarPanel(new CalendarDataRepository() {
                   public Vector getEventInstancesForDate(int year, int month, int day) {
                        Vector ret = new Vector ();

                       OpEvento op;
                       ArrayList<Evento> e=null;
                    try {
                        op = new OpEvento();
                        e= op.visualizzaElenco();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                       
                        for (Evento evento : e) {
                          //  System.out.println(year + "/"+month + "/"+day + " " + evento.getData().getTimeInMillis() + " nuobo: " +
                             //      new GregorianCalendar(year, month, day).getTimeInMillis()
                               //     );
                            if(evento.getData().get(GregorianCalendar.YEAR)==year && evento.getData().get(GregorianCalendar.MONTH)==month-1 && evento.getData().get(GregorianCalendar.DAY_OF_MONTH)==day)
                                    {
                                System.out.println("ok ci sto: " + evento.toString());
                                ret.addElement ( new Event ( evento.getTema(),
                evento.getLuogo(), year, month,  day, evento.getOra().get(GregorianCalendar.HOUR),
                         evento.getOra().get(GregorianCalendar.MINUTE), evento.getOra().get(GregorianCalendar.SECOND)));
                            }
                        }
                        return ret;
                    }
                });
                panel.register(this);
           


            isPresente = true;
            this.tabbedPane.addTab(s, panel);
            System.out.println(this.tabbedPane.getTabCount() - 1);
            ButtonTabComponent button = new ButtonTabComponent(this.tabbedPane, this.panel, this.menu);
            this.tabbedPane.setTabComponentAt(this.tabbedPane.getTabCount() - 1, button);
            panel.setVisible(true);



            panel.repaint();
            this.tabbedPane.setSelectedComponent(panel);
            this.setEnabled(false);


        }
    }

}
