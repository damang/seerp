/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Gestione.Menu;

import it.seerp.Gui.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Luisa
 */
public class EliminaButtonContratti extends JButton  implements CommandInterface {
   GestioneContratti areaContr;

    public void setAreaContr(GestioneContratti areaContr) {
        this.areaContr = areaContr;
    }

    public EliminaButtonContratti() {
        super();
    }

    public EliminaButtonContratti(ActionListener l) {
        super();
        this.addActionListener(l);
    }

    public void execute() {
       JOptionPane.showMessageDialog(null, "luu");
    }

}
