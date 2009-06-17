/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class AggiungiButtonContratti extends JButton implements CommandInterface {

    GestioneContratti areaContr;

    /**
     *
     */
    public AggiungiButtonContratti() {
        super();
    }

    /**
     *
     * @param l
     */
    public AggiungiButtonContratti(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    /**
     *
     * @param areaContr
     */
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
