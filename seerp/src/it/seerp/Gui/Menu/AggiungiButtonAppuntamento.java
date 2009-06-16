/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.GestioneContratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class AggiungiButtonAppuntamento extends JButton implements CommandInterface {

    GestioneContratti areaContr;

    public AggiungiButtonAppuntamento() {
        super();
    }

    public AggiungiButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    public void setAreaContratti(GestioneContratti areaContr) {
        this.areaContr = areaContr;
    }

    public void execute() {
        this.setEnabled(false);
        areaContr.inizializza("");
        areaContr.getSalva().setEnabled(true);
        areaContr.getAnnulla().setEnabled(true);
        areaContr.editabile(true);
    }
}
