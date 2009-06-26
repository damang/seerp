
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.agenda.CalendarPanel;
import it.seerp.application.applicazione.AppAgenda;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class EiminaButtonAppuntamento extends JButton implements CommandInterface{
    CalendarPanel area;

     /**
      *
      * @param areaServ
      */
   public void setAreaAgenda(CalendarPanel areaContr) {
        this.area = areaContr;
    }



     /**
      *
      */
     public EiminaButtonAppuntamento() {
        super();
    }

    /**
     *
     * @param l
     */
    public EiminaButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       AppAgenda a= new AppAgenda();
       a.cancellaEvento(area.getSelectedEvent().getEventoId());
       area.reset();
    }


}
