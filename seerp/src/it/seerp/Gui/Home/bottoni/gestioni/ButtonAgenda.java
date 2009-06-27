
package it.seerp.Gui.Home.bottoni.gestioni;

import it.seerp.Gui.Gestione.agenda.EventInstance;
import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Menu.MenuAgenda;
import it.seerp.Gui.observerButton.ObserverButton;
import it.seerp.storage.ejb.Evento;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JTabbedPane;
import it.seerp.Gui.Gestione.agenda.CalendarDataRepository;
import it.seerp.Gui.Gestione.agenda.CalendarPanel;
import it.seerp.Gui.Gestione.agenda.CalendarPanelSelectionListener;
import it.seerp.Gui.Gestione.agenda.Event;
import it.seerp.Gui.Gestione.agenda.datiEvento;
import it.seerp.Gui.Home.Index;
import it.seerp.application.applicazione.AppAgenda;
import it.seerp.application.conversioni.Conversione;
import it.seerp.storage.jaas.SujGest;
import javax.security.auth.Subject;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author peppe
 */
public class ButtonAgenda extends ObserverButton implements CommandInterface {

    /**
     *
     */
    protected JTabbedPane tabbedPane;
    private MenuAgenda menu;
    CalendarPanel panel;
    String s = "Agenda";
    private Subject ut_sub;
    private datiEvento dat;

    /**
     *
     * @param pan
     * @param menu
     * @param act
     * @throws SQLException
     */
    public ButtonAgenda(JTabbedPane pan, MenuAgenda menu, Index act) throws SQLException {
        this.tabbedPane = pan;
        this.menu = menu;
        //this.panel = new AreaUtentePanel(TIPO_UTENTE_CONST.CLIENTE);

        //panel.register(this);
        this.addActionListener(act);
        this.ut_sub=act.getSubject();
        


    }

    /**
     *
     */
    public ButtonAgenda() {
        super();
    }

    public void execute() {

        if (!isPresente) {
            dat= new datiEvento(new JFrame(), true);
            this.panel = new CalendarPanel(new CalendarDataRepository() {

                @Override
                public Vector getEventInstancesForDate(int year, int month, int day) {
                    Vector ret = new Vector();

                   AppAgenda a=new AppAgenda();
                   ArrayList<Evento> e=null;
                   e=a.visualizzaTabella(SujGest.getUsername(ut_sub));
                   for (Evento evento : e) {
                        //  System.out.println(year + "/"+month + "/"+day + " " + evento.getData().getTimeInMillis() + " nuobo: " +
                        //      new GregorianCalendar(year, month, day).getTimeInMillis()
                        //     );
                        if (evento.getData().get(GregorianCalendar.YEAR) == year && evento.getData().get(GregorianCalendar.MONTH) == month - 1 && evento.getData().get(GregorianCalendar.DAY_OF_MONTH) == day) {
                            //System.out.println("ok ci sto: " + evento.getIdEvento());
                            ret.addElement(new Event(evento.getNome(),evento.getTema(), year, month, day, evento.getOra().get(GregorianCalendar.HOUR_OF_DAY),
                                    evento.getOra().get(GregorianCalendar.MINUTE), evento.getOra().get(GregorianCalendar.SECOND),true,true,evento.getIdEvento()));
                        }
                    }
                    return ret;
                }
            },dat,SujGest.getIdUtente(ut_sub));
            dat.setCalendarPannel(this.panel);
         
            this.panel.addSelectionListener(new CalendarPanelSelectionListener() {

                @Override
                public void eventSelected(EventInstance eventInstance) {
                    
                }

                @Override
                public void eventUnselected() {
                    
                }

                @Override
                public void eventDoubleClicked(EventInstance eventInstance) {
                    try {
                        Evento e = Conversione.conversioneEvento(eventInstance);
                        dat.visualizza(e);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Errore dal database!");
                    }
                }

                @Override
                public void dateDoubleClicked(int year, int month, int dayOfMonth) {
                    JOptionPane.showMessageDialog(null, year + " "+ month + " " + dayOfMonth);
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
