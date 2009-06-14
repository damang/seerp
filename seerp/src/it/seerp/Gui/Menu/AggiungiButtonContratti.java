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
public class AggiungiButtonContratti extends JButton implements CommandInterface {

    GestioneContratti areaContr;

    public AggiungiButtonContratti() {
        super();
    }

    public AggiungiButtonContratti(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    public void setAreaContratti(GestioneContratti areaContr) {
        this.areaContr = areaContr;
    }

    public void execute() {
        areaContr.inizializza("");
        areaContr.getSalva().setEnabled(true);
        areaContr.getAnnulla().setEnabled(true);
        areaContr.editabile(true);
    }
}
