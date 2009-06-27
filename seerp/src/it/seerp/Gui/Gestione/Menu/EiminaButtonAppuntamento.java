
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.agenda.CalendarPanel;
import it.seerp.application.applicazione.AppAgenda;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EiminaButtonAppuntamento extends JButton implements CommandInterface{
    CalendarPanel area;

     /**
      * Costruttore della classe
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
     * Costruttore della classe
     * @param l listner preso in imput da associare al bottone
     */
    public EiminaButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
        try {
            AppAgenda a = new AppAgenda();
            a.cancellaEvento(area.getSelectedEvent().getEventoId());
            area.reset();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Impossibile eseguire! Errore dal database: " +ex.getMessage());
        }
    }


}
