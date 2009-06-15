/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.seerp.Gui.Menu;

import configurazioni.CommandInterface;
import it.seerp.Gui.GestioneContratti.GestioneContratti;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrea
 */
public class ModificaButtonContratti extends JButton  implements CommandInterface {
GestioneContratti areaContr=null;

    public ModificaButtonContratti() {
        super();
    }

    public ModificaButtonContratti(ActionListener l) {
        super();
        this.addActionListener(l);
    }



    public void setAreaContratti(GestioneContratti areaContr) {
        this.areaContr =  areaContr;
    }
    public void execute() {
      areaContr.editabilePagamento(true);
     areaContr.getSalva().setEnabled(true);
    areaContr.getAnnulla().setEnabled(true);}
}
