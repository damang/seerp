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
 * @author Andrea
 */
public class ModificaButtonAppuntamento extends JButton  implements CommandInterface {
GestioneContratti areaContr=null;

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
    public void setAreaContratti(GestioneContratti areaContr) {
        this.areaContr =  areaContr;
    }
    public void execute() {
       
      JOptionPane.showMessageDialog(null, "funzionalità non abilitata");
    }
}
