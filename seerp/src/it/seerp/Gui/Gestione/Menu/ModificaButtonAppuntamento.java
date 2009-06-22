/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import it.seerp.Gui.Gestione.agenda.CalendarPanel;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class ModificaButtonAppuntamento extends JButton  implements CommandInterface {
CalendarPanel area;

/**
 *
 */
public ModificaButtonAppuntamento() {
        super();
    }

/**
 *
 * @param l
 */
public ModificaButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);
    }



    /**
     *
     * @param areaContr
     */
    public void setAreaAgenda(CalendarPanel areaContr) {
        this.area = areaContr;
    }
    public void execute() {
       
      
    }
}
