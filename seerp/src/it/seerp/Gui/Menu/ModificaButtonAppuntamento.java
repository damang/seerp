/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import it.configurazioni.pattern.command.CommandInterface;
import it.seerp.Gui.Gestione.Contratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class ModificaButtonAppuntamento extends JButton  implements CommandInterface {
GestioneContratti areaContr=null;

    public ModificaButtonAppuntamento() {
        super();
    }

    public ModificaButtonAppuntamento(ActionListener l) {
        super();
        this.addActionListener(l);
    }



    public void setAreaContratti(GestioneContratti areaContr) {
        this.areaContr =  areaContr;
    }
    public void execute() {
       
      JOptionPane.showMessageDialog(null, "funzionalità non abilitata");
    }
}
