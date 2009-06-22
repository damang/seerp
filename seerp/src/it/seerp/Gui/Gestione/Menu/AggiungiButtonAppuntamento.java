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

/**
 *
 * @author Luisa
 */
public class AggiungiButtonAppuntamento extends JButton implements CommandInterface {

    CalendarPanel area;

    /**
     *
     */
    public AggiungiButtonAppuntamento() {
        super();
    }

    /**
     *
     * @param l
     */
    public AggiungiButtonAppuntamento(ActionListener l) {
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
       area.getDialogDati().inserisci();
    }
}
