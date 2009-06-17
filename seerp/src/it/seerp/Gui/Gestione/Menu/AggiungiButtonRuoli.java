/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Ruoli.GestioneRuoli;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Luisa
 */
public class AggiungiButtonRuoli extends JButton implements CommandInterface {

    GestioneRuoli areaContr;

    public AggiungiButtonRuoli() {
        super();
    }

    public AggiungiButtonRuoli(ActionListener l) {
        super();
        this.addActionListener(l);

    }

    public void setAreaContratti(GestioneRuoli areaContr) {
        this.areaContr = areaContr;
    }

    public void execute() {
         this.setEnabled(false);
       
    }
}
